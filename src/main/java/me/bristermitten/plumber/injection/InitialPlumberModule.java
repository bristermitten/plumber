package me.bristermitten.plumber.injection;

import me.bristermitten.plumber.PlumberPlugin;
import me.bristermitten.plumber.aspect.Aspect;
import me.bristermitten.plumber.aspect.AspectLoader;
import org.reflections.Reflections;

import java.util.Set;

public class InitialPlumberModule extends PlumberModule {

    private final PlumberPlugin plugin;
    private final Reflections reflections;
    private final Set<Class<? extends Aspect>> aspects;
    private AspectLoader loader;

    public InitialPlumberModule(PlumberPlugin plugin, Reflections reflections,
                                AspectLoader loader, Set<Class<? extends Aspect>> aspects) {
        this.plugin = plugin;
        this.reflections = reflections;
        this.loader = loader;
        this.aspects = aspects;
    }


    @Override
    protected void configure() {
        bind(PlumberPlugin.class).toInstance(plugin);
        bind(Reflections.class).toInstance(reflections);
        bind(AspectLoader.class).toInstance(loader);
        aspects.forEach(this::bind);
    }
}
