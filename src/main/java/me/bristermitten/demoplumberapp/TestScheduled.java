package me.bristermitten.demoplumberapp;

import me.bristermitten.plumber.scheduling.ScheduledTask;
import me.bristermitten.plumber.scheduling.Task;
import me.bristermitten.plumber.scheduling.timings.TimeBuilder;

@ScheduledTask
public class TestScheduled extends Task {

    @Override
    public void run() {

    }

    @Override
    protected void configure(TimeBuilder timeBuilder) {
        timeBuilder.fromNow().in(10).seconds();
    }
}
