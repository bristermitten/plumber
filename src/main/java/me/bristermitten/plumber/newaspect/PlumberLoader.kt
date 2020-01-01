package me.bristermitten.plumber.newaspect

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

/**
 * Class responsible for loading the entirety of Plumber
 * A lot of the work is delegated to Guice, and
 */
class PlumberLoader {

    private val bindings: Multimap<Class<out Annotation>, Class<out Aspect>> = HashMultimap.create()
    private val aspectClasses: Multimap<Class<out Aspect>, Class<*>> = HashMultimap.create()

    fun loadPlumber(plumberPlugin: PlumberPlugin) {
        val externalPluginPackage = plumberPlugin.javaClass.`package`.name
        val plumberPackage = PlumberPlugin::class.java.`package`.name

        val packages = arrayOf(externalPluginPackage, plumberPackage)

        val classGraph = ClassGraph()
                .enableAllInfo()
                .whitelistPackages(*packages)
                .disableRuntimeInvisibleAnnotations()
                .disableNestedJarScanning()
                .disableJarScanning()


        var injector = Guice.createInjector(object : KotlinModule() {
            override fun configure() {
                bind<ClassGraph>().toInstance(classGraph)
            }
        })

        val classFinder = injector.getInstance(ClassFinder::class.java)

        val aspects = classFinder.getClassesImplementing(Aspect::class)
        loadBindings(classFinder, aspects)

        aspects
                .filter {
                    if (it.isAnnotationPresent(RequiredAspect::class.java)) true
                    else bindings.containsValue(it) && aspectClasses[it].isNotEmpty()
                }
                .sortedByDescending { it.getAnnotation(RequiredAspect::class.java)?.priority ?: Integer.MIN_VALUE }
                .forEach {
                    injector = loadAspect(injector, it)
                }
    }

    private fun loadBindings(classFinder: ClassFinder, aspects: Collection<Class<out Aspect>>) {
        classFinder.getClassesAnnotatedWith(AspectAnnotation::class.java)
                .filter { it.isAnnotation }
                .map {
                    @Suppress("UNCHECKED_CAST")
                    it as Class<out Annotation>
                }
                .forEach {
                    val target = it.getAnnotation(AspectAnnotation::class.java).target.java
                    bindings.put(it, target)
                    aspectClasses.putAll(target, classFinder.getClassesWithAnnotationAnywhere(it))
                }

        aspects.filter {
            it.isAnnotationPresent(LoadIfPresent::class.java)
        }.map {
            it to it.getAnnotation(LoadIfPresent::class.java).targets.toSet()
        }.forEach { pair ->
            val aspectClass = pair.first
            pair.second.forEach {
                bindings.put(it.java, aspectClass)
                aspectClasses.putAll(aspectClass, classFinder.getClassesWithAnnotationAnywhere(it.java))
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
        val module = instance.module()

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
        if (clazz.isAnnotationPresent(StaticModule::class.java)) {
            val staticModule = injector.getInstance(clazz.getAnnotation(StaticModule::class.java).target.java)
            injector = injector.createChildInjector(staticModule)
        }
        return injector
    }
}
