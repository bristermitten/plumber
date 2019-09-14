package me.bristermitten.plumber.`object`.builder

import me.bristermitten.plumber.`object`.builder.impl.PlayerActionBuilderImpl
import me.bristermitten.plumber.`object`.key.DataKey

interface PlayerActionBuilder : ActionBuilder<PlayerActionBuilder> {

    fun <K> keyChange(key: DataKey<K>): KeyChangeChooser<PlayerActionBuilder, K>

    fun playerLogout(): PlayerActionBuilder

    fun withMessageOnComplete(msg: String) : PlayerActionBuilder
    fun <K> setKeyOnComplete(key : DataKey<K>, value : K) : PlayerActionBuilder


    companion object {
        var impl: Class<out PlayerActionBuilder> = PlayerActionBuilderImpl::class.java
    }
}
