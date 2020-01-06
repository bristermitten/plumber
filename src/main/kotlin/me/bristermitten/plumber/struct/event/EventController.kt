package me.bristermitten.plumber.struct.event

import org.bukkit.event.Cancellable
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerEvent
import java.util.function.Predicate

/**
 * A wrapper for handling events that provides simple boilerplate handling
 * Currently, only supports [Cancellable] instances of [PlayerEvent]
 * All instances have an [EventPriority] of [EventPriority.NORMAL]
 * For performance reasons, if no handling functionality is defined, the controller is not registered into Bukkit
 *
 * @param <T> the type of the event
</T> */
interface EventController<T> : Listener where T : PlayerEvent, T : Cancellable {
    /**
     * Cancel all instances of the event by calling [Cancellable.setCancelled]
     */
    fun cancelAll()

    /**
     * Cancel any instance of the event if a certain predicate is fulfilled.
     *
     * @param predicate the predicate to determine if the event is cancelled or not
     */
    fun cancelIf(predicate: Predicate<T>)

    /**
     * Ignore all instances of the event. For performance reasons, this is equivalent to calling
     * [EventController.unRegister]
     */
    fun ignoreAll()

    /**
     * Unregister the controller, causing all handling to be undone.
     * This may be called internally for performance reasons
     */
    fun unRegister()
}
