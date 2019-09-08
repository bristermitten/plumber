package me.bristermitten.plumber.injection;

import com.google.inject.Module;
import me.bristermitten.plumber.aspect.Aspect;

import java.util.Set;

public class AspectPlumberModule extends PlumberModule {


    private final Set<Aspect> aspects;
    private Module parent;

    public AspectPlumberModule(Module parent, Set<Aspect> aspects) {
        this.parent = parent;
        this.aspects = aspects;
    }


    @Override
    protected void configure() {
        install(parent);
        for (Aspect aspect : aspects) {
            Module module = aspect.getModule();
            if (module != null)
                install(module);

        }
    }
}
