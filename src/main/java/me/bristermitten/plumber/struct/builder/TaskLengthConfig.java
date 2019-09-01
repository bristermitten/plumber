package me.bristermitten.plumber.struct.builder;

public interface TaskLengthConfig<B extends TaskBuilder> extends FluentBuilder<B, TaskBuilder> {
    B indefinitely();

    B until();
}
