package me.bristermitten.plumber.event.player

import me.bristermitten.plumber.struct.player.PPlayer
import org.bukkit.entity.Player
import org.bukkit.event.player.PlayerJoinEvent as BukkitPlayerJoinEvent

/**
 * Event that gives Plumber functionality to the default Bukkit event
 */
class PlayerJoinEvent(playerJoined: Player, joinMessage: String, private val plumberPlayer: PPlayer) : BukkitPlayerJoinEvent(playerJoined, joinMessage) {

    /**
     * @return the Plumber player of the Bukkit player
     */
    fun player(): PPlayer {
        return plumberPlayer
    }
}
