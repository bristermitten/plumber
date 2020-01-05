package me.bristermitten.plumber.struct.player

import com.google.inject.ImplementedBy
import me.bristermitten.plumber.dsl.PlayerActionBuilder
import me.bristermitten.plumber.dsl.TaskLengthConfiguration
import me.bristermitten.plumber.struct.extension.Extendable
import me.bristermitten.plumber.struct.key.KeyHolder
import org.bukkit.entity.Player
import org.bukkit.event.Cancellable
import org.bukkit.event.player.PlayerEvent

/**
 * Plumber wrapper for the [Player] class
 * Allows lots of boilerplate on Players do be done easily
 *
 *
 * Instances can be obtained from [PPlayerManager] if necessary,
 * otherwise it's advised to use events or command injection, rather than storing
 * and manually obtaining instances.
 *
 *
 * Per online player, one [PPlayer] instance exists. As with Bukkit's Player,
 * this will be removed from storage if the player logs out,
 * so it's advised not to store instances if possible, as they will not be able to be
 * garbage collected otherwise. If necessary, [WeakReference] is advised.
 */
@ImplementedBy(PPlayerImpl::class)
interface PPlayer : KeyHolder, Extendable<PPlayer, PlayerExtension> {
    /**
     * @return the underlying [Player] object
     */
    fun player(): Player

    /**
     * Block a certain event class until a given condition is complete (if any)
     *
     * @param e   the class to block
     * @param <T> the type of event
     * @return a [TaskLengthConfiguration] for configuring the blocking
    </T> */
    fun <T> blockEvent(e: Class<T>): TaskLengthConfiguration<PlayerActionBuilder> where T : PlayerEvent, T : Cancellable

    /**
     * Send a message to the player.
     * The String will be colored for Bukkit color codes
     *
     * @param msg the message to send
     */
    fun message(msg: String) //    DistancePicker<CompareRootTimePicker> lastMoved();
//    void kick();
}
