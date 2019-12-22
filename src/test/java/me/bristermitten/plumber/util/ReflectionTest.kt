package me.bristermitten.plumber.util

import org.junit.Assert.assertTrue
import org.junit.Test

class ReflectionTest {

    @Test
    fun invokeNoArgsStaticMethod() {
        Reflection.invokeNoArgsStaticMethod(javaClass, "doSomething")
        assertTrue(invoked)
    }

    companion object {
        var invoked = false

        @JvmStatic
        fun doSomething() {
            invoked = true
        }
    }

}
