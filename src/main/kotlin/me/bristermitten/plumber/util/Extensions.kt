package me.bristermitten.plumber.util

import com.google.inject.Guice
import com.google.inject.Injector
import com.google.inject.Module
import kotlin.reflect.KClass

/**
 * [Injector] extension for [KClass]
 */
fun <T : Any> Injector.getInstance(clazz: KClass<T>): T {
    return getInstance(clazz.java)
}

/**
 * [Module] extension for [Guice.createInjector]
 */
fun Module.createInjector(): Injector = Guice.createInjector(this)

/**
 * [Class] extension for [KClass]
 */
fun Class<*>.isAnnotationPresent(annotation: KClass<out Annotation>): Boolean {
    return isAnnotationPresent(annotation.java)
}

/**
 * [Class] extension for [KClass]
 */
fun <A : Annotation> Class<*>.getAnnotation(annotation: KClass<A>): A? {
    return getAnnotation(annotation.java)
}

/**
 * [Sequence] extension to filter that all of the elements in a Sequence of [Class]es
 * are [Class.isAnnotation]
 * This then casts to the implied contract
 * TODO Iterable extension as well
 */
fun Sequence<Class<*>>.filterIsAnnotation(): Sequence<Class<out Annotation>> {
    @Suppress("UNCHECKED_CAST")
    return filter { it.isAnnotation } as Sequence<Class<out Annotation>>
}
