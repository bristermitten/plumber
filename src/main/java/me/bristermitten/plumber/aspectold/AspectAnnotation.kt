package me.bristermitten.plumber.aspect

import me.bristermitten.plumber.newaspect.Aspect
import kotlin.reflect.KClass

/**
 * Marks that an annotation is used by an aspect, and that the class scanner should initialize that Aspect if not
 * already done.
 */
@Target(AnnotationTarget.ANNOTATION_CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class AspectAnnotation(val target: KClass<out Aspect>)
