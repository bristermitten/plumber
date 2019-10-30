package me.bristermitten.plumber.struct.event;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import me.bristermitten.plumber.PlumberPlugin;
import me.bristermitten.plumber.util.ReflectionUtil;
import org.bukkit.Bukkit;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.EventPriority;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.plugin.EventExecutor;

import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Default implementation of {@link EventController}
 *
 * @param <T> the type of the event being handled
 */
public class EventControllerImpl<T extends PlayerEvent & Cancellable> implements EventController<T> {

    private final PlumberPlugin plugin;
    private final Class<T> clazz;
    private Consumer<T> consumer;
    private boolean registered;

    @Inject
    public EventControllerImpl(PlumberPlugin plugin, @Assisted Class<T> clazz) {
        this.plugin = plugin;
        this.clazz = clazz;
    }

    private void tryRegister() {
        if (registered) return;
        EventExecutor eventExecutor = (listener, event) -> handle(event);
        Bukkit.getPluginManager().registerEvent(clazz, this, EventPriority.NORMAL, eventExecutor, plugin);
        registered = true;
    }

    private void handle(Event event) {
        if (consumer == null) return;
        if (event == null) return;
        if (!clazz.isAssignableFrom(event.getClass())) return;

        consumer.accept((T) event);
    }


    public void unRegister() {
        if (!registered) return;
        HandlerList handlers = (HandlerList) ReflectionUtil.invokeNoArgsStaticMethod(clazz, "getHandlerList");
        if (handlers != null) {
            handlers.unregister(this);
        }
        consumer = null;
        registered = false;
    }

    @Override
    public void cancelAll() {
//        if (!Cancellable.class.isAssignableFrom(clazz)) {
//            logger.warn("Tried to cancelAll non-cancellable event {}", clazz.getSimpleName());
//            ignoreAll();
//        }
        tryRegister();
        consumer = e -> e.setCancelled(true);
    }

    @Override
    public void cancelIf(Predicate<T> predicate) {
        tryRegister();
        consumer = e -> {
            if (predicate.test(e)) e.setCancelled(true);
        };
    }

    @Override
    public void ignoreAll() {
        unRegister();
    }
}
