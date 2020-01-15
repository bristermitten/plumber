package me.bristermitten.plumber.files.store

import me.bristermitten.plumber.annotation.Unstable
import me.bristermitten.plumber.files.PlumberFile
import me.bristermitten.reflector.Reflector
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import kotlin.reflect.jvm.javaMethod

@Unstable("Functional but not documented and undergoing heavy refactoring")
class StoreProxyHandler<P, T>(
    val values: P,
    private val storeHandler: StoreHandler<in P, T>,
    val file: PlumberFile,
    val type: Class<out T>,
    reflector: Reflector
) : InvocationHandler {


    private val methodTable: MutableMap<Method, (Array<Any>) -> Any?> = HashMap()

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
        methodTable[Store<T>::save.javaMethod!!] = { args ->
            storeHandler.save(values, args[0] as T)
        }

        storeHandler.initMethodTable(methodTable)
    }

    fun load(data: P) {
        storeHandler.loadData(loadFrom = data, loadTo = values)
    }

    override fun invoke(proxy: Any?, method: Method, arguments: Array<Any>?): Any? {
        val args = arguments ?: arrayOf()

        if (method.declaringClass != Store::class.java) {
            return method.invoke(values, *args)
        }

        val fromTable = methodTable[method]

        return if (fromTable != null) {
            fromTable(args)
        } else throw NoSuchMethodException()
    }
}
