package me.bristermitten.plumber

import be.seeseemelk.mockbukkit.MockBukkit
import com.google.inject.Inject
import me.bristermitten.demoplumberapp.DemoPlugin
import me.bristermitten.plumber.struct.player.PPlayer
import me.bristermitten.plumber.struct.player.PPlayerManager
import org.bukkit.entity.Player
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import me.bristermitten.plumber.struct.extension.Extension as PlumberExtension


class PlayerTests {

    private lateinit var player: Player
    private lateinit var plugin: DemoPlugin

    @Before
    fun load() {
        MockBukkit.mock()
        plugin = MockBukkit.load(DemoPlugin::class.java)
        player = MockBukkit.getMock().addPlayer()
    }

    @Test
    fun `Test PPlayer Correctly Created`() {
        val player = plugin.injector.getInstance(PPlayerManager::class.java).ofPlayer(player)
        val mappedType = player.getExtension(Extension::class.java)
        println(mappedType)
        assertEquals(mappedType, player.getExtension(Extension::class.java))
    }

    data class Extension @Inject constructor(val player: PPlayer) : PlumberExtension<PPlayer> {
        init {
            println(player)
        }
    }
}
