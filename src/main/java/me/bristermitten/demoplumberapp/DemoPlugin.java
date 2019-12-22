package me.bristermitten.demoplumberapp;

import me.bristermitten.plumber.PlumberPlugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPluginLoader;
import org.jetbrains.annotations.Nullable;

import java.io.File;


//That's it!
public class DemoPlugin extends PlumberPlugin {
    public DemoPlugin(@Nullable JavaPluginLoader loader, @Nullable PluginDescriptionFile description,
                      @Nullable File dataFolder, @Nullable File file) {
        super(loader, description, dataFolder, file);
    }

    public DemoPlugin() {
    }

}

