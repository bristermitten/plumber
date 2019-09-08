package me.bristermitten.plumber.struct.player;

import me.bristermitten.plumber.struct.DataKey;
import me.bristermitten.plumber.struct.builder.PlayerTaskBuilder;
import me.bristermitten.plumber.struct.builder.TaskLengthConfig;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerEvent;

class PPlayerImpl implements PPlayer{

    private final Player player;

    PPlayerImpl(Player player) {
        this.player = player;
    }

    @Override
    public Player player() {
        return player;
    }

    @Override
    public TaskLengthConfig<PlayerTaskBuilder> blockEvent(Class<? extends PlayerEvent> e) {
        return null;
    }

    @Override
    public <K> void setData(DataKey<K> key, K data) {

    }
}
