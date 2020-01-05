package me.bristermitten.plumber.aspect

import com.google.inject.Inject
import com.google.inject.Module

/**
 * A section of Plumber's functionality, for example, command handling or file management
 * An Aspect should be considered the parent of this section, and manage dependency injection and initial setup
 *
 * Aspects are considered singletons and will only be internally instantiated once.
 *
 * Instances are created with Guice, so [Inject] can be used.
 * However, bear in mind that injection will occur before [getModule]
 * is called, and so an Aspect cannot be injected with bindings in its [getModule] return value
 *
 * If you need to make bindings and then inject into your aspect, use the annotation [StaticModule],
 * which defines a module that will be installed before Aspect creation.
 * A module can still be returned from [getModule], however the same conditions apply.
 *
 * On its own, an aspect will not automatically be loaded to reduce startup time.
 * Instead, it must be given a "reason" to load. This can be one or multiple of 3 things:
 *
 * 1) Annotating the class with [RequiredAspect], which ensures it will always be loaded
 * 2) Any [AspectAnnotation]s that target this aspect being present anywhere on the classpath
 * 3) Annotating the class with [LoadIfPresent] to load the aspect if a given annotation is present
 * anywhere on the classpath
 *
 * @author Alexander Wood (knightzmc)
 */
interface Aspect {

    /**
     * Enable the Aspect. This is called internally and only once: on server startup.
     *
     * @param classes Classes considered to be "part" of this Aspect. This includes classes with an
     * [AspectAnnotation] targeting this aspect, or with any [LoadIfPresent.targets]
     */
    fun enable(classes: Collection<Class<*>>)

    /**
     * Disable the Aspect.
     * Called internally and only once: server shutdown.
     * Often not needed, but some aspects may want to use this to flush data or similar operations.
     *
     * //TODO Ensure that all classes will still be loaded when this is called
     */
    fun disable()

    /**
     * Provide an optional Guice module to be installed.
     * This is called *after* instantiation of the Aspect so nothing from this module can be used in the Aspect.
     *
     * Ideally, this should be the only module associated with the Aspect to avoid confusing code structures.
     * However some Aspects may need 2 modules for configuring bindings into the Aspect itself:
     * @see [StaticModule]
     */
    fun getModule(): Module?
}
