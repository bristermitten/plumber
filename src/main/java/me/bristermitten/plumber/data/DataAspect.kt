package me.bristermitten.plumber.data

import com.google.inject.AbstractModule
import com.google.inject.Inject
import com.google.inject.Module
import com.google.inject.Singleton
import me.bristermitten.plumber.newaspect.AbstractAspect
import me.bristermitten.plumber.newaspect.AspectReflectionManager

class DataAspect : AbstractAspect() {

    @Inject
    lateinit var store: ConfigStore

    @Inject
    lateinit var manager: AspectReflectionManager


    private val fileClasses: MutableSet<Class<*>> = HashSet()

    override fun doEnable() {
        fileClasses.forEach {
            val data = it.getAnnotation(Configuration::class.java)
            val file = store.fileNamed(data.fileName)

            file.loadDataInto(instance(it), data.prefix)
            logger.info("Loaded configuration file {}", it.simpleName)
        }
    }

    override fun module(): Module? {
        return object : AbstractModule() {
            override fun configure() {
                manager.classesForAspect(this@DataAspect)
                        .forEach {
                            fileClasses.add(it)
                            bind(it).asEagerSingleton()
                        }
            }
        }
    }

    @Singleton
    class ConfigStore {
        private val store: MutableMap<String, ManagedFile> = HashMap()

        fun fileNamed(name: String): ManagedFile {
            return store.getOrPut(name) {
                ManagedFile(name)
            }
        }
    }
}
