package me.bristermitten.plumber.files

import com.google.inject.Inject
import com.google.inject.assistedinject.Assisted
import me.bristermitten.plumber.PlumberPlugin
import org.bukkit.configuration.file.YamlConfiguration
import java.nio.file.Files

private const val separator = '.'

data class ManagedFile @Inject constructor(private val plugin: PlumberPlugin,
                                           @Assisted private val fileName: String) : YamlConfiguration() {

    val path = plugin.dataFolder.resolve(fileName)

    init {
        reload()
    }

    fun reload() {
        val toPath = path.toPath()
        if (Files.notExists(toPath)) {
            Files.createFile(toPath)
        }
        load(path)
    }

    fun save() {
        save(path)
    }

    fun loadDataInto(instance: Any, prefix: String) {
        instance::class.java.fields.forEach {
            if (!it.isAnnotationPresent(ConfigVar::class.java)) {
                return
            }
            val annotation = it.getAnnotation(ConfigVar::class.java)
            val value: Any? = this.get(prefix child annotation.value)
            if (value != null)
                it.set(instance, value)
            else if (it.get(instance) != null) {
                this.set(value, it.get(instance))
            }
        }
    }

    private infix fun String.child(key: String): String = when {
        this.isEmpty() -> key
        this.endsWith(separator) -> this + key
        else -> this + separator + key
    }
}
