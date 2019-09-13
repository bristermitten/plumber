package me.bristermitten.plumber.`object`.builder

import me.bristermitten.plumber.`object`.DataKey
import me.bristermitten.plumber.`object`.builder.impl.KeyChangeChooserImpl

class ImplementationFactory {
    fun <R, K> createKeyChangeChooser(key: DataKey<K>, r: R): KeyChangeChooser<R, K> {
        return KeyChangeChooserImpl(r, key)
    }
}
