package me.bristermitten.plumber.files

import me.bristermitten.plumber.aspect.AspectAnnotation

///**
// * Annotation to define a class as a Configuration class, that loads in data from a configuration file with an optional prefix
// */
//@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS)
//@Retention(AnnotationRetention.RUNTIME)
//@AspectAnnotation(FileAspect::class)
//annotation class Configuration(val fileName: String = "config.yml", val prefix: String = "")
//
///**
// * Annotation to define a field as a configuration field, where its data will be loaded in from a file defined in [Configuration]
// * with a given key
// */
//@Target(AnnotationTarget.FIELD)
//@Retention(AnnotationRetention.RUNTIME)
//@AspectAnnotation(FileAspect::class)
//annotation class ConfigVar(val value: String)


@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class Id

@AspectAnnotation(FilesAspect::class)
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class MappedTo(val fileName: String, val type: FilesAspect.FileType = FilesAspect.FileType.INFER)

@AspectAnnotation(FilesAspect::class)
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class StorageMapping(val type : MappingType = MappingType.ONE_WAY_TO_STORAGE)


enum class MappingType {
    /**
     * Changes to the object affect the storage and vice versa
     */
    TWO_WAY,
    /**
     * Changes to the object affect the storage but after initial loading the object is not changed
     */
    ONE_WAY_TO_STORAGE,
    /**
     * Changes to the object do not affect the storage but if the storage changes the object is updated
     * only really applicable to sql
     */
    ONE_WAY_FROM_STORAGE
}
