package me.bristermitten.plumber.aspects

import me.bristermitten.plumber.PlumberExtension
import me.bristermitten.plumber.aspect.Aspect
import me.bristermitten.plumber.aspect.RequiredAspect
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(PlumberExtension::class)
class RequiredTests {
    @Test
    fun `Test Required Aspect Enabled`() {
        assertTrue(Required.enabled)
        assertTrue(Required.classes.isEmpty())
    }

}

@RequiredAspect
class Required : Aspect {

    override fun enable(classes: Collection<Class<*>>) {
        enabled = true
        Required.classes = classes
    }

    companion object {
        var enabled = false
        var classes: Collection<Class<*>> = emptySet()
    }

}
