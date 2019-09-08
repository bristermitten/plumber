package me.bristermitten.plumber.scheduling.timings;

import me.bristermitten.plumber.scheduling.Task;
import me.bristermitten.plumber.struct.builder.FluentBuilder;

/**
 * Builder for configuring times in the future for scheduling
 */
public interface TaskBuilder extends FluentBuilder<Task, FluentBuilder> {

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
