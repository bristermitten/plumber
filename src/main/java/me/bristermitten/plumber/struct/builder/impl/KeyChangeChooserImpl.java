package me.bristermitten.plumber.struct.builder.impl;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import me.bristermitten.plumber.struct.builder.KeyChangeChooser;

public class KeyChangeChooserImpl<R, K> implements KeyChangeChooser<R, K> {

    private final R r;

    @Inject
    public KeyChangeChooserImpl(@Assisted Object r) {
        this.r = (R) r;
    }

    @Override
    public R toValue(K value) {
        //todo implement
        return r;
    }
}
