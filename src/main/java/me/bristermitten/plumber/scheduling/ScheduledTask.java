package me.bristermitten.plumber.scheduling;

import me.bristermitten.plumber.aspect.AspectAnnotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@AspectAnnotation(target = SchedulerAspect.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface ScheduledTask {
}
