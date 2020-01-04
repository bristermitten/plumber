package me.bristermitten.plumber.aspect.components

import com.google.inject.Inject
import com.google.inject.Module
import me.bristermitten.plumber.aspect.AbstractAspect
import me.bristermitten.plumber.aspect.AspectReflectionManager
import me.bristermitten.plumber.aspect.RequiredAspect
import me.bristermitten.plumber.aspect.modules.ModuleHelper
import org.bukkit.block.Beacon

/**
 * Required Aspect that facilitates the injection of all [Component] classes
 * They are bound as eager singletons
 */
@RequiredAspect
class ComponentAspect : AbstractAspect() {

    @Inject
    private lateinit var manager: AspectReflectionManager

    override fun module(): Module {
        return ModuleHelper { binder ->
            manager.classesForAspect(this@ComponentAspect)
                    .forEach {
                        binder.bind(it).asEagerSingleton()
                        logger.debug("Bound Component class {}", it)
                    }
        }
    }
}
