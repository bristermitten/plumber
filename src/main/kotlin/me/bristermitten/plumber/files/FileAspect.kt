package me.bristermitten.plumber.files

import com.google.inject.Inject
import com.google.inject.Singleton
import me.bristermitten.plumber.aspect.AbstractAspect
import me.bristermitten.plumber.aspect.AspectModule
import me.bristermitten.plumber.aspect.AspectReflectionManager
import me.bristermitten.plumber.aspect.RequiredAspect

/**
 * Internal Aspect that manages files being mapped to configuration classes
 * Has a static Guice module of [FileModule]
 */
@RequiredAspect
@AspectModule(FileModule::class)
class FileAspect : AbstractAspect() {
    @Inject
    lateinit var store: ConfigStore

    @Inject
    lateinit var factory: ManagedFileFactory

    @Inject
    lateinit var manager: AspectReflectionManager


    /**
     * Enable the aspect, which causes the scanning of all required classes, and the loading of file data into the classes
     */
    override fun doEnable() {
        val fileClasses = manager.classesForAspect(this)
        fileClasses.forEach {
            val data = it.getAnnotation(Configuration::class.java)
            val file = store.fileNamed(data.fileName)

            file.loadDataInto(instance(it), data.prefix)
            logger.info("Loaded configuration file {}", it.simpleName)
            file.save()
        }
    }


    /**
     * Store of file names to instances of [ManagedFile]
     */
    @Singleton
    class ConfigStore {
        @Inject
        lateinit var dataAspect: FileAspect
        private val store: MutableMap<String, ManagedFile> = HashMap()

        fun fileNamed(name: String): ManagedFile {
            return store.getOrPut(name) {
                dataAspect.factory.create(name)
            }
        }
    }
}
