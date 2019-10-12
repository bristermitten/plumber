package me.bristermitten.plumber.scheduling

import com.google.inject.AbstractModule
import com.google.inject.Module
import com.google.inject.assistedinject.FactoryModuleBuilder
import me.bristermitten.plumber.aspect.AbstractAspect
import me.bristermitten.plumber.aspect.RequiredAspect
import me.bristermitten.plumber.scheduling.timings.TaskBuilder

/**
 * Aspect that handles the scheduler related functionality of Plumber
 * Currently, all it does is installs the required Assisted Injection factories
 */
@RequiredAspect
class SchedulerAspect : AbstractAspect() {

    override fun module(): Module {
        return object : AbstractModule() {
            override fun configure() {
                install(FactoryModuleBuilder()
                        .implement(TaskBuilder::class.java, TaskBuilder.impl)
                        .build(TaskBuilderFactory::class.java))

                install(FactoryModuleBuilder()
                        .build(TaskFactory::class.java)
                )
            }
        }
    }
}
