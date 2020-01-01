package me.bristermitten.plumber.aspect.modules

import com.google.inject.AbstractModule
import com.google.inject.Injector
import com.google.inject.Module
import me.bristermitten.plumber.aspect.Aspect

/**
 * 3rd and final module in the Aspect module flow
 * Details in [configure]
 */
class FinalAspectModule(
        private val parent: Module,
        private val injector: Injector,
        private val requiredAspects: Set<Class<out Aspect>>
) : AbstractModule() {

    /**
     * Configures the final aspects that defined static modules
     * 1) Install the parent module, which will almost always be [AspectModule]
     * 2) Loop through each required aspect, and bind them to an instance from the parent injector
     */
    override fun configure() {
//        install(parent)
        requiredAspects.forEach {
//            val binding = injector.getBinding(Key.get(it))
//            if (binding != null) {
//                logger.debug("An instance of {} is already bound, skipping from FinalAspectModule...", it.name)
//                return@forEach
//            }
            val instance = injector.getInstance(it)
            bind(instance.javaClass).toInstance(instance)
        }
    }
}
