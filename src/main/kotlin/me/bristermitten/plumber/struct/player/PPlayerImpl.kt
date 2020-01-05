package me.bristermitten.plumber.struct.player

import com.google.inject.Inject
import me.bristermitten.plumber.dsl.BuilderFactory
import me.bristermitten.plumber.dsl.PlayerActionBuilder
import me.bristermitten.plumber.dsl.TaskLengthConfiguration
import me.bristermitten.plumber.struct.event.EventController
import me.bristermitten.plumber.struct.event.EventControllerFactory
import me.bristermitten.plumber.struct.extension.ExtensionMap
import me.bristermitten.plumber.struct.key.DataKey
import me.bristermitten.plumber.struct.key.KeyHolder
import me.bristermitten.plumber.struct.key.KeyMap
import me.bristermitten.plumber.util.Chat
import org.bukkit.entity.Player
import org.bukkit.event.Cancellable
import org.bukkit.event.player.PlayerEvent
import java.util.*

/**
 * Default implementation for [PPlayer]
 *
 *
 * TODO: Replace implementation of [KeyHolder] by extending something like "KeyHolderImpl"?
 */
internal class PPlayerImpl @Inject constructor(
    /**
     * The underlying Player
     */
    private val player: Player,
    private val extensions: ExtensionMap,
    private val factory: BuilderFactory,
    private val ecFactory: EventControllerFactory
) : PPlayer {
    /**
     * Storage of Data Key values
     */
    private val keyValues = KeyMap()

    override fun player(): Player {
        return player
    }

    override fun <T> blockEvent(e: Class<T>): TaskLengthConfiguration<PlayerActionBuilder> where T : PlayerEvent, T : Cancellable {
        val controller: EventController<T> = ecFactory.createController(e)
        controller.cancelAll()
        val actionBuilder =
            factory.createPlayerActionBuilder(this, Runnable { controller.ignoreAll() })
        return factory.createPlayerTaskLengthConfiguration(actionBuilder)
    }

    override fun message(msg: String) {
        player.sendMessage(Chat.color(msg))
    }

    //    public DistancePicker<CompareRootTimePicker> lastMoved() {
//        return null;
//    }
//
//    public void kick() {
//        player.kickPlayer("TODO");
//    }
    override fun <K: Any> setData(key: DataKey<K>, data: K) {
        key.execHandlers(data)
        keyValues[key] = data
    }

    override fun <K: Any> rawSetData(key: DataKey<K>, data: K) {
        keyValues[key] = data
    }

    override fun <K: Any> getData(key: DataKey<K>): K {
        return getData(key, key.defaultValue)
    }

    override fun <K: Any> getData(key: DataKey<K>, defaultValue: K): K {
        @Suppress("UNCHECKED_CAST")
        return keyValues.getOrDefault(key, defaultValue) as K
    }

    override fun getExtension(clazz: Class<out PlayerExtension>): PlayerExtension {
        return extensions.getExtension(clazz) as PlayerExtension
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val pPlayer = other as PPlayerImpl
        return keyValues == pPlayer.keyValues && player == pPlayer.player && extensions == pPlayer.extensions
    }

    override fun hashCode(): Int {
        return Objects.hash(keyValues, player, extensions)
    }

    override fun toString(): String {
        return "PPlayerImpl{" +
                "data=" + keyValues +
                ", player=" + player +
                '}'
    }

    init {
        extensions.init(this)
    }
}
