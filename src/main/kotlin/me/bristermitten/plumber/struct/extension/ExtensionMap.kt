package me.bristermitten.plumber.struct.extension

import com.google.inject.AbstractModule
import com.google.inject.Inject
import com.google.inject.Injector

class ExtensionMap
@Inject constructor(private var injector: Injector) : MutableMap<Class<out Extension<*>>, Extension<*>> by HashMap() {

    fun init(owner: Extendable<*, *>) {
        val module = object : AbstractModule() {
            override fun configure() {
                bind(owner.javaClass).toInstance(owner)
            }
        }
        injector = injector.createChildInjector(module)
    }

    fun getExtension(extension: Class<out Extension<*>>): Extension<*> {
        return getOrPut(extension, { create(extension) })
    }

    private fun create(extension: Class<out Extension<*>>): Extension<*> {
        return injector.getInstance(extension)
    }
}
