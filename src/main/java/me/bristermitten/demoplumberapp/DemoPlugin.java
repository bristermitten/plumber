package me.bristermitten.demoplumberapp;

import be.seeseemelk.mockbukkit.MockBukkit;
import me.bristermitten.plumber.PlumberPlugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPluginLoader;
import org.jetbrains.annotations.NotNull;
import org.slf4j.impl.SimpleLogger;

import java.io.File;

public class DemoPlugin extends PlumberPlugin {
    public DemoPlugin() {
    }

    public DemoPlugin(@NotNull JavaPluginLoader loader, @NotNull PluginDescriptionFile description,
                      @NotNull File dataFolder, File file) {
        super(loader, description, dataFolder, file);
    }

    @Override
    public void onEnable() {
        System.setProperty(SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "TRACE");
        loadPlugin();
    }

    public static void main(String[] args) {
        MockBukkit.mock();
        DemoPlugin load = MockBukkit.load(DemoPlugin.class);
//        CommandMap commandMap = (CommandMap) Bukkit.getServer().getClass().getDeclaredMethod("getCommandMap")
//                .invoke(Bukkit.getServer());
//
//        commandMap.dispatch(Bukkit.getConsoleSender(), "test");
    }
}
