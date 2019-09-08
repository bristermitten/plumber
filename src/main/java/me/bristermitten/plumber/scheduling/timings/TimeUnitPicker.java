package me.bristermitten.plumber.scheduling.timings;

public interface TimeUnitPicker<T> {
    Class<? extends TimeUnitPicker> impl = TimeUnitPickerImpl.class;

    T milliseconds();

    T ticks();

    T seconds();

    T minutes();

    T hours();

    T days();
}
