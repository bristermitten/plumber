package me.bristermitten.plumber.files

import me.bristermitten.plumber.annotation.Unstable
import me.bristermitten.plumber.aspect.AspectAnnotation
import java.lang.annotation.Inherited
import kotlin.reflect.KClass


/**
 * Define the Id parameter for a data class
 * This is only needed for Key-Value storage, and is used as the key
 */
@Unstable("Functional but not documented and undergoing heavy refactoring")
@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class Id

/**
 * Map an object to a persistent store i.e. a File or Database
 * @param fileName The name of the storage. Files will be made in the plugin directory
 * @param type The type of storage to use. If not specified, it will be inferred from the file extension
 */
@Unstable("Functional but not documented and undergoing heavy refactoring")
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


/**
 * A subclass of [Store] should use this class to assign a type that will be assigned as a delegate.
 * This type will be instantiated and used as the underlying in-memory collection for the Store.
 * Interface subclasses (eg [ObjectStore]) should declare this annotation, but subclasses of those interfaces can override the data.
 * However, obviously, if the overridden type does not implement the original, methods may not be found and errors will occur.
 */
@Unstable("Functional but not documented and undergoing heavy refactoring")
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Inherited
annotation class StoreDelegate(val delegateType: KClass<*>)
