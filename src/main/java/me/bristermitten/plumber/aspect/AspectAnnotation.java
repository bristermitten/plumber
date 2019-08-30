package me.bristermitten.plumber.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marks that an annotation is used by an aspect, and that the class scanner should initialize that Aspect if not
 * already done.
 */
@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface AspectAnnotation {
    Class<? extends Aspect> target();
}
