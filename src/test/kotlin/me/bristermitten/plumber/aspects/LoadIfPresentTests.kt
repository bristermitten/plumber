package me.bristermitten.plumber.aspects

import me.bristermitten.plumber.PlumberExtension
import me.bristermitten.plumber.newaspect.Aspect
import me.bristermitten.plumber.newaspect.LoadIfPresent
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@LoadIfPresent(ThirdPartyAnnotation::class)
class LoadIfPresentAspect : Aspect {
    override fun enable(classes: Collection<Class<*>>) {
        enabled = true
        LoadIfPresentAspect.classes = classes
    }

    companion object {
        var enabled = false
        var classes: Collection<Class<*>> = emptySet()
    }
}

@Retention(AnnotationRetention.RUNTIME)
annotation class ThirdPartyAnnotation


@ExtendWith(PlumberExtension::class)
@ThirdPartyAnnotation
class LoadIfPresentTests {

    @Test
    fun `Test Load If Present is Loaded`() {
        assertTrue(LoadIfPresentAspect.enabled)
        assertEquals(setOf(LoadIfPresentTests::class.java), LoadIfPresentAspect.classes)
    }
}
