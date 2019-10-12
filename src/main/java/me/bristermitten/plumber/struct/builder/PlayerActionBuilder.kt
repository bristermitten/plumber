package me.bristermitten.plumber.struct.builder

import me.bristermitten.plumber.struct.builder.impl.PlayerActionBuilderImpl
import me.bristermitten.plumber.struct.key.DataKey

interface PlayerActionBuilder : ActionBuilder<PlayerActionBuilder> {

    fun <K> keyChange(key: DataKey<K>): KeyChangeChooser<PlayerActionBuilder, K>

    fun playerLogout(): PlayerActionBuilder

    fun withMessageOnComplete(msg: String): PlayerActionBuilder

    fun <K> setKeyOnComplete(key: DataKey<K>, value: K): PlayerActionBuilder


    companion object {
        var impl: Class<out PlayerActionBuilder> = PlayerActionBuilderImpl::class.java
    }
}
