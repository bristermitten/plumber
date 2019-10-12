package me.bristermitten.plumber.struct.builder

import me.bristermitten.plumber.struct.builder.impl.KeyChangeChooserImpl
import me.bristermitten.plumber.struct.key.DataKey

/**
 * Factory for creating objects that Guice cannot handle
 */
class ImplementationFactory {
    /**
     * Create a [KeyChangeChooser]
     * @param key the key to watch
     * @param r the value to watch for
     * @param callback the callback for when the key is set to the right value
     * @param K the type of the key
     * @param R the type of value
     */
    fun <R, K> createKeyChangeChooser(key: DataKey<K>, r: R, callback: Runnable): KeyChangeChooser<R, K> {
        return KeyChangeChooserImpl(r, key, callback)
    }
}
