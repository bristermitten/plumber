package me.bristermitten.plumber.newaspect.modules

import com.google.inject.AbstractModule
import com.google.inject.Module
import me.bristermitten.plumber.newaspect.AspectReflectionManager

class AspectModule(private val parent: InitialModule, private val reflection: AspectReflectionManager, vararg val children: Module) : AbstractModule() {


    override fun configure() {
        install(parent)
        children.forEach { install(it) }
        reflection.requiredAspects.forEach {
            bind(it).asEagerSingleton()
        }
    }
}
