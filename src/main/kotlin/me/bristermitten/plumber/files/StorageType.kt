package me.bristermitten.plumber.files

import me.bristermitten.plumber.annotation.Unstable

/**
 * Types of File or storage to use for saving and loading data
 */
@Unstable("Functional but not documented and undergoing heavy refactoring")
enum class StorageType {
    /**
     * Use Gson to load and save to a JSON file
     */
    JSON,
    /**
     * Use Gson and SnakeYaml to load and save to a YAML file.
     * Significantly slower than JSON as because of limitations with generics,
     * The data is first deserialized by Snakeyaml as [Any],
     * then serialized to a JSON Tree by Gson, then deserialized to the required type
     */
    YAML,
    @Deprecated("Not yet implemented")
    SQL,
    /**
     * Infer the type from the given file name in [MappedTo]
     */
    INFER
}
