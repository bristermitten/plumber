package me.bristermitten.plumber.newaspect

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
annotation class RequiredAspect(val priority: Int = 0)
