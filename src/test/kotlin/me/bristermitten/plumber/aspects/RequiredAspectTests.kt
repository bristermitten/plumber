package me.bristermitten.plumber.aspects

import me.bristermitten.plumber.PlumberExtension
import me.bristermitten.plumber.newaspect.Aspect
import me.bristermitten.plumber.newaspect.RequiredAspect
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@RequiredAspect
class Required : Aspect {
    override fun enable() {
        enabled = true
    }

    override fun disable() {
    }

    companion object {
        var enabled = false
    }

}
@ExtendWith(PlumberExtension::class)
class RequiredTests {
    @Test
    fun `Test Required Aspect Enabled`(){
        assertTrue(Required.enabled)
    }

}
