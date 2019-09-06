package me.bristermitten.plumber.scheduling.timings

import com.google.inject.Inject
import com.google.inject.assistedinject.Assisted
import java.util.function.Consumer


internal class TimeUnitPickerImpl @Inject constructor(
        @Assisted private val parent: TaskBuilder,
        @Assisted private val callback: Consumer<TimeUnit>
) : TimeUnitPicker {


    override fun milliseconds(): TaskBuilder {
        callback.accept(TimeUnit.MILLISECONDS);
        return parent
    }

    override fun ticks(): TaskBuilder {
        callback.accept(TimeUnit.TICKS)
        return parent
    }

    override fun seconds(): TaskBuilder {
        callback.accept(TimeUnit.SECONDS)
        return parent
    }

    override fun minutes(): TaskBuilder {
        callback.accept(TimeUnit.MINUTES)
        return parent
    }

    override fun hours(): TaskBuilder {
        callback.accept(TimeUnit.HOURS)
        return parent
    }

    override fun days(): TaskBuilder {
        callback.accept(TimeUnit.DAYS)
        return parent
    }

}
