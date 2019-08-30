package me.bristermitten.plumber.injection;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import me.bristermitten.plumber.PlumberPlugin;
import me.bristermitten.plumber.aspect.Aspect;
import org.reflections.Reflections;

import java.util.Set;

public class PlumberPluginModule extends AbstractModule {

    private final PlumberPlugin plugin;
    private final Reflections reflections;

    private final Set<Class<? extends Aspect>> aspects;

    public PlumberPluginModule(PlumberPlugin plugin, Reflections reflections, Set<Class<? extends Aspect>> aspects) {
        this.plugin = plugin;
        this.reflections = reflections;
        this.aspects = aspects;
    }

    public Injector createInjector() {
        return Guice.createInjector(this);
    }

    @Override
    protected void configure() {
        bind(PlumberPlugin.class).toInstance(plugin);
        bind(Reflections.class).toInstance(reflections);
        for (Class<? extends Aspect> aspect : aspects) {
            bind(aspect);
        }
    }
}
