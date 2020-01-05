package me.bristermitten.plumber.struct.key

import be.seeseemelk.mockbukkit.MockBukkit
import be.seeseemelk.mockbukkit.entity.PlayerMock
import me.bristermitten.plumber.PlumberExtension
import me.bristermitten.plumber.struct.player.PPlayerManager
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import java.util.function.Consumer

@ExtendWith(PlumberExtension::class)
class KeyHolderTests {
    private lateinit var player: PlayerMock

    private lateinit var playerManager: PPlayerManager

    private val key: DataKey<Int> = DataKey(0)

    @BeforeEach
    fun setUp() {
        player = MockBukkit.getMock().addPlayer()
        val plugin = PlumberExtension.plugin
        playerManager = plugin.getInstance(PPlayerManager::class.java)
    }

    @Test
    fun setData() {
        val player = playerManager.ofPlayer(player)
        var changed = false
        key.handlers.add(Consumer { changed = true })
        player.setData(key, 3)
        assertEquals(3, player.getData(key))
        assertTrue(changed)
    }

    @Test
    fun rawSetData() {
        val player = playerManager.ofPlayer(player)
        var changed = false
        key.handlers.add(Consumer { changed = true })
        player.rawSetData(key, 3)
        assertEquals(3, player.getData(key))
        assertFalse(changed)
    }

    @Test
    fun getData() {
        val player = playerManager.ofPlayer(player)
        assertEquals(0, player.getData(key))
        player.setData(key, 3)
        assertEquals(3, player.getData(key))
    }

    @Test
    fun testGetData() {
        val player = playerManager.ofPlayer(player)
        assertEquals(4, player.getData(key, 4))
        player.setData(key, 3)
        assertEquals(3, player.getData(key))
    }
}
