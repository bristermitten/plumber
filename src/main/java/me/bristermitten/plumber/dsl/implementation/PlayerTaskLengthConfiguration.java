package me.bristermitten.plumber.dsl.implementation;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import me.bristermitten.plumber.scheduling.TaskFactory;
import me.bristermitten.plumber.scheduling.timings.TimeUnitPickerFactory;
import me.bristermitten.plumber.dsl.PlayerActionBuilder;
import org.jetbrains.annotations.NotNull;

public class PlayerTaskLengthConfiguration extends DefaultTaskLengthConfiguration<PlayerActionBuilder> {

    @Inject
    public PlayerTaskLengthConfiguration(@Assisted @NotNull PlayerActionBuilder parent,
                                         @NotNull TimeUnitPickerFactory factory,
                                         TaskFactory taskFactory) {
        super(parent, factory, taskFactory);
    }
}
