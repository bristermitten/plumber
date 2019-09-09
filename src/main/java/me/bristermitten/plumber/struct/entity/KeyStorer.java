package me.bristermitten.plumber.struct.entity;

import me.bristermitten.plumber.struct.DataKey;

public interface KeyStorer {
    <K> void setData(DataKey<K> key, K data);

    <K> K getData(DataKey<K> key);
}
