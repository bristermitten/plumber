package me.bristermitten.plumber.newfiles.store

import com.google.inject.Inject
import com.google.inject.Injector
import me.bristermitten.plumber.PlumberPlugin
import me.bristermitten.plumber.newfiles.store.id.IDResolver
import me.bristermitten.plumber.util.isAssignableFrom
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Proxy
import java.lang.reflect.Type

class StoreFactory @Inject constructor(
    private val plumberPlugin: PlumberPlugin,
    private val injector: Injector
) {

    fun <S : Store<K, V>, K, V> createStoreImplementation(clazz: Class<S>): Store<K, V> {
        val storeTypeParameters = getStoreTypeParameters(clazz)
        //turning Class<out Store<K, V>>

    }

    fun <K, V> createProxy(idResolver: IDResolver<K>): Store<K, V> {
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
