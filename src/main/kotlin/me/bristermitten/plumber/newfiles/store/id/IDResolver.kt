package me.bristermitten.plumber.newfiles.store.id

/**
 * An ID Resolver resolves an ID element from a given object
 * The default implementations will either increment an internal counter and return the new value,
 * or will fetch a property value from the give object.
 *
 * Resolvers are 1 per Store-class, and should be thread-safe.
 */
interface IDResolver<I> {

    fun resolveID(value: Any): I
}
