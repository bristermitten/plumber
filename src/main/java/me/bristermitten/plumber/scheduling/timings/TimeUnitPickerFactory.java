package me.bristermitten.plumber.scheduling.timings;

import java.util.function.Consumer;

public interface TimeUnitPickerFactory {

    TimeUnitPicker pick(TaskBuilder parent, Consumer<TimeUnit> callback);
}
