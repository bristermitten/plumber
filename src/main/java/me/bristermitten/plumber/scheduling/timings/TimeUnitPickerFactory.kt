package me.bristermitten.plumber.scheduling.timings;

import com.google.inject.Inject;
import com.google.inject.Injector;

import java.util.function.Consumer;

public final class TimeUnitPickerFactory {

    public <T> TimeUnitPicker<T> pick(T parent, Consumer<TimeUnit> callback) {
        return new TimeUnitPickerImpl<>(parent, callback);
    }
}
