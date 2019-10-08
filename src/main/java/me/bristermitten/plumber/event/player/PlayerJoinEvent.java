package me.bristermitten.plumber.event.player;

import me.bristermitten.plumber.struct.player.PPlayer;
import org.bukkit.entity.Player;

public class PlayerJoinEvent extends org.bukkit.event.player.PlayerJoinEvent {

    private final PPlayer plumberPlayer;

    public PlayerJoinEvent(Player playerJoined, String joinMessage, PPlayer plumberPlayer) {
        super(playerJoined, joinMessage);
        this.plumberPlayer = plumberPlayer;
    }

    public PPlayer player() {
        return plumberPlayer;
    }
}
