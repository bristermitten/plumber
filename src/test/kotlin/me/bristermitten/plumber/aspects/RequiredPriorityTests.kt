package me.bristermitten.plumber.aspects

import me.bristermitten.plumber.PlumberExtension
import me.bristermitten.plumber.newaspect.Aspect
import me.bristermitten.plumber.newaspect.RequiredAspect
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import kotlin.reflect.KClass

@RequiredAspect(priority = 1)
class Priority1 : Aspect {

    override fun enable() {
        order.add(Priority1::class)
    }

    override fun disable() {
    }

}

@RequiredAspect(priority = 2)
class Priority2 : Aspect {
    override fun enable() {
        order.add(Priority2::class)
    }

    override fun disable() {
    }

}

val order = LinkedHashSet<KClass<out Aspect>>(2)


@ExtendWith(PlumberExtension::class)
class RequiredPriorityTests {

    @Test
    fun `Test RequiredAspects registered in correct order`() {
        val iterator = order.iterator()
        assertEquals(Priority2::class, iterator.next())
        assertEquals(Priority1::class, iterator.next())
    }
}

