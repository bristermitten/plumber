package me.bristermitten.plumber.newfiles.store

import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method

/**
 * @author Alexander Wood (BristerMitten)
 */
class StoreProxyHandler<K, V>(
    private val delegate: StoreDelegate<K, V>,
    val proxying: Class<Store<K, V>>
) : InvocationHandler {

    override fun invoke(proxy: Any, method: Method, a: Array<Any?>?): Any? {
        return method.invoke(delegate, *(a ?: emptyArray()))
    }
}
