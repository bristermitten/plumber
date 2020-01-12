package me.bristermitten.plumber.boot

import com.google.common.collect.HashMultimap
import com.google.common.collect.Multimap
import com.google.inject.Injector
import com.google.inject.Key
import com.google.inject.Module
import io.github.classgraph.ClassGraph
import me.bristermitten.plumber.PlumberPlugin
import me.bristermitten.plumber.aspect.*
import me.bristermitten.plumber.reflection.ClassFinder
import me.bristermitten.plumber.util.*
import me.bristermitten.plumber.util.Reflection.createGuiceModule
import me.bristermitten.reflector.config.OptionsBuilder
import me.bristermitten.reflector.inject.ReflectorBindingModule
import org.slf4j.LoggerFactory
import java.util.*

/**
 * Class responsible for loading the entirety of Plumber.
 */
class PlumberLoader(private val plugin: PlumberPlugin) {

    private val logger = LoggerFactory.getLogger(javaClass)
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
     * Load the entirety of Plumber
     * This is primarily composed of scanning for classes and registering them with Guice.
     * This is and should be only called once. In [PlumberPlugin.onEnable]
     */
    fun loadPlumber() {
        val injector = initializeGuice()

        val classFinder = injector.getInstance(ClassFinder::class)

        val aspects = classFinder.getClassesImplementing(Aspect::class)

        loadBindingsAndAspectClasses(classFinder, aspects)

        val holder = injector.getInstance(InjectorHolder::class)

        aspects.asSequence()
            .filter {
                //Ensure that the Aspect needs to be loaded
                it.isAnnotationPresent(RequiredAspect::class) || aspectClasses[it].isNotEmpty()
            }
            .sortedByDescending {
                //Sort by priority
                it.getAnnotation(RequiredAspect::class)?.priority ?: Int.MIN_VALUE
            }
            .forEach {
                loadAspect(holder, it)
            }

        holder.lock()
        injector.injectMembers(plugin)
    }


    /**
     * Create the base Injector for Plumber
     * This binds our Plugin instance and a [ClassGraphProvider]
     * for [ClassFinder], along with installing Reflector
     */
    private fun initializeGuice(): Injector {
        return createGuiceModule {
            bind<PlumberPlugin>().toInstance(plugin)
            bind(plugin.javaClass).toInstance(plugin)
            bind<ClassGraph>().toProvider<ClassGraphProvider>()
            install(ReflectorBindingModule(OptionsBuilder().scanSuperInterfaceAnnotations().build()))
        }.createInjector()
    }

    /**
     * Load all bindings and Aspect classes into internal maps.
     * This firstly looks for any annotations which are annotated with [AspectAnnotation]
     * and binds them to their target. It also looks for any classes with this annotation
     * and binds the annotation to these Aspect classes
     *
     * @param classFinder ClassFinder instance to use (TODO refactor into a higher scope)
     * @param aspects The aspect classes to load
     */
    private fun loadBindingsAndAspectClasses(classFinder: ClassFinder, aspects: Collection<Class<out Aspect>>) {

        classFinder.getClassesAnnotatedWith(AspectAnnotation::class)
            .asSequence()
            .filterIsAnnotation()
            .forEach { annotation ->
                val target = annotation.getAnnotation(AspectAnnotation::class)!!.target.java
                bindings[annotation] = target
                aspectClasses.putAll(target, classFinder.getClassesWithAnnotationAnywhere(annotation))
            }

        aspects.asSequence().filter { aspectClass ->
            aspectClass.isAnnotationPresent(LoadIfPresent::class)
        }.map {
            it to it.getAnnotation(LoadIfPresent::class)!!.targets.map { target -> target.java }
        }.forEach { pair ->
            val aspectClass = pair.first
            val targets = pair.second
            targets.forEach { target ->
                bindings[target] = aspectClass
                aspectClasses.putAll(aspectClass, classFinder.getClassesWithAnnotationAnywhere(target))
            }
        }
    }

    /**
     * Load an Aspect.
     * Firstly, this registers a [StaticModule] if applicable.
     * Then, the Aspect is instantiated, and its instance is bound to Guice.
     * Next, the Aspect instance is obtained from Guice and enabled with its classes.
     * Finally, the Aspect's [Aspect.getModule] is installed if applicable
     *
     */
    private fun loadAspect(holder: InjectorHolder, aspectClass: Class<out Aspect>) {

        addStaticModule(aspectClass, holder)

        bindAspectInstance(aspectClass, holder)

        val aspect = holder.injector.getInstance(aspectClass)
        aspect.enable(aspectClasses[aspectClass])

        installAspectModule(aspect, holder)
    }

    /**
     * Register an Aspect's [StaticModule], if applicable.
     * @param  aspectClass the Aspect class
     * @param holder Current InjectorHolder
     */
    private fun addStaticModule(aspectClass: Class<out Aspect>, holder: InjectorHolder) {
        if (!aspectClass.isAnnotationPresent(StaticModule::class)) return
        logger.debug("StaticModule found for Aspect {}, loading...", aspectClass)

        val target = aspectClass.getAnnotation(StaticModule::class)!!.target

        val staticModule = holder.injector.getInstance(target)

        holder.injector = holder.injector.createChildInjector(staticModule)

        logger.debug("StaticModule {} installed", aspectClass)
    }

    /**
     * Bind an Aspect's instance to the Injector
     *
     * This is currently a little messy in that due to Guice
     * not allowing duplicate bindings in child injectors, eager singletons must be used
     * for the Aspect. However, this is called from a [Sequence], so there is next to no performance impact
     *
     * @param aspectClass The Aspect's class
     * @param holder Current InjectorHolder
     */
    private fun bindAspectInstance(aspectClass: Class<out Aspect>, holder: InjectorHolder) {
        val injector = holder.injector


        //Sometimes a binding exists, and we want to avoid duplicate exceptions
        val binding = injector.getExistingBinding(Key.get(aspectClass))

        if (binding == null) {
            holder.injector = injector.createChildInjector(createGuiceModule {
                /*
                if we were to bind to the injector's instance of the class,
                a Just in Time binding would be created,
                and so the child injector could not be created
                */
                bind(aspectClass).asEagerSingleton()
            })
            logger.debug("{} bound (singleton)", aspectClass)
        }
    }

    /**
     * Install the [Module] for an Aspect if applicable
     * @param instance The Aspect
     * @param holder Current InjectorHolder
     */
    private fun installAspectModule(instance: Aspect, holder: InjectorHolder) {
        val module = instance.getModule() ?: return

        holder.injector = holder.injector.createChildInjector(module)
        logger.debug("Module installed for {}", instance.javaClass)
    }

}
