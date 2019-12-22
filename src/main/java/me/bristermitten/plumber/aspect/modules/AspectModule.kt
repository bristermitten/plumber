package me.bristermitten.plumber.aspect.modules

import com.google.inject.AbstractModule
import com.google.inject.Injector
import com.google.inject.Module
import me.bristermitten.plumber.aspect.Aspect
import me.bristermitten.plumber.aspect.AspectManager
import me.bristermitten.plumber.aspect.StaticAspectModule
import org.slf4j.LoggerFactory

/**
 * 2nd Module in the Aspect module hierarchy
 * Details in [configure]
 */
class AspectModule(private val parent: InitialModule,
                   private val aspectManager: AspectManager,
                   private val injector: Injector) : AbstractModule() {

    private val logger = LoggerFactory.getLogger(javaClass)
    val lateAspects: MutableSet<Class<out Aspect>> = HashSet()
    private val modules: MutableSet<Module> = HashSet()
    private val aspectsToBind: MutableSet<Any> = HashSet()

    init {
        aspectManager.requiredAspects.forEach { aspectClass ->

            if (aspectClass.isAnnotationPresent(StaticAspectModule::class.java)) {
                val annotation = aspectClass.getAnnotation(StaticAspectModule::class.java)

                val moduleClass = annotation.target.java
                val target = injector.getInstance(moduleClass)
                modules.add(target)
                lateAspects.add(aspectClass)
                logger.debug("Installed Linked Module for Aspect {}, waiting to load Aspect", aspectClass.name)

                return@forEach
            }

            val aspect = injector.getInstance(aspectClass)
            aspect.enable()
            aspectsToBind.add(aspect)
            val module = aspect.module()
            module?.let(modules::add)
            logger.debug("Loaded Guice Module for Aspect {}", aspectClass.name)
        }
    }

    /**
     * Technically this violates Guice's best practice of side-effects in modules, however it is necessary to avoid a far more complex layout
     * The process can be broken into steps:
     * 1) Install a parent module of [InitialModule] provided in the constructor
     * 2) Bind the instance of [AspectManager] that has been provided
     * 3) Loop through each aspect class in [AspectManager.requiredAspects]
     * If the aspect has the annotation [StaticAspectModule], install the target module, and add the aspect to the "later initialising" set
     * Otherwise, get an instance of the aspect from the parent injector, bind the instance (making it a singleton), and install a module if one is provided
     *
     * Finally, set the required aspects set to all of the aspects that are not yet initialised
     */
    override fun configure() {
        install(parent)
        bind(aspectManager.javaClass).toInstance(aspectManager)

        modules.forEach {
            install(it)
        }
        for (aspect in aspectsToBind) {
            bind(aspect.javaClass).toInstance(aspect)
        }
    }
}
