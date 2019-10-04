package me.bristermitten.demoplumberapp;

import be.seeseemelk.mockbukkit.MockBukkit;
import com.google.inject.Inject;
import me.bristermitten.plumber.PlumberPlugin;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPluginLoader;
import org.slf4j.impl.SimpleLogger;

import java.io.File;

public class DemoPlugin extends PlumberPlugin {

    public DemoPlugin() {
    }

    public DemoPlugin(JavaPluginLoader loader, PluginDescriptionFile description, File dataFolder, File file) {
        super(loader, description, dataFolder, file);
    }

    public static void main(String[] args) {
        MockBukkit.mock();
        MockBukkit.load(DemoPlugin.class);
    }

    private @Inject TestConfig config;
    @Override
    public void onEnable() {
        System.setProperty(SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "TRACE");
        loadPlumber();

        System.out.println(ReflectionToStringBuilder.toString(config));
//        getInstance(TestScheduled.class).start();
    }
}
