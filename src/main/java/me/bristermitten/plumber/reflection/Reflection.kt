package me.bristermitten.plumber.reflection

import dev.misfitlabs.kotlinguice4.KotlinBinder
import dev.misfitlabs.kotlinguice4.KotlinModule

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
    inline fun createGuiceModule(crossinline block : KotlinBinder.() -> Unit): KotlinModule {
        return object : KotlinModule() {
            override fun configure() {
                block(kotlinBinder)
            }
        }
    }
}
