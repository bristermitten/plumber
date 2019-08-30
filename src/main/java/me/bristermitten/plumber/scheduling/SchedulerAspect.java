package me.bristermitten.plumber.scheduling;

import me.bristermitten.plumber.aspect.AbstractAspect;
import me.bristermitten.plumber.scheduling.timings.TimeBuilder;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.Set;

public class SchedulerAspect extends AbstractAspect {

    private BukkitScheduler scheduler;

    @Override
    protected void doEnable() {
        scheduler = Bukkit.getScheduler();
    }

    @Override
    public void loadParts(Set<Class> annotatedClasses) {
        for (Class<?> annotatedClass : annotatedClasses) {
            if (!Task.class.isAssignableFrom(annotatedClass)) {
                logger.error("Class {} is annotated with @ScheduledTask but does not extend Task", annotatedClass);
                continue;
            }

            Task task = (Task) instance(annotatedClass);
            TimeBuilder builder = instance(TimeBuilder.class);

            task.configure(builder);

            builder.getTarget();
        }

    }
}
