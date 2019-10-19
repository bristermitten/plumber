package me.bristermitten.plumber.aspect

import com.google.inject.Inject
import com.google.inject.Module

/**
 * A part of Plumber, that can be an extension.
 * An Aspect should be the parent of a certain group of functionality, for example, command handling.
 *
 * Aspects are considered singletons to Guice.
 *
 * Instances are created with Guice, so [Inject] can be used. However, bear in mind that an instance of your aspect will be created with Guice before [module]
 * is called, and then this instance will be bound as the singleton instance and not injected again. If you need to make custom bindings,
 * and then inject into your aspect, use the annotation [AspectModule], and instead return null from [module]. This has the drawback/benefit of your aspect being
 * loaded after all normal aspects.
 */
interface Aspect {
    /**
     * Enable the Aspect and all of its features
     */
    fun enable()

    /**
     * Disable the Aspect and all of its features. Typically entails unregistering things and setting things to null to allow garbage collection
     */
    fun disable()

    /**
     * Provide an optional [Module] that will be installed **AFTER** the Aspect is instantiated.
     */
    fun module(): Module? = null
}
