package me.bristermitten.plumber.scheduling;

import me.bristermitten.plumber.scheduling.timings.TaskBuilder;
public interface TaskBuilderFactory {

    TaskBuilder create();
}
