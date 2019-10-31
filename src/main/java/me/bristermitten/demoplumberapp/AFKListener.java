package me.bristermitten.demoplumberapp;

import com.google.inject.Inject;
import me.bristermitten.plumber.PlumberServer;
import me.bristermitten.plumber.aspect.components.Component;
import me.bristermitten.plumber.scheduling.Task;
import me.bristermitten.plumber.scheduling.timings.TaskBuilder;

@Component
public class AFKListener {

    @Inject
    private PlumberServer server;

    private Task task;

    public Task task() {
        return task;
    }

    @Inject
    public AFKListener(TaskBuilder builder) {
        task = builder
                .every(30).seconds()
                .doing(this::handle)
                .build();
        task.start();
    }

    public void handle() {
//        for (PPlayer player : server.players()) {
//            if (player.lastMoved().moreThan(30).seconds().ago()) {
//                player.kick("Kicked for AFK.");
//            }
//        }
    }
}
