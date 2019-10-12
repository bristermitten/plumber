package me.bristermitten.plumber.struct.builder.impl;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import me.bristermitten.plumber.struct.builder.PlayerActionBuilder;
import me.bristermitten.plumber.scheduling.TaskFactory;
import me.bristermitten.plumber.scheduling.timings.TimeUnitPickerFactory;
import org.jetbrains.annotations.NotNull;

public class PlayerTaskLengthConfiguration extends DefaultTaskLengthConfiguration<PlayerActionBuilder> {
    @Inject
    public PlayerTaskLengthConfiguration(@Assisted @NotNull PlayerActionBuilder parent,
                                         @NotNull TimeUnitPickerFactory factory,
                                         TaskFactory taskFactory) {
        super(parent, factory, taskFactory);
    }
}
