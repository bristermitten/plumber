package me.bristermitten.plumber.injection;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

public abstract class PlumberModule extends AbstractModule {

    public Injector createInjector() {
        return Guice.createInjector(this);
    }
}
