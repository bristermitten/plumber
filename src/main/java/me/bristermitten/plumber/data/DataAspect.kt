package me.bristermitten.plumber.data

import com.google.inject.Inject
import com.google.inject.Singleton
import me.bristermitten.plumber.aspect.AbstractAspect
import me.bristermitten.plumber.aspect.AspectModuleLink
import me.bristermitten.plumber.aspect.AspectReflectionManager
import me.bristermitten.plumber.aspect.RequiredAspect
import javax.annotation.Nonnull

@RequiredAspect
@AspectModuleLink(DataModule::class)
class DataAspect : AbstractAspect() {
    @Nonnull

    @Inject
    lateinit var store: ConfigStore

    @Inject
    lateinit var factory: ManagedFileFactory

    @Inject
    lateinit var manager: AspectReflectionManager



    override fun doEnable() {
        val fileClasses = manager.classesForAspect(this)
        println(fileClasses)
        fileClasses.forEach {
            val data = it.getAnnotation(Configuration::class.java)
            val file = store.fileNamed(data.fileName)

            file.loadDataInto(instance(it), data.prefix)
            logger.info("Loaded configuration file {}", it.simpleName)
            file.save()
        }
    }


    @Singleton
    class ConfigStore {
        @Inject
        lateinit var dataAspect: DataAspect
        private val store: MutableMap<String, ManagedFile> = HashMap()

        fun fileNamed(name: String): ManagedFile {
            return store.getOrPut(name) {
                dataAspect.factory.create(name)
            }
        }
    }
}
