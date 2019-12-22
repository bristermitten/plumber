package me.bristermitten.plumber.files

interface Store<T> {
    fun flush()
    fun reload()

    fun getType() : Class<*>

    fun loadWith(data: Any)
}
