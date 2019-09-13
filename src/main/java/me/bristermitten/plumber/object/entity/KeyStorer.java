package me.bristermitten.plumber.object.entity;

import me.bristermitten.plumber.object.DataKey;

public interface KeyStorer {
    <K> void setData(DataKey<K> key, K data);

    <K> K getData(DataKey<K> key);
}
