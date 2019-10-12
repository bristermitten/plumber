package me.bristermitten.plumber.event.player;

import me.bristermitten.plumber.struct.player.PPlayer;
import org.bukkit.entity.Player;

/**
 * Event that gives Plumber functionality to the default Bukkit event
 */
public class PlayerJoinEvent extends org.bukkit.event.player.PlayerJoinEvent {

    private final PPlayer plumberPlayer;

    public PlayerJoinEvent(Player playerJoined, String joinMessage, PPlayer plumberPlayer) {
        super(playerJoined, joinMessage);
        this.plumberPlayer = plumberPlayer;
    }

    /**
     * @return the Plumber player of the Bukkit player
     */
    public PPlayer player() {
        return plumberPlayer;
    }
}
