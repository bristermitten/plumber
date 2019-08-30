package me.bristermitten.plumber.aspect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractAspect implements Aspect {
    protected Logger logger;
    private boolean enabled;

    protected AbstractAspect() {
        logger = LoggerFactory.getLogger(getClass());
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void enable() {
        logger.debug("Enabling aspect " + getClass().getSimpleName());
        doEnable();
        enabled = true;
        logger.debug("Done");
    }

    @Override
    public void disable() {
        logger.debug("Enabling aspect " + getClass().getSimpleName());
        doDisable();
        enabled = false;
        logger.debug("Done");
    }

    protected void doEnable() {
    }

    protected void doDisable() {
    }
}
