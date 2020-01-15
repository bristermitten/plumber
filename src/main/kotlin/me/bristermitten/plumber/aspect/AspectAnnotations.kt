package me.bristermitten.plumber.aspect

import com.google.inject.Module
import kotlin.reflect.KClass

/**
 * Annotation Classes related to the loading of Aspects
 *
 */

/**
 * Only applicable to subclasses of [Aspect].
 *
 * This annotation indicates that an Aspect is required and must always be loaded.
 * It should be used sparingly.
 *
 * Required Aspects will be loaded before non-required Aspects.
 * @param priority The priority for loading in relation to other required Aspects. Higher priorities load first.
 */
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
@MustBeDocumented
annotation class RequiredAspect(val priority: Int = 0)


/**
 * Only applicable to subclasses of [Aspect].
 *
 * Used to configure a static module for an Aspect.
 * This is useful when an Aspect requires some bindings from Guice to be injected into it.
 *
 * Normally, injection would happen, and then [Aspect.getModule] would be installed,
 * but no bindings would exist from the module when the Aspect is created.
 *
 * This annotation solves that problem.
 * If an Aspect has it, the given [target] will be installed first,
 * and then the Aspect will be injected with the bindings from the module.
 */
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
annotation class StaticModule(val target: KClass<out Module>)


/**
 * Binds an Annotation to an Aspect.
 *
 * If the annotated annotation is present at all on the classpath,
 * the given [target] will be loaded if not already.
 */
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.ANNOTATION_CLASS)
@MustBeDocumented
annotation class AspectAnnotation(val target: KClass<out Aspect>)


/**
 * Only applicable to subclasses of [Aspect].
 *
 * Similar to [AspectAnnotation], this binds an annotation to an Aspect, but the other way around.
 *
 * If any of the [targets] are present at all on the classpath,
 * the annotated Aspect will be loaded if not already.
 *
 * This annotation should only be used if the [targets] are part of an external library
 * and cannot be given [AspectAnnotation]. A good example is ACF's @CommandAlias,
 * which is third party, cannot be modified, but must be checked for loading the command aspect.
 */
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
@Repeatable
@MustBeDocumented
annotation class LoadIfPresent(vararg val targets: KClass<out Annotation>)
