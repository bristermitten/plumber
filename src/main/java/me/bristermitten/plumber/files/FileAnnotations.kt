package me.bristermitten.plumber.files

import me.bristermitten.plumber.aspect.AspectAnnotation

/**
 * Annotation to define a class as a Configuration class, that loads in data from a configuration file with an optional prefix
 */
@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@AspectAnnotation(FileAspect::class)
annotation class Configuration(val fileName: String = "config.yml", val prefix: String = "")

/**
 * Annotation to define a field as a configuration field, where its data will be loaded in from a file defined in [Configuration]
 * with a given key
 */
@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@AspectAnnotation(FileAspect::class)
annotation class ConfigVar(val value: String)



