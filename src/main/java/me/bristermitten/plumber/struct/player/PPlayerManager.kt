package me.bristermitten.plumber.struct.player

import com.google.inject.AbstractModule
import com.google.inject.Inject
import com.google.inject.Singleton
import me.bristermitten.plumber.boot.InjectorHolder
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import java.util.*
import java.util.concurrent.ConcurrentHashMap

/**
 * Singleton for managing implementations of [PPlayer] bound to their underlying [Player]
 *
 * Consumers should prioritise obtaining [PPlayer] instances from commands, events, or other things
 * rather than manually obtaining instances from [PPlayerManager]
 */
@Singleton
class PPlayerManager @Inject constructor(private val holder: InjectorHolder) {
    private val players = ConcurrentHashMap<UUID, PPlayer>()


    /**
     * Create or get an instance of [PPlayer] from a given [UUID]
     * @see [ofPlayer]
     * @return a corresponding instance of [PPlayer], or null if no such player is online
     */
    fun of(p: UUID): PPlayer {
        return ofPlayer(Bukkit.getPlayer(p))
    }

    /**
     * Create or get an instance of [PPlayer] corresponding to the given [Player]
     * @param p The player
     */
    fun ofPlayer(p: Player): PPlayer {
        return players.computeIfAbsent(p.uniqueId) {
            val injector = holder.injector.createChildInjector(object : AbstractModule() {
                override fun configure() {
                    bind(Player::class.java).toInstance(p)
                    bind(p.javaClass).toInstance(p)
                }
            })
            injector.getInstance(PPlayerImpl::class.java)
        }
    }
}
