package me.bristermitten.plumber.scheduling

import me.bristermitten.plumber.aspect.AspectAnnotation

/**
 * Aspect annotation linking to [SchedulerAspect]
 * Currently, does nothing as the scheduler aspect is always loaded
 */
@AspectAnnotation(target = SchedulerAspect::class)
@Retention(AnnotationRetention.RUNTIME)
annotation class ScheduledTask
