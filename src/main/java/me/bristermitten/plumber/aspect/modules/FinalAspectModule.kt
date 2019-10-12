package me.bristermitten.plumber.aspect.modules

import com.google.inject.AbstractModule
import com.google.inject.Injector
import com.google.inject.Module
import me.bristermitten.plumber.aspect.Aspect

class FinalAspectModule(
        private val parent: Module,
        private val injector: Injector,
        private val lateAspects: Set<Class<out Aspect>>
) :
        AbstractModule() {

    override fun configure() {
        install(parent)
        lateAspects.forEach {
            val instance = injector.getInstance(it)
            bind(instance.javaClass).toInstance(instance)
        }
    }
}
