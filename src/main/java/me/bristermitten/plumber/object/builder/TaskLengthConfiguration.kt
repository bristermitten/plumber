package me.bristermitten.plumber.`object`.builder

import me.bristermitten.plumber.scheduling.timings.TimeUnitPicker
import me.bristermitten.plumber.`object`.builder.impl.DefaultTaskLengthConfiguration

interface TaskLengthConfiguration<B : ActionBuilder<*>> {

    fun forever()

    fun until(): B

    fun after(time: Long): TimeUnitPicker<B>

    companion object {
        var impl: Class<out TaskLengthConfiguration<*>> = DefaultTaskLengthConfiguration::class.java
    }
}
