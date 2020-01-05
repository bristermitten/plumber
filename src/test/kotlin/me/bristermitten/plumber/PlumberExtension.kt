package me.bristermitten.plumber

import be.seeseemelk.mockbukkit.MockBukkit
import org.junit.jupiter.api.extension.AfterAllCallback
import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.ExtensionContext

/**
 * Jupiter extension that ensures that Plumber is loaded before tests occur
 * It only loads once for the entire test suite to increase performance
 */
class PlumberExtension : BeforeAllCallback {

    override fun beforeAll(context: ExtensionContext) {
        if (loaded) return
        MockBukkit.mock()
      plugin=  MockBukkit.load(TestPlugin::class.java)
        loaded = true
    }

    companion object {
        var loaded = false
        lateinit var plugin: TestPlugin
        private set
    }
}
