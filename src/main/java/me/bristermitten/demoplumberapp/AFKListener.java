package me.bristermitten.demoplumberapp;

import com.google.inject.Inject;
import me.bristermitten.plumber.PlumberServer;
import me.bristermitten.plumber.aspect.components.Component;
import me.bristermitten.plumber.scheduling.TaskBuilderFactory;

@Component
public class AFKListener {

    @Inject
    private PlumberServer server;

    @Inject
    public AFKListener(TaskBuilderFactory factory) {
        factory.create()
                .every(200).ticks()
                .doing(this::handle)
                .build().start();
    }

    public void handle() {
//        for (PPlayer player : server.players()) {
//            if (player.lastMoved().moreThan(30).seconds().ago()) {
//                player.kick();
//            }
//        }
    }
}
