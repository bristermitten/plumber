package me.bristermitten.plumber.struct.builder

import me.bristermitten.plumber.scheduling.timings.TimeUnitPicker
import me.bristermitten.plumber.struct.builder.impl.DefaultTaskLengthConfiguration

/**
 * Interface for deciding how long as task should take
 * @param B the child interface for later configuration
 */
interface TaskLengthConfiguration<B : ActionBuilder<*>> {

    /**
     * Do the task forever
     */
    fun forever()

    /**
     * Do the task until certain conditions are met, at which point it will be cancelled/undone depending on the task
     * @return the child interface to configure the conditions
     */
    fun until(): B

    /**
     * Undo the task (if applicable) after a certain length of time
     * @param time the length of time in arbitrary units
     * @return a [TimeUnitPicker] to configure the length of time
     */
    fun undoAfter(time: Long): TimeUnitPicker<B>

    companion object {
        var impl: Class<out TaskLengthConfiguration<*>> = DefaultTaskLengthConfiguration::class.java
    }
}
