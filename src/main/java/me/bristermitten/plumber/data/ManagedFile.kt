package me.bristermitten.plumber.data

import me.bristermitten.plumber.PlumberPlugin
import org.bukkit.configuration.file.YamlConfiguration

private const val separator = '.'

data class ManagedFile(private val fileName: String) : YamlConfiguration() {

    init {
        reload()
    }

    fun reload() {
        load(PlumberPlugin.activePlugin().dataFolder.resolve(fileName))
    }

    fun save() {
        save(PlumberPlugin.activePlugin().dataFolder.resolve(fileName))
    }

    fun loadDataInto(instance: Any, prefix: String) {
        instance::class.java.fields.forEach {
            if (!it.isAnnotationPresent(ConfigVar::class.java)) {
                return
            }
            val annotation = it.getAnnotation(ConfigVar::class.java)
            it.set(instance, this[prefix configChild annotation.path])
        }
    }

    private infix fun String.configChild(key: String): String = when {
        this.isEmpty() -> key
        this.endsWith(separator) -> this + key
        else -> this + separator + key
    }
}
