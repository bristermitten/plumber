package me.bristermitten.plumber.aspect;

import com.google.inject.Inject;
import com.google.inject.Module;

import java.util.Set;

/**
 * An aspect represents a group of features in Plumber
 * This could be, for example, commands, or a cross-server communication library
 * <p>
 * Due to how loading is performed, it is advised to not perform any logic in the constructor, and wait for
 * {@link Aspect#enable()} to be called, as data is injected twice due to constraints.
 * It's also advised to have a no-args constructor and instead use field injection (but only in an Aspect)
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

    /**
     * If an independent module is returned, it **MUST** install the provided parent!
     *
     * @param parent
     * @return
     */
    Module getModule(Module parent);
}
