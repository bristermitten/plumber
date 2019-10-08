package me.bristermitten.plumber.files

interface ManagedFileFactory {

    fun create(name: String): ManagedFile
}
