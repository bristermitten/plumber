package me.bristermitten.plumber.struct.builder

import me.bristermitten.plumber.struct.builder.impl.KeyChangeChooserImpl
import me.bristermitten.plumber.struct.key.DataKey

class ImplementationFactory {
    fun <R, K> createKeyChangeChooser(key: DataKey<K>, r: R, callback: Runnable): KeyChangeChooser<R, K> {
        return KeyChangeChooserImpl(r, key, callback)
    }
}
