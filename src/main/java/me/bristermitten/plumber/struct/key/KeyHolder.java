package me.bristermitten.plumber.struct.key;

import org.jetbrains.annotations.Nullable;

/**
 * A KeyHolder defines an entity that holds key-value storage in the form of {@link DataKey}
 */
public interface KeyHolder {
    /**
     * Update a key's value
     * The key's handlers WILL be called
     *
     * @param key  the key to update
     * @param data the new value
     * @param <K>  the type of the key
     */
    <K> void setData(DataKey<K> key, K data);

    /**
     * Update a key's value
     * The key's handlers WILL NOT be called
     *
     * @param key  the key to update
     * @param data the new value
     * @param <K>  the type of the key
     */
    <K> void rawSetData(DataKey<K> key, K data);

    /**
     * Get a key's value
     *
     * @param key the key to get
     * @param <K> the type of the key
     * @return the value of the key, which may be null
     */
    @Nullable
    <K> K getData(DataKey<K> key);
}
