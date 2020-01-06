package me.bristermitten.plumber.files

import me.bristermitten.plumber.annotation.Unstable
import me.bristermitten.plumber.aspect.AspectAnnotation

/**
 * Define the Id parameter for a data class
 * This is only needed for Key-Value storage, and is used as the key
 */
@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class Id

/**
 * Map an object to a persistent store i.e. a File or Database
 * @param fileName The name of the storage. Files will be made in the plugin directory
 * @param type The type of storage to use. If not specified, it will be inferred from the file extension
 */
@AspectAnnotation(FilesAspect::class)
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class MappedTo(val fileName: String, val type: StorageType = StorageType.INFER)

/**
 * The type of mapping to use from memory to storage
 * @param type the type of mapping to use
 * @see MappingType
 */
@Unstable("Not yet implemented")
@AspectAnnotation(FilesAspect::class)
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class StorageMapping(val type: MappingType = MappingType.ONE_WAY_TO_STORAGE)


/**
 * Methods of mapping data to a backend storage
 */
@Unstable("Not yet implemented")
enum class MappingType {
    /**
     * Changes to the object affect the storage and vice versa.
     */
    TWO_WAY,
    /**
     * Changes to the object affect the storage but after initial loading the object is not changed.
     */
    ONE_WAY_TO_STORAGE,
    /**
     * Changes to the object do not affect the storage but if the storage changes the object is updated.
     * Only applicable to SQL.
     */
    ONE_WAY_FROM_STORAGE
}
