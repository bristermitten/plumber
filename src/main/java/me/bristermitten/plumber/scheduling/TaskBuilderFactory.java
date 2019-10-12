package me.bristermitten.plumber.scheduling;

import me.bristermitten.plumber.scheduling.timings.TaskBuilder;

/**
 * Guice Assisted Injection factory for creating instances of {@link TaskBuilder}
 * <p>
 * Use is subject to change, and may be replaced by a different pattern
 */
public interface TaskBuilderFactory {

    TaskBuilder create();
}
