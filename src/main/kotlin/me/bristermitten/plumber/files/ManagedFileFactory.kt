package me.bristermitten.plumber.files

/**
 * Guice factory for creating [ManagedFile] instances
 */
interface ManagedFileFactory {
    fun create(name: String): ManagedFile
}
