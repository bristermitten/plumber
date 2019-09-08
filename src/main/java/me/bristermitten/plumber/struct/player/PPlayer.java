package me.bristermitten.plumber.struct.player;

import me.bristermitten.plumber.struct.DataKey;
import me.bristermitten.plumber.struct.builder.PlayerTaskBuilder;
import me.bristermitten.plumber.struct.builder.TaskLengthConfig;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.player.PlayerEvent;

public interface PPlayer {
    Player player();

    TaskLengthConfig<PlayerTaskBuilder> blockEvent(Class<? extends PlayerEvent> e);

    <K> void setData(DataKey<K> key, K data);
}
