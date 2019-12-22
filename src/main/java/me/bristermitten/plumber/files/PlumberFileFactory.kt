package me.bristermitten.plumber.files

interface PlumberFileFactory {
    fun createYaml(name: String) : YamlPlumberFile
    fun createJson(name: String) : JsonPlumberFile
}
