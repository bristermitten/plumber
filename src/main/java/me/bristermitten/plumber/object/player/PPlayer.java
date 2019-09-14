package me.bristermitten.plumber.object.player;

import me.bristermitten.plumber.object.builder.PlayerActionBuilder;
import me.bristermitten.plumber.object.builder.TaskLengthConfiguration;
import me.bristermitten.plumber.object.key.KeyHolder;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.player.PlayerEvent;

public interface PPlayer extends KeyHolder {
    Player player();

    <T extends PlayerEvent & Cancellable> TaskLengthConfiguration<PlayerActionBuilder> blockEvent(Class<T> e);

    void message(String msg);
}
