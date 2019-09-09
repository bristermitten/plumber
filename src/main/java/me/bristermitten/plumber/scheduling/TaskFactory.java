package me.bristermitten.plumber.scheduling;

import com.google.inject.assistedinject.Assisted;
import me.bristermitten.plumber.scheduling.Task;

public interface TaskFactory {
    Task create(@Assisted("delay") long delay, @Assisted("period") long period, Runnable run);
}
