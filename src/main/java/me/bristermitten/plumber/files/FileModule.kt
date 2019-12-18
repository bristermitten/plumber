package me.bristermitten.plumber.files

import com.google.inject.AbstractModule
import com.google.inject.Inject
import com.google.inject.assistedinject.FactoryModuleBuilder
import me.bristermitten.plumber.aspect.AspectManager

/**
 * Guice module for [FileAspect]
 *
 */
class FileModule @Inject constructor(private val manager: AspectManager) : AbstractModule() {

    override fun configure() {
        install(FactoryModuleBuilder().build(ManagedFileFactory::class.java))
        manager.classesForAspect(FileAspect::class.java).forEach {
            bind(it).asEagerSingleton()
        }
    }
}
