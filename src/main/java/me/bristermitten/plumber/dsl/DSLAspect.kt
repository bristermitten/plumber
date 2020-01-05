package me.bristermitten.plumber.dsl

import com.google.inject.Module
import com.google.inject.assistedinject.FactoryModuleBuilder
import me.bristermitten.plumber.aspect.AbstractAspect
import me.bristermitten.plumber.aspect.RequiredAspect

/**
 * Aspect containing the management of all default DSL implementations
 */
@RequiredAspect
class DSLAspect : AbstractAspect() {

    override fun getModule(): Module {
        return FactoryModuleBuilder()
            .implement(PlayerActionBuilder::class.java, PlayerActionBuilder.impl)
            .implement(TaskLengthConfiguration::class.java, TaskLengthConfiguration.impl)
            .build(BuilderFactory::class.java)
    }
}
