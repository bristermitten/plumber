package me.bristermitten.plumber.struct.player

import com.google.inject.Singleton
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import java.util.*
import java.util.concurrent.ConcurrentHashMap

@Singleton
class PPlayerManager {
    private val players = ConcurrentHashMap<UUID, PPlayer>()

    //todo use Guice to inject an impl to allow customisation
    fun of(p: UUID): PPlayer {
        return of(Bukkit.getPlayer(p))
    }

    fun of(p: Player): PPlayer {
        return players.computeIfAbsent(p.uniqueId) { PPlayerImpl(p) }
    }
}
