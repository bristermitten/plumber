package me.bristermitten.plumber.scheduling.timings;

/**
 * A TimeUnitPicker allows developers to choose a time unit for an action.
 * General best practice is to have the method that returns a TimeUnitPicker
 * take a long for the amount of time, for example
 * <code>
 * PPlayer#blockEvent(PlayerMoveEvent.class).undoAfter(30).seconds()
 * </code>
 *
 * @param <T> the return type (generally a parent interface)
 */
public interface TimeUnitPicker<T> {
    /**
     * The default implementation for this class.
     * Currently unused but theoretically used for customising Guice assisted injection
     * factories
     */
    @SuppressWarnings("rawtypes")
    Class<? extends TimeUnitPicker> impl = TimeUnitPickerImpl.class;

    /**
     * Pick milliseconds, where 1000 milliseconds are in a second
     *
     * @return the parent object
     */
    T milliseconds();

    /**
     * Pick ticks, where 20 ticks are in a second
     *
     * @return the parent object
     */
    T ticks();

    /**
     * Pick seconds, where 1 second is in a second
     *
     * @return the parent object
     */
    T seconds();

    /**
     * Pick minutes, where 1/60 minutes are in a second
     *
     * @return the parent object
     */
    T minutes();

    /**
     * Pick hours, where 1/3600 hours are in a second
     *
     * @return the parent object
     */
    T hours();

    /**
     * Pick days, where 1/86400 days are in a second
     *
     * @return the parent object
     */
    T days();
}
