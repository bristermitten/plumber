package me.bristermitten.plumber.struct.player;

import me.bristermitten.plumber.dsl.PlayerActionBuilder;
import me.bristermitten.plumber.dsl.TaskLengthConfiguration;
import me.bristermitten.plumber.struct.extension.Extendable;
import me.bristermitten.plumber.struct.key.KeyHolder;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.player.PlayerEvent;

import java.lang.ref.WeakReference;

/**
 * Plumber wrapper for the {@link Player} class
 * Allows lots of boilerplate on Players do be done easily
 * <p>
 * Instances can be obtained from {@link PPlayerManager} if necessary,
 * otherwise it's advised to use events or command injection, rather than storing
 * and manually obtaining instances.
 * <p>
 * Per online player, one {@link PPlayer} instance exists. As with Bukkit's Player,
 * this will be removed from storage if the player logs out,
 * so it's advised not to store instances if possible, as they will not be able to be
 * garbage collected otherwise. If necessary, {@link WeakReference} is advised.
 */
public interface PPlayer extends KeyHolder, Extendable<PPlayer> {
    /**
     * @return the underlying {@link Player} object
     */
    Player player();

    /**
     * Block a certain event class until a given condition is complete (if any)
     *
     * @param e   the class to block
     * @param <T> the type of event
     * @return a {@link TaskLengthConfiguration} for configuring the blocking
     */
    <T extends PlayerEvent & Cancellable> TaskLengthConfiguration<PlayerActionBuilder> blockEvent(Class<T> e);

    /**
     * Send a message to the player.
     * The String will be colored for Bukkit color codes
     *
     * @param msg the message to send
     */
    void message(String msg);

//    DistancePicker<CompareRootTimePicker> lastMoved();

//    void kick();
}
