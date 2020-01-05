package me.bristermitten.plumber.aspect.component

import com.google.inject.Module
import me.bristermitten.plumber.aspect.AbstractAspect
import me.bristermitten.plumber.aspect.RequiredAspect
import me.bristermitten.plumber.util.Reflection.createGuiceModule

/**
 * Required Aspect that facilitates the injection of all [Component] classes
 * They are bound as eager singletons
 */
@RequiredAspect(priority = Int.MIN_VALUE)
class ComponentAspect : AbstractAspect() {
    override fun getModule(): Module {
        return createGuiceModule {
            classes
                .forEach {
                    bind(it).asEagerSingleton()
                    logger.debug("Bound Component class {}", it)
                }
        }
    }
}
