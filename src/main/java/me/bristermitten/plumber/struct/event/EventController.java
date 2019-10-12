package me.bristermitten.plumber.struct.event;

import org.bukkit.event.Cancellable;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEvent;

import java.util.function.Predicate;

/**
 * A wrapper for handling events that provides simple boilerplate handling
 * Currently, only supports {@link Cancellable} instances of {@link PlayerEvent}
 * All instances have an {@link EventPriority} of {@link EventPriority#NORMAL}
 * For performance reasons, if no handling functionality is defined, the controller is not registered into Bukkit
 *
 * @param <T> the type of the event
 */
public interface EventController<T extends PlayerEvent & Cancellable> extends Listener {

    /**
     * Cancel all instances of the event by calling {@link Cancellable#setCancelled(boolean)}
     */
    void cancelAll();

    /**
     * Cancel any instance of the event if a certain predicate is fulfilled.
     *
     * @param predicate the predicate to determine if the event is cancelled or not
     */
    void cancelIf(Predicate<T> predicate);

    /**
     * Ignore all instances of the event. For performance reasons, this is equivalent to calling
     * {@link EventController#unRegister()}
     */
    void ignoreAll();

    /**
     * Unregister the controller, causing all handling to be undone.
     * This may be called internally for performance reasons
     */
    void unRegister();
}
