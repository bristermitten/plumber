package me.bristermitten.plumber.scheduling

import com.google.inject.assistedinject.Assisted
import me.bristermitten.plumber.scheduling.timings.Time

/**
 * Guice Assisted Injection factory for creating instances of [Task]
 */
interface TaskFactory {
    fun create(@Assisted("delay") delay: Long, @Assisted("period") period: Long, run: Runnable): Task

    fun create(@Assisted("delay") delay: Time, @Assisted("period") period: Time, run: Runnable): Task
}
