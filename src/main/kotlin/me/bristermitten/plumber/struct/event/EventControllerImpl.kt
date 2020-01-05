package me.bristermitten.plumber.struct.event

import com.google.inject.Inject
import com.google.inject.assistedinject.Assisted
import me.bristermitten.plumber.PlumberPlugin
import me.bristermitten.plumber.util.Reflection.invokeNoArgsStaticMethod
import org.bukkit.Bukkit
import org.bukkit.event.*
import org.bukkit.event.player.PlayerEvent
import org.bukkit.plugin.EventExecutor
import java.util.function.Consumer
import java.util.function.Predicate

/**
 * Default implementation of [EventController]
 *
 * @param <T> the type of the event being handled */
class EventControllerImpl<T> @Inject constructor(
    private val plugin: PlumberPlugin,
    @Assisted private val clazz: Class<T>
) : EventController<T> where T : PlayerEvent, T : Cancellable {

    private var consumer: Consumer<T>? = null
    private var registered = false

    private fun tryRegister() {
        if (registered) return
        val eventExecutor = EventExecutor { _: Listener, event: Event ->
            handle(event)
        }
        Bukkit.getPluginManager()
            .registerEvent(clazz, this, EventPriority.NORMAL, eventExecutor, plugin)
        registered = true
    }

    private fun handle(event: Event) {
        if (consumer == null) return
        if (!clazz.isAssignableFrom(event.javaClass)) return
        @Suppress("UNCHECKED_CAST")
        consumer!!.accept(event as T)
    }

    override fun unRegister() {
        if (!registered) return
        val handlers = invokeNoArgsStaticMethod(
            clazz,
            "getHandlerList"
        ) as HandlerList?
        handlers?.unregister(this)
        consumer = null
        registered = false
    }

    override fun cancelAll() { //        if (!Cancellable.class.isAssignableFrom(clazz)) {
//            logger.warn("Tried to cancelAll non-cancellable event {}", clazz.getSimpleName());
//            ignoreAll();
//        }
        tryRegister()
        consumer = Consumer { e: T -> e.isCancelled = true }
    }

    override fun cancelIf(predicate: Predicate<T>) {
        tryRegister()
        consumer = Consumer { e: T -> if (predicate.test(e)) e.isCancelled = true }
    }

    override fun ignoreAll() {
        unRegister()
    }

}
