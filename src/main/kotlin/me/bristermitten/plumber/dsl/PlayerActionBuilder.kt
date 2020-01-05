package me.bristermitten.plumber.dsl

import me.bristermitten.plumber.dsl.implementation.PlayerActionBuilderImpl
import me.bristermitten.plumber.struct.key.DataKey

/**
 * Subclass of [ActionBuilder] that defines various actions that a Player could do.
 * In the default implementation, a callback is defined that is ran when any of the actions are complete
 */
interface PlayerActionBuilder : ActionBuilder<PlayerActionBuilder> {

    /**
     * Watch for a key change on the player
     * @param key the key to watch
     * @return a [KeyChangeChooser] for further configuration
     */
    fun <K> keyChange(key: DataKey<K>): KeyChangeChooser<PlayerActionBuilder, K>

    /**
     * Watch for the player to logout
     * @return this object for further configuration
     */
    fun playerLogout(): PlayerActionBuilder

    /**
     * Set a message that will be sent when the action is complete
     * @param msg the message to send
     * @return this object for further configuration
     */
    fun withMessageOnComplete(msg: String): PlayerActionBuilder

    /**
     * Set a Data Key when the action is complete
     * @param key the key to set
     * @param value the value to set
     * @param K the type of the key
     * @return this object for further configuration
     */
    fun <K: Any> setKeyOnComplete(key: DataKey<K>, value: K): PlayerActionBuilder

    companion object {
        var impl: Class<out PlayerActionBuilder> = PlayerActionBuilderImpl::class.java
    }
}
