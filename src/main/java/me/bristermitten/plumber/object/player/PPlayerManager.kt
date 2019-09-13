package me.bristermitten.plumber.`object`.player

import com.google.inject.Inject
import com.google.inject.Injector
import com.google.inject.Singleton
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import java.util.*
import java.util.concurrent.ConcurrentHashMap

@Singleton
class PPlayerManager {
    private val players = ConcurrentHashMap<UUID, PPlayer>()

    @Inject
    private lateinit var injector: Injector

    //todo use Guice to inject an impl to allow customisation
    fun of(p: UUID): PPlayer {
        return of(Bukkit.getPlayer(p))
    }

    fun of(p: Player): PPlayer {
        return players.computeIfAbsent(p.uniqueId) {
            val pp = PPlayerImpl(p)
            injector.injectMembers(pp)
            pp
        }
    }
}
