package me.bristermitten.plumber.data

import com.google.inject.AbstractModule
import com.google.inject.Inject
import com.google.inject.assistedinject.FactoryModuleBuilder
import me.bristermitten.plumber.aspect.AspectReflectionManager

class DataModule @Inject constructor(private val manager: AspectReflectionManager) : AbstractModule() {
    override fun configure() {
        install(FactoryModuleBuilder().build(ManagedFileFactory::class.java))
        manager.classesForAspect(DataAspect::class.java)
                .forEach {
                    bind(it).asEagerSingleton()
                }
    }
}
