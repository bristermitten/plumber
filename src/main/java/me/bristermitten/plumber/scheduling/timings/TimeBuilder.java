package me.bristermitten.plumber.scheduling.timings;

/**
 * Builder for configuring times in the future for scheduling
 */
public interface TimeBuilder {

    TimeBuilder fromNow();

    TimeBuilder from(FutureTime futureTime);

    TimeBuilder fromEpoch(long epoch);

    TimeUnitPicker in(long time);

    FutureTime get();
}
