@file:Suppress("UNCHECKED_CAST")

package me.bristermitten.plumber.struct.builder.impl

import com.google.inject.Inject
import com.google.inject.assistedinject.Assisted
import me.bristermitten.plumber.scheduling.timings.Time
import me.bristermitten.plumber.scheduling.timings.TimeUnitPicker
import me.bristermitten.plumber.scheduling.timings.TimeUnitPickerFactory
import me.bristermitten.plumber.struct.builder.ActionBuilder
import me.bristermitten.plumber.struct.builder.TaskLengthConfiguration

internal open class DefaultTaskLengthConfiguration<B : ActionBuilder<*>>
@Inject constructor(
        @Assisted private val value: B,
        private val factory: TimeUnitPickerFactory
) : TaskLengthConfiguration<B> {


    private val length: Time = Time()

    override fun forever() {
        length.length = -1
    }

    override fun until(): B {
        return value
    }

    override fun after(time: Long): TimeUnitPicker<B> {
        length.length = time
        return factory.pick(value, { length.unit = it })
    }
}
