package me.bristermitten.plumber.object.event;

import com.google.inject.Inject;
import me.bristermitten.plumber.PlumberPlugin;
import org.bukkit.event.Cancellable;
import org.bukkit.event.player.PlayerEvent;

public class EventControllerFactory {
    @Inject
    private PlumberPlugin plugin;

    public <T extends PlayerEvent & Cancellable> EventController<T> createController(Class<T> clazz) {
        return new EventControllerImpl<>(plugin, clazz);
    }
}
