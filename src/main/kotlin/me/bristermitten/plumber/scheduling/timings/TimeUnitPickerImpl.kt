package me.bristermitten.plumber.scheduling.timings

import com.google.inject.Inject
import com.google.inject.assistedinject.Assisted


internal class TimeUnitPickerImpl<T>
@Inject constructor(
        @Assisted val parent: T,
        @Assisted val callback: (TimeUnit) -> Unit
) : TimeUnitPicker<T> {


    override fun milliseconds(): T {
        callback(TimeUnit.MILLISECONDS)
        return parent
    }

    override fun ticks(): T {
        callback(TimeUnit.TICKS)
        return parent
    }

    override fun seconds(): T {
        callback(TimeUnit.SECONDS)
        return parent
    }

    override fun minutes(): T {
        callback(TimeUnit.MINUTES)
        return parent
    }

    override fun hours(): T {
        callback(TimeUnit.HOURS)
        return parent
    }

    override fun days(): T {
        callback(TimeUnit.DAYS)
        return parent
    }

}
