package me.bristermitten.plumber.data

@Target(AnnotationTarget.TYPE)
@Retention(AnnotationRetention.RUNTIME)
annotation class Configuration(val fileName: String = "config.yml", val prefix: String = "")

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class ConfigVar(val path: String)
