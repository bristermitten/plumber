package me.bristermitten.plumber.struct.builder;

public interface TaskBuilder<R, P extends FluentBuilder> extends FluentBuilder<R, P> {

    TaskBuilder indefinitely();

}
