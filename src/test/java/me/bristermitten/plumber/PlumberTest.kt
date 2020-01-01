package me.bristermitten.plumber

import be.seeseemelk.mockbukkit.MockBukkit
import me.bristermitten.demoplumberapp.DemoPlugin
import org.junit.After
import org.junit.Before

open class PlumberTest {
    protected lateinit var plugin: DemoPlugin

    @Before
    open fun setUp() {
        MockBukkit.mock()
        plugin = MockBukkit.load(DemoPlugin::class.java)
    }

    @After
    open fun tearDown() {
        MockBukkit.unload()
    }

}
