package me.bristermitten.plumber.aspectold;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;
import me.bristermitten.plumber.newaspect.Aspect;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

public abstract class AbstractAspect implements Aspect {
    protected Logger logger;

    private boolean enabled;
    @Inject
    private Injector injector;

    protected AbstractAspect() {
        logger = LoggerFactory.getLogger(getClass());
    }


    @Override
    public void enable() {
        logger.info("Enabling aspect " + getClass().getSimpleName());
        doEnable();
        enabled = true;
        logger.info("Done");
    }

    @Override
    public void disable() {
        logger.info("Disabling aspect " + getClass().getSimpleName());
        doDisable();
        enabled = false;
        logger.info("Done");
    }

    protected void doEnable() {
    }

    protected void doDisable() {
    }

    public void loadParts(@NotNull Set<Class<?>> annotatedClasses) {

    }

    public Module getModule() {
        return null;
    }

    protected <T> T instance(Class<T> clazz) {
        return injector.getInstance(clazz);
    }
}
