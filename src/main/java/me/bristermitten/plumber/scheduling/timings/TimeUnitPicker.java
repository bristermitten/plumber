package me.bristermitten.plumber.scheduling.timings;

public interface TimeUnitPicker {
    TimeBuilder milliseconds();

    TimeBuilder ticks();

    TimeBuilder seconds();

    TimeBuilder minutes();

    TimeBuilder hours();

    TimeBuilder days();

    TimeBuilder years();
}
