package me.bristermitten.plumber.newfiles.store

import com.google.inject.Inject
import me.bristermitten.plumber.PlumberPlugin
import me.bristermitten.plumber.newfiles.store.id.IDResolver
import me.bristermitten.plumber.newfiles.store.id.IncrementIDResolver
import me.bristermitten.plumber.newfiles.store.id.PropertyIDResolvers
import me.bristermitten.plumber.util.getAnnotation
import me.bristermitten.plumber.util.isAssignableFrom
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Proxy
import java.lang.reflect.Type

class StoreFactory @Inject constructor(
    private val plumberPlugin: PlumberPlugin,
    private val propertyIDResolvers: PropertyIDResolvers
) {

    fun <S : Store<K, V>, K, V> createStoreImplementation(clazz: Class<S>): Store<K, V> {
        val storeStrategy = clazz.getAnnotation<StoreStrategy>()?.strategy ?: StoreStrategyType.INCREMENT

        //turning Class<out Store<K, V>> into [K, V]
        val storeTypeParameters = getStoreTypeParameters(clazz)
        val idType = storeTypeParameters[0]
        val valueType = storeTypeParameters[1]

        require(idType is Class<*>) { "$idType is not a Class" }
        require(valueType is Class<*>) { "$valueType is not a Class" }


        @Suppress("UNCHECKED_CAST") val idClass = idType as Class<K>
        val resolver = createIDResolver(storeStrategy, idClass, valueType)

        return createProxy(resolver)
    }

    private fun <I, V> createIDResolver(strategy: StoreStrategyType, idType: Class<I>, valueClass: Class<V>): IDResolver<I> {
        return when (strategy) {
            StoreStrategyType.INCREMENT -> {
                if (!Number::class.java.isAssignableFrom(idType))
                    throw IllegalArgumentException("$strategy requires a Number key")

                @Suppress("UNCHECKED_CAST")
                return createIncrementResolver() as IDResolver<I>
            }

            StoreStrategyType.PROPERTY -> {
                @Suppress("UNCHECKED_CAST")
                propertyIDResolvers.resolverFor(valueClass, idType) as IDResolver<I>
            }
        }
    }

    private fun createIncrementResolver(): IDResolver<Number> {
        return IncrementIDResolver()
    }

    private fun <K, V> createProxy(idResolver: IDResolver<K>): Store<K, V> {
        @Suppress("UNCHECKED_CAST")
        return Proxy.newProxyInstance(
            plumberPlugin.javaClass.classLoader,
            arrayOf(Store::class.java),
            StoreProxyHandler<K, V>(StoreDelegate(idResolver))
        ) as Store<K, V>
    }

    private fun getStoreTypeParameters(type: Class<out Store<*, *>>): List<Type> {
        return type.genericInterfaces
            .filterIsInstance<ParameterizedType>()
            .first {
                //eg KeyValueStore or ValueStore
                Store::class.isAssignableFrom(it.rawType)
            }.actualTypeArguments.toList() //eg ValueStore<Data> => [Data]
    }

}
