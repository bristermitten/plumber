package me.bristermitten.plumber.struct.builder

import me.bristermitten.plumber.scheduling.timings.TimeUnitPicker
import me.bristermitten.plumber.struct.builder.impl.DefaultTaskLengthConfiguration

interface TaskLengthConfiguration<B : ActionBuilder<*>> {

    fun forever()

    fun until(): B

    fun undoAfter(time: Long): TimeUnitPicker<B>

    companion object {
        var impl: Class<out TaskLengthConfiguration<*>> = DefaultTaskLengthConfiguration::class.java
    }
}
