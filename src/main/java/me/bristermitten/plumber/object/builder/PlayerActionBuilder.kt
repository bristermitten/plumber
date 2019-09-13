package me.bristermitten.plumber.`object`.builder

import me.bristermitten.plumber.`object`.DataKey
import me.bristermitten.plumber.`object`.builder.impl.PlayerActionBuilderImpl

interface PlayerActionBuilder : ActionBuilder<PlayerActionBuilder> {

    fun <K> keyChange(key: DataKey<K>): KeyChangeChooser<PlayerActionBuilder, K>

    fun playerLogout(): PlayerActionBuilder

    companion object {
        var impl: Class<out PlayerActionBuilder> = PlayerActionBuilderImpl::class.java
    }
}
