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
class ManagedFile
@Inject constructor(plugin: PlumberPlugin, @Assisted private val fileName: String) : YamlConfiguration() {

    val instances: MutableSet<Any> = hashSetOf()
    val path = plugin.dataFolder.resolve(fileName)

    init {
        reload()
    }

    /**
     * Reload data from the file into the internal map
     * This also re-injects any [Configuration] objects
     * @see YamlConfiguration.load
     */
    fun reload() {
        val toPath = path.absoluteFile.toPath()

        if (Files.notExists(toPath)) {
            path.parentFile.mkdirs()
            Files.createFile(toPath)
        }
        load(path)
        instances.forEach(this::loadDataInto)
    }

    /**
     * Save data to the file
     * @see YamlConfiguration.save
     */
    fun save() {
        save(path)
    }

    /**
     * Load data into a [Configuration] object from the file's data
     * The given object will be stored and re-injected on [reload]
     * Will scan all fields annotated with [ConfigVar] and attempt to get a value from the file, if so, it will be injected
     */
    fun loadDataInto(instance: Any, prefix: String) {
        instances.add(instance)
        (instance.javaClass.declaredFields + instance.javaClass.fields).forEach {
            if (it.type == ManagedFile::class.java) {
                it.set(instance, this)
                return
            }
            if (!it.isAnnotationPresent(ConfigVar::class.java)) {
                return
            }
            val annotation = it.getAnnotation(ConfigVar::class.java)
            val path = prefix child annotation.value
            val value: Any? = get(path, null)

            it.isAccessible = true
            if (value != null)
                it.set(instance, value)
            else if (it.get(instance) != null) {
                this[path] = it.get(instance)
            }
        }
    }

    fun loadDataInto(instance: Any) {
        val annotation = instance.javaClass.getAnnotation(Configuration::class.java) ?: return

        loadDataInto(instance, annotation.prefix)
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
