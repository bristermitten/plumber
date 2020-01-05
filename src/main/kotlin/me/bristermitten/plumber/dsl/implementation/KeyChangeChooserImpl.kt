package me.bristermitten.plumber.dsl.implementation

import me.bristermitten.plumber.dsl.KeyChangeChooser
import me.bristermitten.plumber.struct.key.DataKey
import java.util.function.Consumer

class KeyChangeChooserImpl<R, K>(
    private val r: R,
    private val watching: DataKey<K>,
    private val callback: Runnable
) :
    KeyChangeChooser<R, K> {

    private var consumer: Consumer<K>? = null

    override fun toValue(value: K): R {
        if (consumer != null) watching.handlers.remove(consumer)
        consumer = Consumer { v: K ->
            if (value == v) {
                callback.run()
            }
        }
        watching.handlers.add(consumer)
        return r
    }

    override fun reset() {
        watching.handlers.remove(consumer)
    }

}
