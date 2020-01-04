package me.bristermitten.plumber.aspects

import me.bristermitten.plumber.PlumberExtension
import me.bristermitten.plumber.aspect.Aspect
import me.bristermitten.plumber.aspect.RequiredAspect
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import kotlin.reflect.KClass


@ExtendWith(PlumberExtension::class)
class RequiredPriorityTests {

    @Test
    fun `Test RequiredAspects registered in correct order`() {
        val iterator = order.iterator()
        assertEquals(Priority2::class, iterator.next())
        assertEquals(Priority1::class, iterator.next())
    }
}


@RequiredAspect(priority = 1)
class Priority1 : Aspect {
    override fun enable(classes: Collection<Class<*>>) {
        order.add(Priority1::class)
    }
}

@RequiredAspect(priority = 2)
class Priority2 : Aspect {
    override fun enable(classes: Collection<Class<*>>) {
        order.add(Priority2::class)
    }

}

val order = LinkedHashSet<KClass<out Aspect>>(2)
