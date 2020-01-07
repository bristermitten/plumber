package me.bristermitten.plumber.files

import me.bristermitten.plumber.annotation.Unstable

@Unstable("Functional but not documented and undergoing heavy refactoring")
interface PlumberFileFactory {
    fun createYaml(name: String) : YamlPlumberFile
    fun createJson(name: String) : JsonPlumberFile
}
