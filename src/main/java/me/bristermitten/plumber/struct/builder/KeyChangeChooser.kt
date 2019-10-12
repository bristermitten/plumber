package me.bristermitten.plumber.struct.builder

import me.bristermitten.plumber.struct.Resettable
import me.bristermitten.plumber.struct.key.DataKey

/**
 * Interfaces that wraps watching a [DataKey] for a specific value
 */
interface KeyChangeChooser<R, K> : Resettable {
    /**
     * Set the value that will trigger a callback
     * @param value the value to watch for
     */
    fun toValue(value: K): R
}
