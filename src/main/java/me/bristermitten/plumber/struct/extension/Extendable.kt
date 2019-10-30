package me.bristermitten.plumber.struct.extension

interface Extendable<E : Extendable<E>> {
    fun <T : Extension<E>> getExtension(clazz: Class<T>): T
}
