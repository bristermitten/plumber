package me.bristermitten.plumber.struct.event;

import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEvent;

import java.util.function.Predicate;

public interface EventController<T extends PlayerEvent> extends Listener {

    void cancelAll();

    void cancelIf(Predicate<T> predicate);

    void ignoreAll();

    void unRegister();
}
