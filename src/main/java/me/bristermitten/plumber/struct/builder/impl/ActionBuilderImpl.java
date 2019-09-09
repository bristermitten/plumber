package me.bristermitten.plumber.struct.builder.impl;

import me.bristermitten.plumber.struct.builder.ActionBuilder;
import me.bristermitten.plumber.struct.builder.TaskLengthConfiguration;
import org.jetbrains.annotations.NotNull;

public class ActionBuilderImpl<T extends ActionBuilder<T>> implements ActionBuilder<T> {

    protected TaskLengthConfiguration<T> parent;


    @NotNull
    @Override
    public TaskLengthConfiguration<T> or() {
        return parent;
    }
}
