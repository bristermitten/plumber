package me.bristermitten.plumber.newfiles.store

import me.bristermitten.plumber.files.Id
import me.bristermitten.plumber.newfiles.store.id.PropertyIDResolver
import me.bristermitten.reflector.Reflector
import me.bristermitten.reflector.config.FieldAccessLevel
import me.bristermitten.reflector.config.OptionsBuilder
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy

/**
 * @author Alexander Wood (BristerMitten)
 */
class StoreProxyHandler<K, V>(private val delegate: StoreDelegate<K, V>) : InvocationHandler {

    override fun invoke(proxy: Any, method: Method, a: Array<Any?>?): Any? {
        return method.invoke(delegate, *(a ?: emptyArray()))
    }
}

fun main() {

    val reflector = Reflector(OptionsBuilder().fieldAccessLevel(FieldAccessLevel.ALL).build())
    val idResolver = PropertyIDResolver<Long>(reflector)

    val proxy = Proxy.newProxyInstance(
        StoreProxyHandler::class.java.classLoader,
        arrayOf(Store::class.java),
        StoreProxyHandler<Long, TestData>(StoreDelegate(idResolver))
    ) as Store<Long, TestData>

    proxy.add(TestData(3))
    proxy.add(TestData(4))
    proxy.forEach {
        println(it)
    }
    println(proxy[3])
    proxy.remove(3)
    proxy.forEach {
        println(it)
    }
}

data class TestData(
    @Id private val id: Long
)
