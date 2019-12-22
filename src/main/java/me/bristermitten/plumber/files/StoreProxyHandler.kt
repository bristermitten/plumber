package me.bristermitten.plumber.files

import com.google.common.collect.HashBasedTable
import com.google.common.collect.Table
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method

sealed class StoreProxyHandler(
        protected val mainProxy: Any,
        private val file: PlumberFile
) : InvocationHandler {

    private val methodTable: Table<String, List<Class<*>>,
            (Array<Any>) -> Any> = HashBasedTable.create()

    init {
        methodTable.put("flush", emptyList()) {
            file.saveData()
        }

        methodTable.put("reload", emptyList()) {
            file.loadData()
        }
        methodTable.put("getType", emptyList()) {
            return@put mainProxy.javaClass
        }
        methodTable.put("loadWith", listOf(Any::class.java)) { args ->
            load(args[0])
        }
    }

    abstract fun load(data: Any)

    override fun invoke(proxy: Any?, method: Method, arguments: Array<Any>?): Any? {
        val args = arguments ?: arrayOf()

        if (method.declaringClass != Store::class.java) {
            return method.invoke(mainProxy, *args)
        }

        val fromTable = methodTable.get(method.name, method.parameterTypes.toList())

        return if (fromTable != null) {
            fromTable(args)
        } else null
    }
}

class ValueStoreProxyHandler(file: PlumberFile) : StoreProxyHandler(ArrayList<Any>(), file) {

    override fun load(data: Any) {
        val list = mainProxy as ArrayList<Any>
        list.clear()

        if (data is Iterable<*>)
            for (element in data) {
                if (element != null) {
                    list.add(element)
                }
            }
    }
}

class KeyValueStoreProxyHandler(file: PlumberFile) : StoreProxyHandler(HashMap<Any, Any>(), file) {
    override fun load(data: Any) {
        val map = mainProxy as HashMap<Any, Any>
        map.clear()

        if (data is Map<*, *>)
            for ((key, value) in data) {
                if (key != null && value != null)
                    map[key] = value
            }
    }
}
