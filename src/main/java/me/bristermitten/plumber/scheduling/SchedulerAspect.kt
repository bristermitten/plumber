package me.bristermitten.plumber.scheduling;

import com.google.inject.AbstractModule;
import com.google.inject.Module;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import me.bristermitten.plumber.aspect.AbstractAspect;
import me.bristermitten.plumber.aspect.RequiredAspect;
import me.bristermitten.plumber.scheduling.timings.TaskBuilder;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitScheduler;
import org.jetbrains.annotations.Nullable;

@RequiredAspect
public class SchedulerAspect extends AbstractAspect {

    private BukkitScheduler scheduler;


    @Override
    protected void doEnable() {
        scheduler = Bukkit.getScheduler();
    }


//    @Override
//    public void loadParts(@NotNull Set<Class<?>> annotatedClasses) {
//        for (Class<?> annotatedClass : annotatedClasses) {
//            Object instance = instance(annotatedClass);
//
//        }
//    }

    @Nullable
    @Override
    public Module module() {
        return new AbstractModule() {
            @Override
            protected void configure() {
                install(new FactoryModuleBuilder()
                        .implement(TaskBuilder.class, TaskBuilder.impl)
                        .build(TaskBuilderFactory.class));

                install(new FactoryModuleBuilder()
                        .build(TaskFactory.class)
                );
            }
        };
    }
}
