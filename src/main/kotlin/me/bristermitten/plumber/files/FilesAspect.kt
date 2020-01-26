package me.bristermitten.plumber.files

import com.google.gson.reflect.TypeToken
import com.google.inject.Inject
import com.google.inject.Module
import me.bristermitten.plumber.annotation.HideFromReflection
import me.bristermitten.plumber.annotation.Unstable
import me.bristermitten.plumber.aspect.AbstractAspect
import me.bristermitten.plumber.aspect.RequiredAspect
import me.bristermitten.plumber.aspect.StaticModule
import me.bristermitten.plumber.files.store.*
import me.bristermitten.plumber.util.Reflection.createGuiceModule
import me.bristermitten.plumber.util.isAssignableFrom
import me.bristermitten.reflector.Reflector
import org.apache.commons.io.FilenameUtils
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Proxy
import java.lang.reflect.Type


@Unstable("Functional but not documented and undergoing heavy refactoring")
//@StaticModule(FilesAspectStaticModule::class)
//@RequiredAspect
@HideFromReflection
class FilesAspect @Inject constructor(
    private val reflector: Reflector,
    private val plumberFileFactory: PlumberFileFactory
) : AbstractAspect() {

    private val stores: MutableMap<Class<*>, Any> = HashMap()

    override fun doEnable() {
        classes
            .parallelStream()
            .map { reflector.getStructure(it) }
            .filter { it.isSubTypeOf(Store::class.java) }
            .filter {
                val hasAnnotation = it.info.hasAnnotationType(MappedTo::class.java)
                if (!hasAnnotation) {
                    logger.warn(
                        "Store class {} is not annotated with @MappedToFile. It will not be loaded.",
                        it.type.name
                    )
                }
                hasAnnotation
            }
            .forEach { structure ->

                @Suppress("UNCHECKED_CAST") //safe, checked in filter
                val type = structure.type as Class<out Store<*>>

                val typeParameters = getStoreTypeParameters(type)

                val info = getFileInfo(structure.info.getAnnotation(MappedTo::class.java))

//                val delegate = structure.info.getAnnotation(StoreInfo::class.java)
//                    ?: throw BadStoreException("Store class has no Delegate type ${structure.type}")


                val file = when (info.type) {
                    StorageType.YAML -> plumberFileFactory.createYaml(info.name)
                    StorageType.JSON -> plumberFileFactory.createJson(info.name)
                    else -> return@forEach
                }

                val handler: StoreProxyHandler<*, *>
                val typeOfStore: Class<*>

                when {
                    structure.isSubTypeOf(DictionaryStore::class.java) -> {
                        typeOfStore = typeParameters[1] as Class<*>
                        handler = StoreProxyHandler<MutableMap<Any, Any>, Any>(
                            HashMap(),
                            DictionaryHandler(reflector),
                            file,
                            typeOfStore,
                            reflector
                        )
                    }
                    structure.isSubTypeOf(ObjectStore::class.java) -> {
                        typeOfStore = typeParameters[0] as Class<*>
                        handler = StoreProxyHandler<MutableList<Any>, Any>(
                            ArrayList(),
                            ObjectStoreHandler(),
                            file,
                            typeOfStore,
                            reflector
                        )
                    }
                    else -> {
                        return@forEach
                    }
                }


                val store = Proxy.newProxyInstance(javaClass.classLoader, arrayOf(type), handler) as Store<*>
                file.mapped = store

                val collection = handler.values!!
                val token = TypeToken.getParameterized(collection.javaClass, *typeParameters.toTypedArray())


                file.type = token
                stores[type] = store
                logger.info("Registered $type")
            }
    }

    /**
     * Get the type parameters of a given Store class
     * Given a `class extends StoreImplementation<ParamA, ParamB> extends Store<ParamA>`
     * this will retrieve ```[ParamA]```
     */
    private fun getStoreTypeParameters(type: Class<out Store<*>>): List<Type> {
        return type.genericInterfaces
            .filterIsInstance<ParameterizedType>()
            .first {
                //eg KeyValueStore or ValueStore
                Store::class.isAssignableFrom(it.rawType)
            }.actualTypeArguments.toList() //eg ValueStore<Data> => [Data]
    }

    private fun getFileInfo(mappedTo: MappedTo): FileInfo {
        if (mappedTo.type != StorageType.INFER)
            return FileInfo(mappedTo.fileName, mappedTo.type)

        val type = when (FilenameUtils.getExtension(mappedTo.fileName).toLowerCase()) {
            "json" -> StorageType.JSON
            "yml" -> StorageType.YAML
            "yaml" -> StorageType.YAML
//            "db" -> StorageType.SQL
//            "sql" -> StorageType.SQL
            else -> StorageType.YAML
        }
        return FileInfo(mappedTo.fileName, type)
    }

    data class FileInfo(val name: String, val type: StorageType)


    override fun getModule(): Module {
        return createGuiceModule {
            stores.forEach { (clazz, instance) ->
                @Suppress("UNCHECKED_CAST")
                bind(clazz as Class<in Any>).toInstance(instance)
            }
        }

    }
}
