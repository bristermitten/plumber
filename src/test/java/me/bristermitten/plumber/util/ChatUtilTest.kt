package me.bristermitten.plumber.util

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class ChatUtilTest {

    /**
     * This essentially just tests Bukkit's functionality, don't need much detail
     */
    @Test
    fun `Test color()`() {
        assertNull(ChatUtil.color(null))
        assertEquals("§c§lTest", ChatUtil.color("&c&lTest"))
    }
}
