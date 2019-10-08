package me.bristermitten.plumber.util;

import org.bukkit.ChatColor;

public class ChatUtil {

    /**
     * Color a String in accordance with Bukkit's standards for color codes:
     * '&' for human readable,
     * '§' for internals
     *
     * @param s the string to color. if this is null, null will be returned
     * @return the colored string, or null if null is given
     */
    public static String color(String s) {
        if (s == null) return null;
        return ChatColor.translateAlternateColorCodes('&', s);
    }
}
