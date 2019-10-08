package me.bristermitten.plumber.aspect.components

import me.bristermitten.plumber.aspect.AspectAnnotation

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@AspectAnnotation(ComponentAspect::class)
annotation class Component
