package me.bristermitten.plumber.struct.event;

import com.google.inject.Inject;
import me.bristermitten.plumber.PlumberPlugin;
import org.bukkit.event.Cancellable;
import org.bukkit.event.player.PlayerEvent;

/**
 * Simple factory class for creating instances of {@link EventController}
 * Can't use Guice because of generics, so currently stuck to {@link EventControllerImpl}
 */
public class EventControllerFactory {

    @Inject
    private PlumberPlugin plugin;

    public <T extends PlayerEvent & Cancellable> EventController<T> createController(Class<T> clazz) {
        return new EventControllerImpl<>(plugin, clazz);
    }
}
