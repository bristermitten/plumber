package me.bristermitten.plumber.object.builder.impl;

import me.bristermitten.plumber.object.builder.ActionBuilder;
import me.bristermitten.plumber.object.builder.TaskLengthConfiguration;
import org.jetbrains.annotations.NotNull;

public class ActionBuilderImpl<T extends ActionBuilder<T>> implements ActionBuilder<T> {

    protected TaskLengthConfiguration<T> parent;


    @NotNull
    @Override
    public TaskLengthConfiguration<T> or() {
        return parent;
    }
}
