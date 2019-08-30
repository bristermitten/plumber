package me.bristermitten.plumber.scheduling;

import me.bristermitten.plumber.scheduling.timings.TimeBuilder;

public abstract class Task implements Runnable {
    protected abstract void configure(TimeBuilder timeBuilder);
}
