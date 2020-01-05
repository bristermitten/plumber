package me.bristermitten.plumber.files

import com.google.gson.reflect.TypeToken
import com.google.inject.Inject
import com.google.inject.Module
import me.bristermitten.plumber.aspect.AbstractAspect
import me.bristermitten.plumber.aspect.RequiredAspect
import me.bristermitten.plumber.aspect.StaticModule
import me.bristermitten.plumber.util.Reflection.createGuiceModule
import me.bristermitten.reflector.Reflector
import org.apache.commons.io.FilenameUtils
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Proxy


@StaticModule(FilesAspectStaticModule::class)
@RequiredAspect
class FilesAspect @Inject constructor(
    private val reflector: Reflector,
    private val plumberFileFactory: PlumberFileFactory
) : AbstractAspect() {


    private val stores: MutableSet<Pair<Class<*>, Any>> = HashSet()

    override fun doEnable() {
        classes.map { reflector.getStructure(it) }
            .filter { it.isSubTypeOf(Store::class.java) }
            .forEach { structure ->
                val type = structure.type

                val typeParameters = type.genericInterfaces.filterIsInstance<ParameterizedType>()
                    .first {
                        Store::class.java.isAssignableFrom(it.rawType as Class<*>)
                    }.actualTypeArguments.toList()

                if (!structure.info.hasAnnotationType(MappedTo::class.java)) {
                    logger.warn("Store class ${type.name} is not annotated with @MappedToFile. It will not be loaded.")
                    return@forEach
                }

                val info = getFileInfo(structure.info.getAnnotation(MappedTo::class.java))

                val file = when (info.type) {
                    FileType.YAML -> plumberFileFactory.createYaml(info.name)
                    FileType.JSON -> plumberFileFactory.createJson(info.name)
                    else -> null
                } ?: return@forEach

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
                        return@forEach
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

    override fun getModule(): Module {
        return createGuiceModule {
            stores.forEach { (clazz, instance) ->
                @Suppress("UNCHECKED_CAST")
                bind(clazz as Class<in Any>).toInstance(instance)
            }
        }

    }
}
