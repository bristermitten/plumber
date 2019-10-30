package me.bristermitten.plumber.util

import org.junit.Assert.assertTrue
import org.junit.Test

class ReflectionUtilTest {
    @Test
    fun invokeNoArgsStaticMethod() {
        ReflectionUtil.invokeNoArgsStaticMethod(javaClass, "doSomething")
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
