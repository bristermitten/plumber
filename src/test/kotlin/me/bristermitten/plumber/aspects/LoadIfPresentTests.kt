package me.bristermitten.plumber.aspects

import me.bristermitten.plumber.PlumberExtension
import me.bristermitten.plumber.newaspect.Aspect
import me.bristermitten.plumber.newaspect.LoadIfPresent
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@LoadIfPresent(ThirdParty::class)
class LoadIfPresentAspect : Aspect {
    override fun enable() {
        enabled = true
    }

    companion object {
        var enabled = false
    }
}

@Retention(AnnotationRetention.RUNTIME)
annotation class ThirdParty


@ExtendWith(PlumberExtension::class)
@ThirdParty
class LoadIfPresentTests {

    @Test
    fun `Test Load If Present is Loaded`() {
        assertTrue(LoadIfPresentAspect.enabled)
    }
}
