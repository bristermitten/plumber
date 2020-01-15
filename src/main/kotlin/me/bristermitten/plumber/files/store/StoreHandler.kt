package me.bristermitten.plumber.files.store

import java.lang.reflect.Method

/**
 * @author Alexander Wood (BristerMitten)
 */
interface StoreHandler<P, V> {
    fun initMethodTable(table: MutableMap<Method, (Array<Any>) -> Any?>)
    fun save(store:P, data:V)
    fun loadData(loadFrom: P, loadTo: P)
}
