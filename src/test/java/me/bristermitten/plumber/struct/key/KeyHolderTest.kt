package me.bristermitten.plumber.struct.key

import be.seeseemelk.mockbukkit.MockBukkit
import be.seeseemelk.mockbukkit.entity.PlayerMock
import me.bristermitten.plumber.PlumberTest
import me.bristermitten.plumber.struct.player.PPlayerManager
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import java.util.function.Consumer

class KeyHolderTest : PlumberTest() {
    private lateinit var player: PlayerMock

    private lateinit var playerManager: PPlayerManager
    private val key: DataKey<Int> = DataKey(0)

    @Before
    override fun setUp() {
        super.setUp()
        player = MockBukkit.getMock().addPlayer()
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
