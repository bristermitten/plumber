package me.bristermitten.plumber.data

import me.bristermitten.plumber.aspect.AspectAnnotation

@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@AspectAnnotation(DataAspect::class)
annotation class Configuration(val fileName: String = "config.yml", val prefix: String = "")

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@AspectAnnotation(DataAspect::class)
annotation class ConfigVar(val value: String)



