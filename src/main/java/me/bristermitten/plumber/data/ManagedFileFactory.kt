package me.bristermitten.plumber.data

import com.google.inject.Singleton

interface ManagedFileFactory {

    fun create(name: String): ManagedFile
}
