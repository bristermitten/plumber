package me.bristermitten.plumber.files

import com.google.common.collect.HashBasedTable
import com.google.common.collect.Table
import com.google.gson.reflect.TypeToken
import me.bristermitten.plumber.annotation.Unstable
import me.bristermitten.reflector.Reflector
import me.bristermitten.reflector.property.Property
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
@Unstable("Functional but not documented and undergoing heavy refactoring")
sealed class StoreProxyHandler(
        val collectionProxy: Any,
        val file: PlumberFile
) : InvocationHandler {

    open fun setType(type: Class<*>){}

    protected val methodTable: Table<String, List<Class<*>>, (Array<Any>) -> Any?> = HashBasedTable.create()

    init {
        methodTable.put("flush", emptyList()) {
            file.saveData()
        }

        methodTable.put("reload", emptyList()) {
            file.loadData()
        }
        methodTable.put("getType", emptyList()) {
            return@put collectionProxy.javaClass
        }
        methodTable.put("loadWith", listOf(Any::class.java)) { args ->
            load(args[0])
        }
    }

    abstract fun load(data: Any)

    override fun invoke(proxy: Any?, method: Method, arguments: Array<Any>?): Any? {
        val args = arguments ?: arrayOf()

        if (method.declaringClass != Store::class.java) {
            return method.invoke(collectionProxy, *args)
        }

        val fromTable = methodTable.get(method.name, method.parameterTypes.toList())

        return if (fromTable != null) {
            fromTable(args)
        } else null
    }
}

class ValueStoreProxyHandler(file: PlumberFile) : StoreProxyHandler(ArrayList<Any>(), file) {
    override fun load(data: Any) {
        val list = collectionProxy as ArrayList<Any>
        list.clear()

        if (data is Iterable<*>)
            for (element in data) {
                if (element != null) {
                    list.add(element)
                }
            }
    }
}

class KeyValueStoreProxyHandler(file: PlumberFile, private val reflector: Reflector) : StoreProxyHandler(HashMap<Any, Any>(), file) {

    override fun setType(type: Class<*>) {
        if (!this::idProperty.isInitialized) {
            idProperty = reflector.getStructure(type).searchProperties()
                    .byAnnotation(Id::class.java).search().findFirst().orElseThrow {
                        IllegalArgumentException("Class $type has no @Id property")
                    }
        }


        methodTable.put("save", listOf(Any::class.java)) {
            val map = collectionProxy as MutableMap<Any ,Any>
            map[idProperty.getValue(it[0])] = it[0]
            null
        }
    }


    private lateinit var idProperty: Property

    override fun load(data: Any) {
        val map = collectionProxy as HashMap<Any, Any>
        map.clear()

        if (data is Map<*, *>)
            for ((key, value) in data) {
                if (key != null && value != null)
                    map[key] = value
            }
    }
}
