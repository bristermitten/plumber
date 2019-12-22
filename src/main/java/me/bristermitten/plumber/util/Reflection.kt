package me.bristermitten.plumber.util

import com.google.inject.AbstractModule
import com.google.inject.Binder

object Reflection {
    /**
     * Invoke a static method upon a class that has no arguments
     * @param clazz the class holding the method
     * @param methodName the method name
     * @return the object returned by the method
     */
    @JvmStatic
    fun invokeNoArgsStaticMethod(clazz: Class<*>, methodName: String?): Any? {
        return try {
            clazz.getDeclaredMethod(methodName).invoke(null)
        } catch (e: ReflectiveOperationException) {
            e.printStackTrace()
            null
        }
    }

    @JvmStatic
    fun createAbstractModule(block : Binder.() -> Unit): AbstractModule {
        return object : AbstractModule() {
            override fun configure() {
                block(binder())
            }
        }
    }
}
