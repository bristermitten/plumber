package me.bristermitten.plumber.scheduling.timings


/**
 * Simple factory class for creating instances of [TimeUnitPicker]
 * Due to the use of generics, we can't use Assisted Inject for this, so have to do it manually
 *
 * May be changed in the future
 */
class TimeUnitPickerFactory {

    /**
     * Create a new [TimeUnitPicker]
     */
    fun <T> pick(parent: T, callback: (TimeUnit) -> Unit): TimeUnitPicker<T> {
        return TimeUnitPickerImpl(parent, callback)
    }
}
