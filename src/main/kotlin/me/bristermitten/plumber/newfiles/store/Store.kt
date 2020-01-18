package me.bristermitten.plumber.newfiles.store

/**
 * @author Alexander Wood (BristerMitten)
 */
interface Store<K, V> : MutableMap<K, V> {

    fun add(data: V)

    fun flush()

    fun reload()

}
