package me.bristermitten.plumber.aspect

import com.google.common.collect.HashMultimap
import com.google.common.collect.Multimap
import com.google.inject.Guice
import com.google.inject.Injector
import com.google.inject.Key
import dev.misfitlabs.kotlinguice4.KotlinModule
import io.github.classgraph.ClassGraph
import me.bristermitten.plumber.PlumberPlugin
import me.bristermitten.plumber.reflection.ClassFinder
import me.bristermitten.plumber.reflection.Reflection.createGuiceModule
import me.bristermitten.plumber.util.getAnnotation
import me.bristermitten.plumber.util.getInstance
import me.bristermitten.plumber.util.isAnnotationPresent
import java.util.*
import kotlin.reflect.KClass

/**
 * Class responsible for loading the entirety of Plumber.
 *
 */
class PlumberLoader(private val plugin: PlumberPlugin) {

    /**
     * Map of Annotations to their target aspects. This is comprised of:
     * [AspectAnnotation]s to their targets
     * Aspect classes to any [LoadIfPresent] targets
     */
    private val bindings: MutableMap<Class<out Annotation>, Class<out Aspect>> = WeakHashMap()
    /**
     * Multimap of classes associated with an Aspect.
     * This is comprised of any classes annotated with any [AspectAnnotation]s *anywhere* in the class
     * An Aspect's classes will also be provided to it in its [Aspect.enable] method.
     */
    private val aspectClasses: Multimap<Class<out Aspect>, Class<*>> = HashMultimap.create()

    /**
     * Commence loading of Plumber
     */
    fun loadPlumber() {
        bindings.clear()
        aspectClasses.clear()


        val classGraph = createClassGraph()

        var injector = Guice.createInjector(object : KotlinModule() {
            override fun configure() {
                bind<ClassGraph>().toInstance(classGraph)
            }
        })

        val classFinder = injector.getInstance(ClassFinder::class)

        val holder = injector.getInstance(InjectorHolder::class)


        val aspects = classFinder.getClassesImplementing(Aspect::class)
        loadBindings(classFinder, aspects)

        aspects
                .asSequence()
                .filter {
                    if (it.isAnnotationPresent(RequiredAspect::class)) true
                    else aspectClasses[it].isNotEmpty()
                }
                .sortedByDescending { it.getAnnotation(RequiredAspect::class)?.priority ?: Int.MIN_VALUE}
                .forEach {
                    injector = loadAspect(injector, it)
                    holder.injector = injector
                }

        holder.lock(injector)
    }

    private fun createClassGraph(): ClassGraph {
        //whitelist the caller's package (eg me.author.plugin)
        val externalPluginPackage = plugin.javaClass.`package`.name
        //whitelist Plumber to load internals (me.bristermitten.plumber)
        val plumberPackage = PlumberPlugin::class.java.`package`.name

        val packages = arrayOf(externalPluginPackage, plumberPackage)

        return ClassGraph()
                //enable method, annotation, and field scanning
                .enableAllInfo()
                //Only scan important packages
                .whitelistPackages(*packages)
                //no need to spend time scanning these
                .disableRuntimeInvisibleAnnotations()
                //No reason to have this
                .disableNestedJarScanning()
                //Gives a significant speed boost and all our classes are already loaded so not necessary
                .disableJarScanning()
    }

    private fun loadBindings(classFinder: ClassFinder, aspects: Collection<Class<out Aspect>>) {
        classFinder.getClassesAnnotatedWith(AspectAnnotation::class)
                .asSequence()
                .filter { it.isAnnotation }
                .map {
                    @Suppress("UNCHECKED_CAST")
                    it as Class<out Annotation>
                }
                .forEach {
                    val target = it.getAnnotation(AspectAnnotation::class)!!.target.java
                    bindings[it] = target
                    aspectClasses.putAll(target, classFinder.getClassesWithAnnotationAnywhere(it))
                }

        aspects.asSequence().filter { aspectClass ->
            aspectClass.isAnnotationPresent(LoadIfPresent::class)
        }.map {
            it to it.getAnnotation(LoadIfPresent::class)!!.targets.map(KClass<out Annotation>::java).toSet()
        }.forEach { pair ->
            val aspectClass = pair.first
            val targets = pair.second
            targets.forEach { target ->
                bindings[target] = aspectClass
                aspectClasses.putAll(aspectClass, classFinder.getClassesWithAnnotationAnywhere(target))
            }
        }
    }

    private fun loadAspect(originalInjector: Injector, clazz: Class<out Aspect>): Injector {
        var injector = originalInjector

        injector = addStaticModule(clazz, injector)

        injector = bindAspectInstance(injector, clazz)

        val instance = injector.getInstance(clazz)
        instance.enable(aspectClasses[clazz])

        injector = installAspectModule(instance, injector)

        return injector
    }

    private fun installAspectModule(instance: Aspect, i: Injector): Injector {
        var injector = i
        val module = instance.getModule()

        if (module != null)
            injector = injector.createChildInjector(module)

        return injector
    }

    private fun bindAspectInstance(i: Injector, clazz: Class<out Aspect>): Injector {
        var injector = i
        val binding = injector.getExistingBinding(Key.get(clazz))

        if (binding == null) {
            injector = injector.createChildInjector(createGuiceModule {
                bind(clazz).asEagerSingleton()
            })
        }

        return injector
    }

    private fun addStaticModule(clazz: Class<out Aspect>, i: Injector): Injector {
        var injector = i
        if (clazz.isAnnotationPresent(StaticModule::class)) {
            val staticModule = injector.getInstance(clazz.getAnnotation(StaticModule::class)!!.target.java)
            injector = injector.createChildInjector(staticModule)
        }
        return injector
    }
}
