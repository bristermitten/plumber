package me.bristermitten.plumber.scheduling;

import com.google.inject.assistedinject.Assisted;
import me.bristermitten.plumber.scheduling.timings.Time;

/**
 * Guice Assisted Injection factory for creating instances of {@link Task}
 */
public interface TaskFactory {
    Task create(@Assisted("delay") long delay, @Assisted("period") long period, Runnable run);

    Task create(@Assisted("delay") Time delay, @Assisted("period") Time period, Runnable run);
}
