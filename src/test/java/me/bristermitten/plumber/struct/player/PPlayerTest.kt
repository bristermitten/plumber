package me.bristermitten.plumber.struct.player

import be.seeseemelk.mockbukkit.MockBukkit
import be.seeseemelk.mockbukkit.entity.PlayerMock
import com.google.inject.Inject
import me.bristermitten.plumber.PlumberTest
import me.bristermitten.plumber.struct.extension.Extension
import org.bukkit.Bukkit
import org.bukkit.event.player.AsyncPlayerChatEvent
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class PPlayerTest : PlumberTest() {


    private lateinit var player: PlayerMock

    private lateinit var playerManager: PPlayerManager
    @Before
    override fun setUp() {
        super.setUp()
        player = MockBukkit.getMock().addPlayer()
        playerManager=plugin.getInstance(PPlayerManager::class.java)
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
        assertEquals("Message was incorrectly coloured", "§c§lTest", this.player.nextMessage())
    }


    data class TestExtension @Inject constructor(val player: PPlayer) : Extension<PPlayer>
}

