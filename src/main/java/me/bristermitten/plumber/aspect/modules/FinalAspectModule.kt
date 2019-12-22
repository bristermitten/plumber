package me.bristermitten.plumber.aspect.modules

import com.google.inject.AbstractModule
import com.google.inject.Injector
import me.bristermitten.plumber.aspect.Aspect

/**
 * 3rd and final module in the Aspect module flow
 * Details in [configure]
 */
class FinalAspectModule(
        private val parent: AspectModule,
        private val injector: Injector,
        private val requiredAspects: Set<Class<out Aspect>>
) : AbstractModule() {

    /**
     * Configures the final aspects that defined static modules
     * 1) Install the parent [AspectModule]
     * 2) Loop through each required aspect, and bind them to an instance obtained from the parent injector
     * enabling any aspects
     */
    override fun configure() {
        install(parent)
        requiredAspects.forEach {
            val instance = injector.getInstance(it)
            instance.enable()

            if (instance.module() != null)
                install(instance.module())
            bind(instance.javaClass).toInstance(instance)
        }
    }
}
