package me.bristermitten.plumber.object.key;

public interface KeyHolder {
    <K> void setData(DataKey<K> key, K data);

    <K> void setDataRaw(DataKey<K> key, K data);

    <K> K getData(DataKey<K> key);
}
