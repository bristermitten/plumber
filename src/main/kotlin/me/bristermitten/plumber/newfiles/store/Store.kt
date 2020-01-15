package me.bristermitten.plumber.newfiles.store

/**
 * @author Alexander Wood (BristerMitten)
 */
interface Store<K, V> : Map<K, V> {
    fun save(data: V)

    fun flush()

    fun reload()

    fun clear()

    fun delete(key: K) : V?

}
