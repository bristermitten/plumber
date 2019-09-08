package me.bristermitten.plumber.scheduling;

import com.google.inject.assistedinject.Assisted;
import me.bristermitten.plumber.PlumberPlugin;
import org.bukkit.Bukkit;

import javax.inject.Inject;

public class Task implements Runnable {

    private final long delay;
    private final long period;

    private final Runnable delegate;

    private final PlumberPlugin plugin;

    @Inject
    public Task(PlumberPlugin plugin, @Assisted("delay") long delay, @Assisted("period") long period,
                @Assisted Runnable delegate) {
        this.plugin = plugin;
        this.delay = delay;
        this.period = period;
        this.delegate = delegate;
    }

    public final void start() {
        Bukkit.getScheduler().runTaskTimerAsynchronously(plugin, this, 0, period);
    }

    public final void stop() {
    }

    @Override
    public void run() {
        delegate.run();
    }
}
