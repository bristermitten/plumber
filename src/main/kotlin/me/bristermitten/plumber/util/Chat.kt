package me.bristermitten.plumber.util

import org.bukkit.ChatColor

object Chat {
    /**
     * Color a String in accordance with Bukkit's standards for color codes:
     * &amp; for human readable,
     * § for internals
     *
     * @param s the string to color. if this is null, null will be returned
     * @return the colored string, or null if null is given
     */
    fun color(s: String?): String? {
        return if (s == null) null else ChatColor.translateAlternateColorCodes('&', s)
    }
}
