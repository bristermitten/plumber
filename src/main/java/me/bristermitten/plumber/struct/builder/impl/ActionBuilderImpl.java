package me.bristermitten.plumber.struct.builder.impl;

import me.bristermitten.plumber.struct.builder.ActionBuilder;
import me.bristermitten.plumber.struct.builder.TaskLengthConfiguration;
import org.jetbrains.annotations.NotNull;

/**
 * Simple implementation of {@link ActionBuilder} that holds a parent {@link TaskLengthConfiguration}
 *
 * @param <T> the action builder's own type
 */
public abstract class ActionBuilderImpl<T extends ActionBuilder<T>> implements ActionBuilder<T> {
    protected TaskLengthConfiguration<T> parent;

    @NotNull
    @Override
    public TaskLengthConfiguration<T> or() {
        return parent;
    }
}
