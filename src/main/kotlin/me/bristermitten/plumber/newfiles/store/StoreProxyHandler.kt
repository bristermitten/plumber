package me.bristermitten.plumber.newfiles.store

import me.bristermitten.plumber.files.Id
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy
import kotlin.reflect.jvm.javaMethod

/**
 * @author Alexander Wood (BristerMitten)
 */
class StoreProxyHandler<K, V> : InvocationHandler {

    private val internalMap: MutableMap<K, V> = HashMap()
    private val methodTable = hashMapOf<Method, (Array<Any?>) -> Any?>()

    init {
        methodTable[Store<*, V>::clear.javaMethod!!] = {
            internalMap.clear()
        }
        var count = 0
        methodTable[Store<*, V>::save.javaMethod!!] = {
            internalMap.put((count++ as K), (it[0]!! as V))
        }
    }

    override fun invoke(proxy: Any, method: Method, a: Array<Any?>?): Any? {
        val args = a ?: emptyArray()
        methodTable[method]?.let { return it(args) }

        if (method.declaringClass.isAssignableFrom(internalMap.javaClass)) {
            return method.invoke(internalMap, *args)
        }
        return null
    }
}

fun main() {
    val proxy = Proxy.newProxyInstance(
        StoreProxyHandler::class.java.classLoader,
        arrayOf(Store::class.java),
        StoreProxyHandler<Int, Int>()
    ) as Store<Int, Int>

    proxy.save(3)
    proxy.save(4)
    proxy.forEach {
        println(it)
    }
    println(proxy[1])
}

data class TestData(
    @Id private val id: Long
)
