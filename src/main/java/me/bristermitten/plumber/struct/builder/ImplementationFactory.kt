package me.bristermitten.plumber.struct.builder

import me.bristermitten.plumber.struct.DataKey
import me.bristermitten.plumber.struct.builder.impl.KeyChangeChooserImpl

class ImplementationFactory {
    fun <R, K> createKeyChangeChooser(key: DataKey<K>, r: R): KeyChangeChooser<R, K> {
        return KeyChangeChooserImpl(r, key)
    }
}
