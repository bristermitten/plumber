package me.bristermitten.plumber.struct.builder

import me.bristermitten.plumber.struct.DataKey
import me.bristermitten.plumber.struct.builder.impl.PlayerActionBuilderImpl

interface PlayerActionBuilder : ActionBuilder<PlayerActionBuilder> {

    //    TimeUnitPicker<PlayerActionBuilder<P>> after(long length);

    fun <K> keyChange(key: DataKey<K>): KeyChangeChooser<PlayerActionBuilder, K>

    fun playerLogout(): PlayerActionBuilder

    companion object {
        var impl: Class<out PlayerActionBuilder> = PlayerActionBuilderImpl::class.java
    }
}
