package me.bristermitten.plumber.scheduling.timings;

import me.bristermitten.plumber.scheduling.Task;

/**
 * Builder for configuring times in the future for scheduling
 * This can be safely injected
 */
public interface TaskBuilder {

    /**
     * Default implementation, can be customised to change what Guice uses when creating instances
     */
    Class<? extends TaskBuilder> impl = TaskBuilderImpl.class;

    /**
     * Define a repeating period in which the task is executed
     *
     * @param period the period, where the time unit is then picked
     * @return a {@link TimeUnitPicker} to pick the time unit
     */
    TimeUnitPicker<TaskBuilder> every(long period);

    /**
     * Define an initial delay for the task.
     *
     * @param wait the wait time, where the time unit is then picked
     * @return a {@link TimeUnitPicker} to pick the time unit
     */
    TimeUnitPicker<TaskBuilder> in(long wait);

    /**
     * Set the functionality for this Task
     *
     * @param r the function to run on every execution
     * @return this builder
     */
    TaskBuilder doing(Runnable r);

    /**
     * Create a new Task from this Builder
     *
     * @return a new Task
     * @throws IllegalStateException if {@link TaskBuilder#doing(Runnable)} has not been called
     */
    Task build() throws IllegalStateException;
}
