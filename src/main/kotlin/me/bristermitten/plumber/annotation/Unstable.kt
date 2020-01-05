package me.bristermitten.plumber.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicates that a part of the API is unstable.
 * This can range from bugs, to completely nothing being implemented / working yet.
 * It's advised not to use anything annotated with {@link Unstable},
 * but feel free to submit a PR!
 *
 * It's important to note that at this stage, everything in Plumber is considered unstable, as
 * it is all subject to changes.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface Unstable {
    String reason() default "";
}
