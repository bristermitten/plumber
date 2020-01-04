package me.bristermitten.plumber.struct.key

import me.bristermitten.plumber.struct.player.PPlayer
import java.util.*
import java.util.concurrent.ConcurrentHashMap
import java.util.function.Consumer

/**
 * A DataKey provides a key for storing key-value data in entities
 * It only stores the key, and a default value. It does NOT store the values, these are stored in the entities
 * Means that Strings don't have to be passed around for simple storage
 */
data class DataKey<T>(val key: String, val defaultValue: T) {

    constructor(defaultValue: T) : this(UUID.randomUUID().toString(), defaultValue)

    /**
     * List of Handlers for when the key's value is updated.
     * These are not actually handled in the Key object, and instead should be called inside
     * classes that implement [KeyHolder] or hold instances of [DataKey]
     * For example, in [PPlayer.setData]
     * [DataKey.execHandlers] is called every time the key's data is updated.
     *
     * This approach avoids having to store the current value in a [DataKey], fulfilling the idea of it being a key only,
     * whereas the value is stored in entities.
     *
     */
    val handlers = ConcurrentHashMap.newKeySet<Consumer<T>>()!!

    /**
     * Execute all handlers with a new value
     * This should be called before the value is set upon
     */
    fun execHandlers(value: T) {
        handlers.forEach { it.accept(value) }
    }

}
