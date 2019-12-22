package me.bristermitten.plumber.util

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

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
