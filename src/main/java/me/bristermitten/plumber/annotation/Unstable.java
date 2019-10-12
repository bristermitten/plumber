package me.bristermitten.plumber.annotation;

/**
 * Indicates that a part of the API is unstable.
 * This can range from bugs, to completely nothing being implemented / working yet.
 * It's advised not to use anything annotated with {@link Unstable},
 * but feel free to submit a PR!
 *
 * It's important to note that at this stage, everything in Plumber is considered unstable, as
 * it is all subject to changes.
 */
public @interface Unstable {
    String reason() default "";
}
