package me.bristermitten.plumber.scheduling

import com.google.inject.Module
import com.google.inject.assistedinject.FactoryModuleBuilder
import me.bristermitten.plumber.aspect.AbstractAspect
import me.bristermitten.plumber.aspect.RequiredAspect
import me.bristermitten.plumber.reflection.Reflection.createGuiceModule
import me.bristermitten.plumber.scheduling.timings.TaskBuilder

/**
 * Aspect that handles the scheduler related functionality of Plumber
 * Currently, all it does is installs the required Assisted Injection factories
 */
@RequiredAspect(priority = 10)
class SchedulerAspect : AbstractAspect() {

    override fun getModule(): Module {
        return createGuiceModule {
            bind(TaskBuilder::class.java).to(TaskBuilder.impl)

            install(
                FactoryModuleBuilder()
                    .build(TaskFactory::class.java)
            )
        }
    }
}
