package me.bristermitten.plumber.util

import com.google.inject.Injector
import kotlin.reflect.KClass

fun <T : Any> Injector.getInstance(clazz: KClass<T>): T {
    return getInstance(clazz.java)
}

fun Class<*>.isAnnotationPresent(annotation: KClass<out Annotation>): Boolean {
    return isAnnotationPresent(annotation.java)
}

fun <A : Annotation> Class<*>.getAnnotation(annotation: KClass<A>): A? {
    return getAnnotation(annotation.java)
}


