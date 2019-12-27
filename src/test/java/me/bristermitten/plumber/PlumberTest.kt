package me.bristermitten.plumber

import be.seeseemelk.mockbukkit.MockBukkit
import org.junit.After
import org.junit.Before
import org.junit.Test

open class PlumberTest {
    protected lateinit var plugin: TestPlugin

    @Before
    open fun setUp() {
        MockBukkit.mock()
        plugin = MockBukkit.load(TestPlugin::class.java)
    }

    @After
    open fun tearDown() {
        MockBukkit.unload()
    }

    @Test
    fun `Test Correct Loading`() {
    }
}
