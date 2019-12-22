package me.bristermitten.plumber.struct.extension

interface Extendable<T, E : Extension<T>> {
    fun getExtension(clazz: Class<out E>): E
}
