package me.bristermitten.plumber.files

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.inject.Inject
import com.google.inject.assistedinject.Assisted
import me.bristermitten.plumber.PlumberPlugin
import me.bristermitten.plumber.annotation.Unstable
import org.yaml.snakeyaml.Yaml
import java.io.File
import java.io.InputStream
import java.io.OutputStream
@Unstable("Functional but not documented and undergoing heavy refactoring")
abstract class AbstractPlumberFile(name: String, plugin: PlumberPlugin) : PlumberFile {
    private val file = File(plugin.dataFolder, name)
    lateinit var mapped: Store<*>
    lateinit var type: TypeToken<*>

    protected abstract fun loadFrom(inputStream: InputStream): Any
    protected abstract fun saveTo(outputStream: OutputStream)

    override fun loadData() {
        file.createNewFile()
        val loaded = loadFrom(file.inputStream())
        mapped.loadWith(loaded)
    }

    override fun saveData() {
        saveTo(file.outputStream())
    }
}

class YamlPlumberFile @Inject constructor(
        @Assisted name: String,
        plugin: PlumberPlugin,
        private val yaml: Yaml,
        private val gson: Gson
) : AbstractPlumberFile(name, plugin) {

    override fun loadFrom(inputStream: InputStream): Any {
        val any = yaml.load<Any>(inputStream)
        return gson.fromJson(gson.toJsonTree(any), type.type)
    }

    override fun saveTo(outputStream: OutputStream) {
        yaml.dump(mapped, outputStream.writer())
    }
}

class JsonPlumberFile @Inject constructor(
        @Assisted name: String,
        plugin: PlumberPlugin,
        private val gson: Gson
) : AbstractPlumberFile(name, plugin) {

    override fun loadFrom(inputStream: InputStream): Any {
        return gson.fromJson(inputStream.reader(), type.type) ?: mapped
    }

    override fun saveTo(outputStream: OutputStream) {
        val writer = outputStream.writer()
        gson.toJson(mapped, writer)
        writer.flush()
    }
}
