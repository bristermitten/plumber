package me.bristermitten.plumber.files

interface Store<T> {
    fun flush()
    fun reload()

    fun loadWith(data: Any)

    fun save(t: T)
}

