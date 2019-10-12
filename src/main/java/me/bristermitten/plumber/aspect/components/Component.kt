package me.bristermitten.plumber.aspect.components

import me.bristermitten.plumber.aspect.AspectAnnotation

/**
 * Similar to Spring's @Component, this indicates that the class should be instantiated with Guice
 * and bound as a singleton.
 * It will be bound as part of [ComponentAspect]
 */
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@AspectAnnotation(ComponentAspect::class)
annotation class Component
