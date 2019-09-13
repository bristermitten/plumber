package me.bristermitten.plumber.object.player;

import com.google.inject.Inject;
import me.bristermitten.plumber.object.DataKey;
import me.bristermitten.plumber.object.builder.BuilderFactory;
import me.bristermitten.plumber.object.builder.PlayerActionBuilder;
import me.bristermitten.plumber.object.builder.TaskLengthConfiguration;
import me.bristermitten.plumber.object.event.EventController;
import me.bristermitten.plumber.object.event.EventControllerFactory;
import me.bristermitten.plumber.util.ChatUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.player.PlayerEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PPlayerImpl implements PPlayer {

    private final Map<DataKey<?>, Object> keyValues = new HashMap<>();
    private final Player player;
    private final List<EventController<?>> controllers = new ArrayList<>();

    @Inject
    private BuilderFactory factory;

    @Inject
    private EventControllerFactory ecFactory;

    PPlayerImpl(Player player) {
        this.player = player;
    }

    @Override
    public Player player() {
        return player;
    }

    @Override
    public <T extends PlayerEvent & Cancellable> TaskLengthConfiguration<PlayerActionBuilder> blockEvent(Class<T> e) {
        EventController<?> controller = ecFactory.createController(e);
        controllers.add(controller);
        return factory.createPlayerConfiguration(factory.createPlayerActionBuilder(this));
    }

    @Override
    public void message(String msg) {
        player.sendMessage(ChatUtil.color(msg));
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
