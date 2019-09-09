package me.bristermitten.plumber.aspect;

import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;
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
    public boolean isEnabled() {
        return enabled;
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
        logger.info("Enabling aspect " + getClass().getSimpleName());
        doDisable();
        enabled = false;
        logger.info("Done");
    }

    protected void doEnable() {
    }

    protected void doDisable() {
    }

    @Override
    public void loadParts(Set<Class> annotatedClasses) {

    }

    @Override
    public Module getModule(Module parent) {
        return parent;
    }

    protected <T> T instance(Class<T> clazz) {
        return injector.getInstance(clazz);
    }
}
