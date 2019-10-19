package me.bristermitten.plumber.struct.player

import com.google.inject.AbstractModule
import com.google.inject.Inject
import com.google.inject.Injector
import com.google.inject.Singleton
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import java.util.*
import java.util.concurrent.ConcurrentHashMap

/**
 * Singleton for storing implementations of [PPlayer] bound to their underlying [Player]
 * Should always be kept a singleton.
 * Consumers should prioritise obtaining [PPlayer] instances from commands, events, or other things
 * rather than manually obtaining instances from [PPlayerManager]
 */
@Singleton
class PPlayerManager @Inject constructor(private val injector: Injector) {
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
        val injector = injector.createChildInjector(object : AbstractModule() {
            override fun configure() {
                bind(Player::class.java).toInstance(p)
                bind(p.javaClass).toInstance(p)
            }
        })
        return players.computeIfAbsent(p.uniqueId) {
            injector.getInstance(PPlayerImpl::class.java)
        }
    }
}
