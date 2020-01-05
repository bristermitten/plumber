package me.bristermitten.plumber.util

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class ChatTest {

    /**
     * This essentially just tests Bukkit's functionality, doesn't need much detail
     */
    @Test
    fun `Test color()`() {
        assertNull(Chat.color(null))
        assertEquals("§c§lTest", Chat.color("&c&lTest"))
    }
}
