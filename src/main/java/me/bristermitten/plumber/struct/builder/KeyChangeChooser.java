package me.bristermitten.plumber.struct.builder;

public interface KeyChangeChooser<R, K> {

    R toValue(K value);
}
