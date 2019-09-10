package me.bristermitten.demoplumberapp;

import com.google.inject.Inject;
import me.bristermitten.plumber.scheduling.ScheduledTask;
import me.bristermitten.plumber.scheduling.Task;
import me.bristermitten.plumber.scheduling.TaskBuilderFactory;
import net.minecraft.server.v1_12_R1.MinecraftServer;

@ScheduledTask
public class TestScheduled {


    private Task printTask;

    @Inject
    public TestScheduled(TaskBuilderFactory factory) {
        printTask = factory.create()
                .in(5).ticks()
                .every(200).ticks()
                .doing(() -> System.out.println("Scheduler ran!"))
                .build();
    }

    public void start() {
        printTask.start();
    }
}
