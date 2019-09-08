package me.bristermitten.demoplumberapp;

import be.seeseemelk.mockbukkit.MockBukkit;
import me.bristermitten.plumber.PlumberPlugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPluginLoader;
import org.jetbrains.annotations.NotNull;
import org.slf4j.impl.SimpleLogger;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;

public class DemoPlugin extends PlumberPlugin {
    public DemoPlugin() {
    }

    public DemoPlugin(@NotNull JavaPluginLoader loader, @NotNull PluginDescriptionFile description,
                      @NotNull File dataFolder, File file) throws URISyntaxException {
        super(loader, description, dataFolder, file);
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException,
            IllegalAccessException, InterruptedException {
        System.setProperty(SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "TRACE");
        MockBukkit.mock();
        DemoPlugin load = MockBukkit.load(DemoPlugin.class);
        load.loadPlugin();
//        CommandMap commandMap = (CommandMap) Bukkit.getServer().getClass().getDeclaredMethod("getCommandMap")
//                .invoke(Bukkit.getServer());
//
//        commandMap.dispatch(Bukkit.getConsoleSender(), "test");
    }
}
