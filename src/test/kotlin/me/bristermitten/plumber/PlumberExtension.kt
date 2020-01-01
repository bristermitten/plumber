package me.bristermitten.plumber

import be.seeseemelk.mockbukkit.MockBukkit
import org.junit.jupiter.api.extension.AfterAllCallback
import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.ExtensionContext

/**
 * Jupiter extension that ensures that Plumber is loaded before tests occur
 * It only loads once for the entire test suite to increase performance
 */
class PlumberExtension : BeforeAllCallback, AfterAllCallback {

    override fun beforeAll(context: ExtensionContext) {
        if (loaded) return
        MockBukkit.mock()
        MockBukkit.load(TestPlugin::class.java)
        loaded = true
    }

    override fun afterAll(context: ExtensionContext) {
        if (loaded && MockBukkit.isMocked()) MockBukkit.unload()
    }

    companion object {
        private var loaded = false
    }
}
