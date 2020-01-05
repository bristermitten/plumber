package me.bristermitten.plumber.struct.key

/**
 * A KeyHolder defines an entity that holds key-value storage in the form of [DataKey]
 */
interface KeyHolder {
    /**
     * Update a key's value
     * The key's handlers WILL be called
     *
     * @param key  the key to update
     * @param data the new value
     * @param <K>  the type of the key
     */
    fun <K : Any> setData(key: DataKey<K>, data: K)

    /**
     * Update a key's value
     * The key's handlers WILL NOT be called
     *
     * @param key  the key to update
     * @param data the new value
     * @param <K>  the type of the key
     */
    fun <K : Any> rawSetData(key: DataKey<K>, data: K)

    /**
     * Get a key's value
     *
     * @param key the key to get
     * @param <K> the type of the key
     * @return the value of the key, or the key's default value
     */
    fun <K : Any> getData(key: DataKey<K>): K

    /**
     * Get a key's value, with a default value if the value is null
     *
     * @param key the key to get
     * @param <K> the type of the key
     * @param defaultValue the default value if they key holder has a null value
     * @return the value of the key, which will not be null
     */
    fun <K: Any> getData(key: DataKey<K>, defaultValue: K): K
}
