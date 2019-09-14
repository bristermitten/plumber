package me.bristermitten.demoplumberapp;

import me.bristermitten.plumber.PlumberPlugin;
import org.slf4j.impl.SimpleLogger;

public class DemoPlugin extends PlumberPlugin {

    @Override
    public void onEnable() {
        System.setProperty(SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "TRACE");
        loadPlugin();

//        getInstance(TestScheduled.class).start();
    }

//    public static void main(String[] args) {
//        MockBukkit.mock();
//        MockBukkit.load(DemoPlugin.class);
//    }
}
