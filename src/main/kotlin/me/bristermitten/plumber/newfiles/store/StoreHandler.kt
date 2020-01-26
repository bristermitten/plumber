package me.bristermitten.plumber.newfiles.store

import java.lang.reflect.Method

/**
 * Interface that handles all tasks that cannot be generalised in [Store]
 * It adds a layer of abstraction to the underlying Collection/Map/other store of a [Store]
 * and also handles methods that are defined either in the [Store] sub-interface or a superinterface
 * For example, in [CollectionStore] all [MutableLi]
 * @author Alexander Wood (BristerMitten)
 */
interface StoreHandler<T> {

    fun getData(): Iterable<T>

    fun add(data: T)

    fun clearValues()

    fun handle(method: Method, args: Array<Any?>): Any?
}
