package me.bristermitten.plumber.struct.player

import be.seeseemelk.mockbukkit.MockBukkit
import be.seeseemelk.mockbukkit.entity.PlayerMock
import com.google.inject.Inject
import me.bristermitten.plumber.PlumberExtension
import me.bristermitten.plumber.TestPlugin
import org.bukkit.Bukkit
import org.bukkit.event.player.AsyncPlayerChatEvent
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(PlumberExtension::class)
class PPlayerTest {


    private lateinit var player: PlayerMock

    private lateinit var playerManager: PPlayerManager

    private lateinit var plugin: TestPlugin

    @BeforeEach
    fun setUp() {
        player = MockBukkit.getMock().addPlayer()
        plugin = PlumberExtension.plugin
        playerManager = plugin.getInstance(PPlayerManager::class.java)
    }


    @Test
    fun `Test PPlayer Correctly Created`() {
        val player = playerManager.ofPlayer(player)
        assertNotNull(player)
    }

    @Test
    fun `Test PPlayer Basic Extension Mapping`() {
        val player = playerManager.ofPlayer(player)
        val mappedType = player.getExtension(TestExtension::class.java)
        assertNotNull(mappedType)
        assertEquals(mappedType, player.getExtension(TestExtension::class.java))
    }

    @Test
    fun `Test PPlayer#player() is equal to player`() {
        val player = playerManager.ofPlayer(player)
        assertEquals(this.player, player.player())
    }

    @Test
    fun blockEvent() {
        val player = playerManager.ofPlayer(player)
        player.blockEvent(AsyncPlayerChatEvent::class.java).forever()
        val event = AsyncPlayerChatEvent(false, this.player, "Test", emptySet())
        Bukkit.getPluginManager().callEvent(event)
        assertTrue(event.isCancelled)
    }

    @Test
    fun message() {
        val player = plugin.getInstance(PPlayerManager::class.java).ofPlayer(player)
        player.message("Test")
        assertEquals("Test", this.player.nextMessage())
        player.message("&c&lTest")
        assertEquals("§c§lTest", this.player.nextMessage(), "Message was incorrectly coloured")
    }


    data class TestExtension @Inject constructor(val player: PPlayer) : PlayerExtension
}

