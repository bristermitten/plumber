package me.bristermitten.plumber.struct.builder.impl;

import me.bristermitten.plumber.struct.builder.KeyChangeChooser;
import me.bristermitten.plumber.struct.key.DataKey;

import java.util.function.Consumer;

public class KeyChangeChooserImpl<R, K> implements KeyChangeChooser<R, K> {

    private final R r;
    private final DataKey<K> watching;
    private final Runnable callback;
    private Consumer<K> consumer;

    public KeyChangeChooserImpl(R r, DataKey<K> key, Runnable callback) {
        this.r = r;
        this.watching = key;
        this.callback = callback;
    }

    @Override
    public R toValue(K value) {
        if (consumer != null)
            watching.getHandlers().remove(consumer);

        consumer = v -> {
            if (value.equals(v)) {
                callback.run();
            }
        };
        watching.getHandlers().add(consumer);
        return r;
    }

    @Override
    public void reset() {
        watching.getHandlers().remove(consumer);
    }
}
