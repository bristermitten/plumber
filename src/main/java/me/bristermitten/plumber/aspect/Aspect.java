package me.bristermitten.plumber.aspect;

import com.google.inject.Inject;

import java.util.Set;

/**
 * An aspect represents a group of features in Plumber
 * This could be, for example, commands, or a cross-server communication library
 * <p>
 * Aspects will not be initialized until they are required, and you can assume that {@link Aspect#enable()}
 * will be called almost immediately afterwards
 * Aspects will be initialized with Guice, so can safely use {@link Inject}
 */
public interface Aspect {

    boolean isEnabled();

    void enable();

    void disable();

    void loadParts(Set<Class> annotatedClasses);
}
