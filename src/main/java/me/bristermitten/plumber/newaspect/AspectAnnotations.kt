package me.bristermitten.plumber.newaspect

import com.google.inject.Module
import kotlin.reflect.KClass

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
annotation class RequiredAspect(val priority: Int = 0)


@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
annotation class StaticModule(val target: KClass<out Module>)


@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.ANNOTATION_CLASS)
annotation class AspectAnnotation(val target: KClass<out Aspect>)

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
annotation class LoadIfPresent(vararg val targets: KClass<out Annotation>)
