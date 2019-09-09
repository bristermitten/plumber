package me.bristermitten.plumber.scheduling.timings;

import me.bristermitten.plumber.scheduling.Task;

/**
 * Builder for configuring times in the future for scheduling
 */
public interface TaskBuilder {

    Class<? extends TaskBuilder> impl = TaskBuilderImpl.class;

    /**
     * Define a repeating period in which the task is executed
     *
     * @param period
     * @return
     */
    TimeUnitPicker<TaskBuilder> every(long period);

    /**
     * Define an *initial* delay for the task.
     *
     * @param wait
     * @return
     */
    TimeUnitPicker<TaskBuilder> in(long wait);

    TaskBuilder doing(Runnable r);

    Task build();
}
