package me.bristermitten.plumber.files

import com.google.inject.Inject
import com.google.inject.assistedinject.Assisted
import me.bristermitten.plumber.PlumberPlugin
import org.bukkit.configuration.file.YamlConfiguration
import java.nio.file.Files

/**
 * The internal separator character for nested YAML values
 */
private const val separator = '.'

/**
 * Wraps a file to provide [YamlConfiguration] functionality without boilerplate of loading the file
 * Created with [ManagedFileFactory] through Guice
 */
data class ManagedFile
@Inject constructor(
        private val plugin: PlumberPlugin,
        @Assisted private val fileName: String) :
        YamlConfiguration() {

    private val path = plugin.dataFolder.resolve(fileName)

    init {
        reload()
    }

    /**
     * Reload data from the file into the internal map
     * @see YamlConfiguration.load
     */
    @Suppress("MemberVisibilityCanBePrivate")
    fun reload() {
        val toPath = path.absoluteFile.toPath()

        if (Files.notExists(toPath)) {
            path.parentFile.mkdirs()
            Files.createFile(toPath)
        }
        load(path)
    }

    /**
     * Save data to the file
     * @see YamlConfiguration.save
     */
    fun save() {
        save(path)
    }

    /**
     * Load data into a [Configuration] object
     * from the file's data
     * Will scan all fields annotated with [ConfigVar] and attempt to get a value from the file, if so, it will be injected
     */
    fun loadDataInto(instance: Any, prefix: String) {
        instance::class.java.fields.forEach {
            if (!it.isAnnotationPresent(ConfigVar::class.java)) {
                return
            }
            val annotation = it.getAnnotation(ConfigVar::class.java)
            val value: Any? = get(prefix child annotation.value)

            if (value != null)
                it.set(instance, value)
            else if (it.get(instance) != null) {
                set(value, it.get(instance))
            }
        }
    }

    /**
     * Extension function for strings that provides YAML child mapping
     * @sample "test".child("child") => "test.child"
     * @sample "test.".child("child") => "test.child"
     */
    private infix fun String.child(key: String): String = when {
        this.isEmpty() -> key
        this.endsWith(separator) -> this + key
        else -> this + separator + key
    }
}
