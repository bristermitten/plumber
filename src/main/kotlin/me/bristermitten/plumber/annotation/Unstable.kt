package me.bristermitten.plumber.annotation

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy

/**
 * Indicates that a part of the API is unstable.
 * This can range from bugs, to completely nothing being implemented / working yet.
 * It's advised not to use anything annotated with [Unstable],
 * but feel free to submit a PR!
 *
 * It's important to note that at this stage, everything in Plumber is considered unstable, as
 * it is all subject to changes.
 */
@Target(AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CLASS)
@Retention(RetentionPolicy.SOURCE)
annotation class Unstable(val reason: String = "")
