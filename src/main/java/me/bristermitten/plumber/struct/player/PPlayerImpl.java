package me.bristermitten.plumber.struct.player;

import com.google.inject.Inject;
import me.bristermitten.plumber.struct.DataKey;
import me.bristermitten.plumber.struct.builder.BuilderFactory;
import me.bristermitten.plumber.struct.builder.PlayerActionBuilder;
import me.bristermitten.plumber.struct.builder.TaskLengthConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerEvent;

import java.util.HashMap;
import java.util.Map;

class PPlayerImpl implements PPlayer {

    private final Map<DataKey, Object> keyValues = new HashMap<>();
    private final Player player;

    @Inject
    private BuilderFactory factory;

    PPlayerImpl(Player player) {
        this.player = player;
    }

    @Override
    public Player player() {
        return player;
    }

    @Override
    public TaskLengthConfiguration<PlayerActionBuilder> blockEvent(Class<? extends PlayerEvent> e) {
        return factory.createPlayerConfiguration(factory.createPlayerActionBuilder(this));
    }


    @Override
    public <K> void setData(DataKey<K> key, K data) {
        keyValues.put(key, data);
    }

    @Override
    public <K> K getData(DataKey<K> key) {
        return (K) keyValues.getOrDefault(key, key.getDefaultValue());
    }
}
