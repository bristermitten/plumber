package me.bristermitten.demoplumberapp;

import com.google.inject.Inject;
import me.bristermitten.plumber.scheduling.ScheduledTask;
import me.bristermitten.plumber.scheduling.Task;
import me.bristermitten.plumber.scheduling.TaskFactory;

@ScheduledTask
public class TestScheduled {


    private Task printTask;

    @Inject
    public TestScheduled(TaskFactory factory) {
        printTask = factory.create()
                .in(5).ticks()
                .every(9).seconds()
                .doing(() -> System.out.println("Done!"))
                .build();

        start();

        System.out.println(printTask);
    }

    public void start() {
        printTask.start();
    }
}
