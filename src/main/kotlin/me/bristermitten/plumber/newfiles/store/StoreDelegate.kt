package me.bristermitten.plumber.newfiles.store

import me.bristermitten.plumber.annotation.HideFromReflection
import me.bristermitten.plumber.newfiles.store.id.IDResolver

@HideFromReflection
class StoreDelegate<K, V>(private val idResolver: IDResolver<K>,
                          private val proxying: Class<Store<K, V>>) : Store<K, V>,
    MutableMap<K, V> by HashMap() {

    override fun add(data: V) {
        val key = idResolver.resolveID(data!!)
        put(key, data)
    }

    override fun flush() {
    }

    override fun reload() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun toString(): String {
        return "StoreDelegate(idResolver=$idResolver, proxying=$proxying)"
    }

}
