package me.bristermitten.plumber.files

import me.bristermitten.plumber.annotation.Unstable
import me.bristermitten.reflector.Reflector
import me.bristermitten.reflector.property.Property
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import kotlin.reflect.jvm.javaMethod

@Unstable("Functional but not documented and undergoing heavy refactoring")
sealed class StoreProxyHandler<P, T>(
    val collectionProxy: P,
    val file: PlumberFile,
    val type: Class<T>,
    reflector: Reflector
) : InvocationHandler {

    protected val idProperty: Property = reflector.getStructure(type).searchProperties()
        .byAnnotation(Id::class.java).search().findFirst().orElseThrow {
            IllegalArgumentException("Class $type has no @Id property")
        }

    protected val methodTable: MutableMap<Method, (Array<Any>) -> Any?> = HashMap()

    init {
        methodTable[Store<T>::flush.javaMethod!!] = {
            file.saveData()
        }

        methodTable[Store<T>::reload.javaMethod!!] = {
            file.loadData()
        }
        methodTable[Store<T>::loadWith.javaMethod!!] = { args ->
            @Suppress("UNCHECKED_CAST")
            load(args[0] as P)
        }
    }

    abstract fun load(data: P)

    override fun invoke(proxy: Any?, method: Method, arguments: Array<Any>?): Any? {
        val args = arguments ?: arrayOf()

        if (method.declaringClass != Store::class.java) {
            return method.invoke(collectionProxy, *args)
        }

        val fromTable = methodTable[method]

        return if (fromTable != null) {
            fromTable(args)
        } else null
    }
}

class ValueStoreProxyHandler<T>(file: PlumberFile) : StoreProxyHandler<MutableList<T>, T>(ArrayList<T>(), file) {
    override fun load(data: MutableList<T>) {
        val list = collectionProxy
        list.clear()

        for (element in data) {
            if (element != null) {
                @Suppress("UNCHECKED_CAST")
                list.add(element as T)
            }
        }
    }
}

class KeyValueStoreProxyHandler<T>(file: PlumberFile, private val reflector: Reflector) :
    StoreProxyHandler<MutableMap<Any, T>, T>(HashMap()) {

    override fun load(data: MutableMap<Any, T>) {
        val map = collectionProxy
        map.clear()

        map.putAll(data)
    }
}
