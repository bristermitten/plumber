package me.bristermitten.plumber.struct.key;

import org.jetbrains.annotations.NotNull;

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
     * @return the value of the key, or the key's default value
     */
    @NotNull
    <K> K getData(DataKey<K> key);

    /**
     * Get a key's value, with a default value if the value is null
     *
     * @param key the key to get
     * @param <K> the type of the key
     * @return the value of the key, which will not be null
     */
    @NotNull
    <K> K getData(DataKey<K> key, @NotNull K defaultValue);
}
