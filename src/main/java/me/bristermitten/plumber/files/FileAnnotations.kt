package me.bristermitten.plumber.files

import me.bristermitten.plumber.aspect.AspectAnnotation

@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@AspectAnnotation(FileAspect::class)
annotation class Configuration(val fileName: String = "config.yml", val prefix: String = "")

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@AspectAnnotation(FileAspect::class)
annotation class ConfigVar(val value: String)



