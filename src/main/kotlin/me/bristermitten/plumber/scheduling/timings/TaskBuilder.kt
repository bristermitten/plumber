package me.bristermitten.plumber.scheduling.timings

import me.bristermitten.plumber.scheduling.Task

/**
 * Builder for configuring times in the future for scheduling
 * This can be safely injected
 */
interface TaskBuilder {
    /**
     * Define a repeating period in which the task is executed
     *
     * @param period the period, where the time unit is then picked
     * @return a [TimeUnitPicker] to pick the time unit
     */
    fun every(period: Long): TimeUnitPicker<TaskBuilder>

    /**
     * Define an initial delay for the task.
     *
     * @param wait the wait time, where the time unit is then picked
     * @return a [TimeUnitPicker] to pick the time unit
     */
    fun `in`(wait: Long): TimeUnitPicker<TaskBuilder>

    /**
     * Set the functionality for this Task
     *
     * @param r the function to run on every execution
     * @return this builder
     */
    fun doing(r: Runnable): TaskBuilder

    /**
     * Create a new Task from this Builder
     *
     * @return a new Task
     * @throws IllegalStateException if [TaskBuilder.doing] has not been called
     */
    @Throws(IllegalStateException::class)
    fun build(): Task

    companion object {
        /**
         * Default implementation, can be customised to change what Guice uses when creating instances
         */
        val impl: Class<out TaskBuilder> = TaskBuilderImpl::class.java
    }
}
