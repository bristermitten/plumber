package me.bristermitten.plumber.struct.extension

import com.google.inject.AbstractModule
import com.google.inject.Inject
import com.google.inject.Injector
import java.util.*

class ExtensionMap
@Inject constructor(
        private var injector: Injector
) : HashMap<Class<out Extension>, Extension>() {

    @Suppress("UNCHECKED_CAST")
    private fun getExtendableSubType(clazz : Class<*>): Class<in Extendable> {
        if (clazz.interfaces.contains(Extendable::class.java)) {
            return clazz as Class<in Extendable>
        }
        for (`interface` in clazz.interfaces) {
            return getExtendableSubType(`interface`)
        }
        return getExtendableSubType(clazz.superclass)
    }

    fun init(owner: Extendable) {
        val extendableClass: Class<in Extendable> = getExtendableSubType(owner.javaClass)
        val module = object : AbstractModule() {
            override fun configure() {
                bind(owner.javaClass).toInstance(owner)
                bind(extendableClass).toInstance(owner)
            }
        }
        injector = injector.createChildInjector(module)
    }

    fun getExtension(extension: Class<out Extension>): Extension {
        if (containsKey(extension)) return getValue(extension)
        val value = create(extension)
        put(extension, value)
        return value
    }

    private fun create(extension: Class<out Extension>): Extension {
        return injector.getInstance(extension)
    }
}
