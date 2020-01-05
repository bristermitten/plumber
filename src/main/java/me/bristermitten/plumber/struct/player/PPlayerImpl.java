package me.bristermitten.plumber.struct.player;

import com.google.inject.Inject;
import me.bristermitten.plumber.dsl.BuilderFactory;
import me.bristermitten.plumber.dsl.PlayerActionBuilder;
import me.bristermitten.plumber.dsl.TaskLengthConfiguration;
import me.bristermitten.plumber.struct.event.EventController;
import me.bristermitten.plumber.struct.event.EventControllerFactory;
import me.bristermitten.plumber.struct.extension.ExtensionMap;
import me.bristermitten.plumber.struct.key.DataKey;
import me.bristermitten.plumber.struct.key.KeyHolder;
import me.bristermitten.plumber.struct.key.KeyMap;
import me.bristermitten.plumber.util.Chat;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.player.PlayerEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * Default implementation for {@link PPlayer}
 * <p>
 * TODO: Replace implementation of {@link KeyHolder} by extending something like "KeyHolderImpl"?
 */
class PPlayerImpl implements PPlayer {

    /**
     * Storage of Data Key values
     */
    private final KeyMap keyValues = new KeyMap();
    /**
     * The underlying Player
     */
    private final Player player;

    private final ExtensionMap extensions;

    private final BuilderFactory factory;

    private final EventControllerFactory ecFactory;

    @Inject
    PPlayerImpl(Player player, ExtensionMap extensionMap, BuilderFactory factory, EventControllerFactory ecFactory) {
        this.player = player;
        this.extensions = extensionMap;
        this.factory = factory;
        this.ecFactory = ecFactory;
        extensions.init(this);
    }

    @Override
    public Player player() {
        return player;
    }

    @Override
    public <T extends PlayerEvent & Cancellable> TaskLengthConfiguration<PlayerActionBuilder> blockEvent(Class<T> e) {
        EventController<T> controller = ecFactory.createController(e);
        controller.cancelAll();
        PlayerActionBuilder actionBuilder = factory.createPlayerActionBuilder(this, controller::ignoreAll);
        return factory.createPlayerTaskLengthConfiguration(actionBuilder);
    }

    @Override
    public void message(String msg) {
        player.sendMessage(Chat.color(msg));
    }

//    public DistancePicker<CompareRootTimePicker> lastMoved() {
//        return null;
//    }
//
//    public void kick() {
//        player.kickPlayer("TODO");
//    }

    @Override
    public <K> void setData(DataKey<K> key, K data) {
        key.execHandlers(data);
        keyValues.put(key, data);
    }

    @Override
    public <K> void rawSetData(DataKey<K> key, K data) {
        keyValues.put(key, data);
    }

    @NotNull
    @Override
    public <K> K getData(DataKey<K> key) {
        return getData(key, key.getDefaultValue());
    }

    @NotNull
    @Override
    public <K> K getData(DataKey<K> key, @NotNull K defaultValue) {
        //noinspection unchecked
        return (K) keyValues.getOrDefault(key, defaultValue);
    }

    @NotNull
    @Override
    public PlayerExtension getExtension(@NotNull Class<? extends PlayerExtension> clazz) {
        return (PlayerExtension) extensions.getExtension(clazz);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PPlayerImpl pPlayer = (PPlayerImpl) o;
        return keyValues.equals(pPlayer.keyValues) &&
                player.equals(pPlayer.player) &&
                extensions.equals(pPlayer.extensions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(keyValues, player, extensions);
    }

    @Override
    public String toString() {
        return "PPlayerImpl{" +
                "data=" + keyValues +
                ", player=" + player +
                '}';
    }

}
