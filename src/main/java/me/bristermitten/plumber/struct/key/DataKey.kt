package me.bristermitten.plumber.struct.key

import java.util.concurrent.CopyOnWriteArrayList
import java.util.function.Consumer

data class DataKey<T>(val key: String, val defaultValue: T) {
    val handlers: MutableList<Consumer<T>> = CopyOnWriteArrayList()

    fun execHandlers(value: T) {
        handlers.forEach { it.accept(value) }
    }
}
