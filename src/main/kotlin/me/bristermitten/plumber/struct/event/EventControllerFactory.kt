package me.bristermitten.plumber.struct.event

import com.google.inject.Inject
import me.bristermitten.plumber.PlumberPlugin
import org.bukkit.event.Cancellable
import org.bukkit.event.player.PlayerEvent

/**
 * Simple factory class for creating instances of [EventController]
 * Can't use Guice because of generics, so currently stuck to [EventControllerImpl]
 */
class EventControllerFactory  @Inject constructor(private val plugin: PlumberPlugin) {

    fun <T> createController(clazz: Class<T>): EventController<T> where T : PlayerEvent, T : Cancellable {
        return EventControllerImpl(plugin, clazz)
    }
}
