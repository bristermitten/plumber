package me.bristermitten.plumber.newfiles.store.id

import com.google.inject.Inject
import com.google.inject.Singleton

/**
 * @author Alexander Wood (BristerMitten)
 */
@Singleton
class IDResolvers @Inject constructor(private val propertyIDResolvers: PropertyIDResolvers) {

    private val resolverFactories: MutableMap<Class<*>, () -> IDResolver<*>> = HashMap()

    fun <T> registerResolver(type: Class<T>, resolver: () -> IDResolver<T>) {
        resolverFactories.putIfAbsent(type, resolver)
    }

    inline fun <reified T> registerResolver(noinline resolver: () -> IDResolver<T>) {
        registerResolver(T::class.java, resolver)
    }

    fun <T, I> getResolver(strategy: IDStrategy, dataType: Class<T>, idType: Class<I>): IDResolver<I> {
        if (strategy == IDStrategy.PROPERTY) {
            return propertyIDResolvers.resolverFor(dataType, idType)
        }

        val function = resolverFactories[idType]
            ?: throw IllegalArgumentException("No IDResolver for Type $idType")

        @Suppress("UNCHECKED_CAST")
        return function.invoke() as IDResolver<I>
    }
}
