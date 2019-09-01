package me.bristermitten.plumber.struct.builder;

public interface FluentBuilder<R, P extends FluentBuilder> {

    R build();

    P done();
}
