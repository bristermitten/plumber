package me.bristermitten.plumber.scheduling;

import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;
import me.bristermitten.plumber.PlumberPlugin;
import me.bristermitten.plumber.object.Resettable;
import me.bristermitten.plumber.scheduling.timings.Time;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class Task implements Runnable, Resettable {

    private final long delay;
    private final long period;

    private final Runnable delegate;

    private final PlumberPlugin plugin;
    private BukkitTask task;

    @AssistedInject
    public Task(PlumberPlugin plugin, @Assisted("delay") long delay, @Assisted("period") long period,
                @Assisted Runnable delegate) {
        this.plugin = plugin;
        this.delay = delay;
        this.period = period;
        this.delegate = delegate;
    }

    @AssistedInject
    public Task(PlumberPlugin plugin, @Assisted("delay") Time delay, @Assisted("period") Time period,
                @Assisted Runnable delegate) {
        this.plugin = plugin;
        this.delay = delay.toTicks();
        this.period = period.toTicks();
        this.delegate = delegate;
    }

    public final void start() {
        BukkitRunnable runnable = new BukkitRunnable() {
            @Override
            public void run() {
                Task.this.run();
            }
        };
        if (delay == Time.Companion.getNONE_TICKS() && period == Time.Companion.getNONE_TICKS()) {
            task = runnable.runTaskAsynchronously(plugin);
            return;
        }
        if (delay == Time.Companion.getNONE_TICKS()) {
            task = runnable.runTaskTimerAsynchronously(plugin, 0, period);
            return;
        }
        if (period == Time.Companion.getNONE_TICKS()) {
            task = runnable.runTaskLaterAsynchronously(plugin, delay);
            return;
        }
        task = runnable.runTaskTimerAsynchronously(plugin, delay, period);
    }

    public final void stop() {
    }

    @Override
    public void run() {
        delegate.run();
    }

    @Override
    public void reset() {
        if (task != null && !task.isCancelled()) {
            task.cancel();
        }
    }
}
