package me.bristermitten.plumber.scheduling;

import com.google.inject.AbstractModule;
import com.google.inject.Module;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import me.bristermitten.plumber.aspect.AbstractAspect;
import me.bristermitten.plumber.scheduling.timings.TaskBuilder;
import me.bristermitten.plumber.scheduling.timings.TimeUnitPicker;
import me.bristermitten.plumber.scheduling.timings.TimeUnitPickerFactory;
import me.bristermitten.plumber.struct.builder.TaskFactory;
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
    public Module getModule() {
        return new AbstractModule() {
            @Override
            protected void configure() {
                install(new FactoryModuleBuilder()
                        .implement(TimeUnitPicker.class, TimeUnitPicker.impl)
                        .build(TimeUnitPickerFactory.class));

                install(new FactoryModuleBuilder()
                        .implement(TaskBuilder.class, TaskBuilder.impl)
                        .build(TaskBuilderFactory.class));

                install(new FactoryModuleBuilder()
                        .build(TaskFactory.class)
                );
            }
        };
    }

    @Override
    public void loadParts(Set<Class> annotatedClasses) {
        for (Class annotatedClass : annotatedClasses) {
            Object instance = instance(annotatedClass);

        }
    }
}
