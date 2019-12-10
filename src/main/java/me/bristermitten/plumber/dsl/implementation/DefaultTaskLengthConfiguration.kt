@file:Suppress("UNCHECKED_CAST")

package me.bristermitten.plumber.dsl.implementation

import com.google.inject.Inject
import com.google.inject.assistedinject.Assisted
import me.bristermitten.plumber.dsl.ActionBuilder
import me.bristermitten.plumber.dsl.TaskLengthConfiguration
import me.bristermitten.plumber.scheduling.TaskFactory
import me.bristermitten.plumber.scheduling.timings.Time
import me.bristermitten.plumber.scheduling.timings.TimeUnitPicker
import me.bristermitten.plumber.scheduling.timings.TimeUnitPickerFactory

open class DefaultTaskLengthConfiguration<B : ActionBuilder<B>>

@Inject constructor(
        @Assisted private val value: B,
        private val factory: TimeUnitPickerFactory,
        private val taskFactory: TaskFactory
) : TaskLengthConfiguration<B> {

    override fun forever() {
    }

    override fun until(): B {
        return value
    }

    override fun undoAfter(time: Long): TimeUnitPicker<B> {
        val length = Time()
        length.length = time
        return factory.pick(value, {
            length.unit = it
            taskFactory.create(length, Time.NONE, value).start()
        })
    }
}
