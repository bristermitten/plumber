package me.bristermitten.plumber.util

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test


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
