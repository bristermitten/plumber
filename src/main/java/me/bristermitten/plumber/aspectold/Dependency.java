package me.bristermitten.plumber.aspectold;

import me.bristermitten.plumber.aspect.Aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Dependency {

    Class<? extends Aspect>[] value();
}
