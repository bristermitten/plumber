package me.bristermitten.plumber.scheduling.timings;

public interface TimeUnitPicker {
    Class<? extends TimeUnitPicker> impl = TimeUnitPickerImpl.class;

    TaskBuilder milliseconds();

    TaskBuilder ticks();

    TaskBuilder seconds();

    TaskBuilder minutes();

    TaskBuilder hours();

    TaskBuilder days();
}
