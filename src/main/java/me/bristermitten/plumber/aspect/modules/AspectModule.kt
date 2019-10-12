package me.bristermitten.plumber.aspect.modules

import com.google.inject.AbstractModule
import com.google.inject.Injector
import me.bristermitten.plumber.aspect.Aspect
import me.bristermitten.plumber.aspect.AspectModuleLink
import me.bristermitten.plumber.aspect.AspectReflectionManager

/**
 * 2nd Module in the Aspect module hierarchy
 * Details in [configure]
 */
class AspectModule(private val parent: InitialModule,
                   private val aspectReflectionManager: AspectReflectionManager,
                   private val injector: Injector) : AbstractModule() {

    val requiredAspects: MutableSet<Class<out Aspect>> = aspectReflectionManager.requiredAspects.toMutableSet()

    /**
     * Technically this violates Guice's best practice of side-effects in modules, however it is necessary to avoid a far more complex layout
     * The process can be broken into steps/pseudocode
     * 1) Install a parent module given
     * 2) Bind the instance of [AspectReflectionManager]
     * 3) Loop through each aspect class in [requiredAspects]
     * If the aspect has the annotation [AspectModuleLink], install the target module, and add the aspect to the "later initialising" set
     * Otherwise, get an instance of the aspect from the parent injector, bind the instance (making it a singleton), and install a module if one is provided
     *
     * Finally, set the required aspects set to all of the aspects that are not yet initialised
     */
    override fun configure() {
        install(parent)
        bind(aspectReflectionManager.javaClass).toInstance(aspectReflectionManager)

        val lateInitAspects: MutableSet<Class<out Aspect>> = HashSet()

        requiredAspects.forEach { aspect ->

            if (aspect.isAnnotationPresent(AspectModuleLink::class.java)) {
                val moduleClass = aspect.getAnnotation(AspectModuleLink::class.java).target.java
                val target = injector.getInstance(moduleClass)
                install(target)
                lateInitAspects.add(aspect)
            } else {
                val instance = injector.getInstance(aspect)
                bind(instance.javaClass).toInstance(instance)
                val module = instance.module()
                module?.let { install(it) }
            }
        }
        requiredAspects.clear()
        requiredAspects.addAll(lateInitAspects)
    }
}
