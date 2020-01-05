package me.bristermitten.plumber.scheduling.timings

/**
 * A TimeUnitPicker allows developers to choose a time unit for an action.
 * General best practice is to have the method that returns a TimeUnitPicker
 * take a long for the amount of time, for example
 * `
 * PPlayer#blockEvent(PlayerMoveEvent.class).undoAfter(30).seconds()
` *
 *
 * @param <T> the return type (generally a parent interface)
</T> */
interface TimeUnitPicker<T> {
    /**
     * Pick milliseconds, where 1000 milliseconds are in a second
     *
     * @return the parent object
     */
    fun milliseconds(): T

    /**
     * Pick ticks, where 20 ticks are in a second
     *
     * @return the parent object
     */
    fun ticks(): T

    /**
     * Pick seconds, where 1 second is in a second
     *
     * @return the parent object
     */
    fun seconds(): T

    /**
     * Pick minutes, where 1/60 minutes are in a second
     *
     * @return the parent object
     */
    fun minutes(): T

    /**
     * Pick hours, where 1/3600 hours are in a second
     *
     * @return the parent object
     */
    fun hours(): T

    /**
     * Pick days, where 1/86400 days are in a second
     *
     * @return the parent object
     */
    fun days(): T

    companion object {
        /**
         * The default implementation for this class.
         * Currently unused but theoretically used for customising Guice assisted injection
         * factories
         */
        val impl: Class<out TimeUnitPicker<*>> = TimeUnitPickerImpl::class.java
    }
}
