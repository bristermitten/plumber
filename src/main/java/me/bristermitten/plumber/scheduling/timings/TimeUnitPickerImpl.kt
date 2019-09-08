package me.bristermitten.plumber.scheduling.timings

import com.google.inject.Inject
import com.google.inject.assistedinject.Assisted
import java.util.function.Consumer


internal class TimeUnitPickerImpl<T> @Inject constructor(
        @Assisted val parent: T,
        @Assisted val callback: Consumer<TimeUnit>
) : TimeUnitPicker<T> {


    override fun milliseconds(): T {
        callback.accept(TimeUnit.MILLISECONDS);
        return parent
    }

    override fun ticks(): T {
        callback.accept(TimeUnit.TICKS)
        return parent
    }

    override fun seconds(): T {
        callback.accept(TimeUnit.SECONDS)
        return parent
    }

    override fun minutes(): T {
        callback.accept(TimeUnit.MINUTES)
        return parent
    }

    override fun hours(): T {
        callback.accept(TimeUnit.HOURS)
        return parent
    }

    override fun days(): T {
        callback.accept(TimeUnit.DAYS)
        return parent
    }

}
