package me.bristermitten.plumber.struct.player;

import me.bristermitten.plumber.struct.DataKey;
import me.bristermitten.plumber.struct.builder.PlayerActionBuilder;
import me.bristermitten.plumber.struct.builder.TaskLengthConfiguration;
import me.bristermitten.plumber.struct.entity.KeyStorer;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerEvent;

public interface PPlayer extends KeyStorer {
    Player player();

    TaskLengthConfiguration<PlayerActionBuilder> blockEvent(Class<? extends PlayerEvent> e);


}
