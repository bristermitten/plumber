package me.bristermitten.plumber.struct;

import com.google.inject.AbstractModule;
import com.google.inject.Module;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import me.bristermitten.plumber.aspect.AbstractAspect;
import me.bristermitten.plumber.aspect.RequiredAspect;
import me.bristermitten.plumber.struct.builder.BuilderFactory;
import me.bristermitten.plumber.struct.builder.PlayerActionBuilder;
import me.bristermitten.plumber.struct.builder.TaskLengthConfiguration;
import me.bristermitten.plumber.struct.player.PPlayer;

/**
 * Aspect containing the management of all data classes
 * This includes most of the main objects in Plumber,
 * namely {@link PPlayer}
 */
@RequiredAspect
public class DataAspect extends AbstractAspect {

    @Override
    public Module module() {
        return new AbstractModule() {
            @Override
            protected void configure() {
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
