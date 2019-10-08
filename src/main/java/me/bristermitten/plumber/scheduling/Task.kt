package me.bristermitten.plumber.scheduling

import com.google.inject.assistedinject.Assisted
import com.google.inject.assistedinject.AssistedInject
import me.bristermitten.plumber.PlumberPlugin
import me.bristermitten.plumber.struct.Resettable
import me.bristermitten.plumber.scheduling.timings.Time
import org.bukkit.scheduler.BukkitTask

/**
 * A Task wraps Bukkit's Scheduler system into a single object.
 * Currently, all tasks are ran asynchronously, but this will be improved in the future.
 *
 * Generally, all Tasks are created with [TaskFactory]
 *
 */
class Task : Runnable, Resettable {

    private val delay: Long
    private val period: Long
    private val run: Runnable

    private val plugin: PlumberPlugin

    private lateinit var task: BukkitTask

    @AssistedInject
    constructor(
            plugin: PlumberPlugin,
            @Assisted("delay") delay: Long,
            @Assisted("period") period: Long,
            @Assisted delegate: Runnable
    ) {
        this.plugin = plugin
        this.delay = delay
        this.period = period
        this.run = delegate
    }

    @AssistedInject
    constructor(
            plugin: PlumberPlugin,
            @Assisted("delay") delay: Time,
            @Assisted("period") period: Time,
            @Assisted delegate: Runnable
    ) {
        this.plugin = plugin
        this.delay = delay.toTicks()
        this.period = period.toTicks()
        this.run = delegate
    }

    fun start() {
        val scheduler = plugin.server.scheduler
        when {
            delay == Time.NONE_TICKS && period == Time.NONE_TICKS -> {
                task = scheduler.runTaskAsynchronously(plugin, this)
                return
            }
            delay == Time.NONE_TICKS -> {
                task = scheduler.runTaskTimerAsynchronously(plugin, this, 0, period)
                return
            }
            period == Time.NONE_TICKS -> {
                task = scheduler.runTaskLaterAsynchronously(plugin, this, delay)
                return
            }
            else -> task = scheduler.runTaskTimerAsynchronously(plugin, this, delay, period)
        }
    }

    fun stop() {
        task.cancel()
    }

    override fun run() {
        run.run()
    }

    override fun reset() {
        if (!task.isCancelled) {
            task.cancel()
        }
    }
}
