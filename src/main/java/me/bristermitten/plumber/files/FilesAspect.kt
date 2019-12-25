package me.bristermitten.plumber.files

import com.google.gson.reflect.TypeToken
import com.google.inject.Inject
import com.google.inject.Module
import me.bristermitten.plumber.aspect.AbstractAspect
import me.bristermitten.plumber.aspect.AspectManager
import me.bristermitten.plumber.aspect.RequiredAspect
import me.bristermitten.plumber.aspect.StaticAspectModule
import me.bristermitten.plumber.util.Reflection.createAbstractModule
import me.bristermitten.reflector.Reflector
import org.apache.commons.io.FilenameUtils
import org.bukkit.Material
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Proxy


@StaticAspectModule(FilesAspectStaticModule::class, true)
@RequiredAspect
class FilesAspect : AbstractAspect() {

    @Inject
    private lateinit var manager: AspectManager

    @Inject
    private lateinit var plumberFileFactory: PlumberFileFactory

    @Inject
    private lateinit var reflector: Reflector

    private val stores: MutableSet<Pair<Class<*>, Any>> = HashSet()

    override fun doEnable() {
        loop@ for (structure in manager.classStructuresForAspect(this)) {
            if (structure.isSubTypeOf(Store::class.java)) {

                val type = structure.type

                val typeParameters = type.genericInterfaces.filterIsInstance<ParameterizedType>()
                        .first {
                            Store::class.java.isAssignableFrom(it.rawType as Class<*>)
                        }.actualTypeArguments.toList()

                if (!structure.info.hasAnnotationType(MappedTo::class.java)) {
                    logger.warn("Store class ${type.name} is not annotated with @MappedToFile. It will not be loaded.")
                    continue
                }

                val info = getFileInfo(structure.info.getAnnotation(MappedTo::class.java))

                val file = when (info.type) {
                    FileType.YAML -> plumberFileFactory.createYaml(info.name)
                    FileType.JSON -> plumberFileFactory.createJson(info.name)
                    else -> null
                } ?: continue

                val handler: StoreProxyHandler
                val typeOfStore: Class<*>

                when {
                    structure.isSubTypeOf(KeyValueStore::class.java) -> {
                        handler = KeyValueStoreProxyHandler(file, reflector)
                        typeOfStore = typeParameters[1] as Class<*>
                    }
                    structure.isSubTypeOf(ValueStore::class.java) -> {
                        handler = ValueStoreProxyHandler(file)
                        typeOfStore = typeParameters[0] as Class<*>
                    }
                    else -> {
                        continue@loop
                    }
                }

                handler.setType(typeOfStore)

                val store = Proxy.newProxyInstance(javaClass.classLoader, arrayOf(type), handler) as Store<*>
                file.mapped = store

                val collection = handler.collectionProxy
                val token = TypeToken.getParameterized(collection.javaClass, *typeParameters.toTypedArray())


                file.type = token
                stores.add(type to store)
                logger.info("Registered $type")
            } else {

            }
        }
    }

    private fun getFileInfo(mappedTo: MappedTo): FileInfo {
        if (mappedTo.type != FileType.INFER)
            return FileInfo(mappedTo.fileName, mappedTo.type)

        val type = when (FilenameUtils.getExtension(mappedTo.fileName).toLowerCase()) {
            "json" -> FileType.JSON
            "yml" -> FileType.YAML
            "yaml" -> FileType.YAML
            "db" -> FileType.SQL
            "sql" -> FileType.SQL
            else -> FileType.YAML
        }
        return FileInfo(mappedTo.fileName, type)
    }

    data class FileInfo(val name: String, val type: FileType)
    enum class FileType {
        JSON, YAML, SQL, INFER
    }

    override fun loadModule(): Module {
        return createAbstractModule {

            for ((clazz, instance) in stores) {
                @Suppress("UNCHECKED_CAST")
                bind(clazz as Class<in Any>).toInstance(instance)
            }
        }

    }
}
