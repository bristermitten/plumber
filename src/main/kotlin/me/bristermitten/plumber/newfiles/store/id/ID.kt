package me.bristermitten.plumber.newfiles.store.id

/**
 * Marks the ID Property of an object, that will be used in key-value storage
 */
@Target(AnnotationTarget.PROPERTY, AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class ID
