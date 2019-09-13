package me.bristermitten.plumber.util;

import org.bukkit.ChatColor;

public class ChatUtil {
    public static String color(String s) {
        if (s == null) return null;
        return ChatColor.translateAlternateColorCodes('&', s);
    }
}
