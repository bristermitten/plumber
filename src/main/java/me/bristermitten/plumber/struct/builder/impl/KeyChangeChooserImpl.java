package me.bristermitten.plumber.struct.builder.impl;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import me.bristermitten.plumber.struct.DataKey;
import me.bristermitten.plumber.struct.builder.KeyChangeChooser;

public class KeyChangeChooserImpl<R, K> implements KeyChangeChooser<R, K> {

    private final R r;
    private final DataKey<K> watching;

    @Inject
    public KeyChangeChooserImpl(@Assisted R r, @Assisted DataKey<K> key) {
        this.r = (R) r;
        this.watching = key;
    }

    @Override
    public R toValue(K value) {
        //todo implement
        return r;
    }
}
