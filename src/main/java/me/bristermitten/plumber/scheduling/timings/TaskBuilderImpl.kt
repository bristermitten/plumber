package me.bristermitten.plumber.scheduling.timings

import com.google.inject.Inject
import me.bristermitten.plumber.aspect.AspectLoader
import me.bristermitten.plumber.scheduling.SchedulerAspect
import me.bristermitten.plumber.scheduling.Task
import me.bristermitten.plumber.struct.builder.FluentBuilder
import me.bristermitten.plumber.struct.builder.TaskFactory

internal class TaskBuilderImpl @Inject constructor(
        private val factory: TimeUnitPickerFactory,
        loader: AspectLoader,
        private val taskFactory: TaskFactory
) : TaskBuilder {

    private var delayLength: Long = 0
    private var delayUnit = TimeUnit.MILLISECONDS


    private var repeatLength: Long = 0
    private var repeatUnit = TimeUnit.MILLISECONDS


    private var run: Runnable? = null

    override fun every(period: Long): TimeUnitPicker {
        repeatLength = period
        return factory.pick(this) { repeatUnit = it }
    }

    override fun `in`(wait: Long): TimeUnitPicker {
        delayLength = wait
        return factory.pick(this) { delayUnit = it }
    }


    override fun doing(r: Runnable): TaskBuilder {
        run = r
        return this
    }

    override fun build(): Task {
        checkNotNull(run)
        val delay = delayUnit.toTicks(delayLength);
        val period = repeatUnit.toTicks(repeatLength);
        return taskFactory.create(delay, period, run)
    }

    override fun done(): FluentBuilder<*, *> {
        return this
    }

    init {
        loader.ensureLoaded(SchedulerAspect::class.java)
    }
}
