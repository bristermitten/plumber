package me.bristermitten.demoplumberapp;

import com.google.inject.Inject;
import me.bristermitten.plumber.scheduling.ScheduledTask;
import me.bristermitten.plumber.scheduling.Task;
import me.bristermitten.plumber.scheduling.timings.TaskBuilder;

@ScheduledTask
public class TestScheduled {


    private Task printTask;

    @Inject
    public TestScheduled(TaskBuilder builder) {
        printTask = builder
                .in(5).ticks()
                .every(200).ticks()
                .doing(() -> System.out.println("Scheduler ran!"))
                .build();
        printTask.start();
    }

    public Task printTask() {
        return printTask;
    }

}
