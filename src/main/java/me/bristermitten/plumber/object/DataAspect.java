package me.bristermitten.plumber.object;

import com.google.inject.AbstractModule;
import com.google.inject.Module;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import me.bristermitten.plumber.aspect.AbstractAspect;
import me.bristermitten.plumber.aspect.Dependency;
import me.bristermitten.plumber.scheduling.SchedulerAspect;
import me.bristermitten.plumber.object.builder.BuilderFactory;
import me.bristermitten.plumber.object.builder.PlayerActionBuilder;
import me.bristermitten.plumber.object.builder.TaskLengthConfiguration;


@Dependency(SchedulerAspect.class)
public class DataAspect extends AbstractAspect {

    @Override
    public Module getModule(Module parent) {
        return new AbstractModule() {
            @Override
            protected void configure() {
                install(parent);
                //        bind(ActionBuilder.class).to(ActionBuilder.Companion.getImpl());
                //        bind(KeyChangeChooser.class).to(KeyChangeChooserImpl.class);

                install(new FactoryModuleBuilder()
                        .implement(PlayerActionBuilder.class, PlayerActionBuilder.Companion.getImpl())
                        .implement(TaskLengthConfiguration.class, TaskLengthConfiguration.Companion.getImpl())
                        .build(BuilderFactory.class));
            }
        };
    }
}
