package me.bristermitten.plumber.scheduling;

import me.bristermitten.plumber.scheduling.timings.FutureTime;
import me.bristermitten.plumber.scheduling.timings.TimeBuilder;

import java.util.function.Supplier;

public abstract class Task implements Runnable {

    private final Supplier<FutureTime> nextTime;

    protected Task(TimeBuilder builder) {
        this.nextTime = () -> builder.fromNow().get();
    }
}
