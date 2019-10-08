package me.bristermitten.plumber.struct

import me.bristermitten.plumber.annotation.Unstable

/**
 * Indicates that something can be reset
 */
@Unstable(reason = "The future of this interface is not yet decided," +
        "and it may be removed due to lack of usefulness or creating convoluted implementations")
interface Resettable {
    /**
     * Reset the current data
     * Implementation is interface specific
     */
    fun reset()
}
