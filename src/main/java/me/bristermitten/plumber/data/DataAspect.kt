package me.bristermitten.plumber.data

import com.google.inject.Inject
import com.google.inject.Singleton
import me.bristermitten.plumber.aspect.AbstractAspect

class DataAspect : AbstractAspect() {

    @Inject
    lateinit var store: ConfigStore

    override fun loadParts(annotatedClasses: MutableSet<Class<*>>) {
        annotatedClasses.forEach {

            val data = it.getAnnotation(Configuration::class.java)
            val file = store.fileNamed(data.fileName)

            file.loadDataInto(instance(it), data.prefix)
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
