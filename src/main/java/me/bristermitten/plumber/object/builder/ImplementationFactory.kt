package me.bristermitten.plumber.`object`.builder

import me.bristermitten.plumber.`object`.builder.impl.KeyChangeChooserImpl
import me.bristermitten.plumber.`object`.key.DataKey

class ImplementationFactory {
    fun <R, K> createKeyChangeChooser(key: DataKey<K>, r: R, callback: Runnable): KeyChangeChooser<R, K> {
        return KeyChangeChooserImpl(r, key, callback)
    }
}
