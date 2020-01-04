package me.bristermitten.plumber.dsl.implementation

import me.bristermitten.plumber.dsl.ActionBuilder
import me.bristermitten.plumber.dsl.TaskLengthConfiguration

/**
 * Simple implementation of [ActionBuilder] that holds a parent [TaskLengthConfiguration]
 *
 * @param <T> the action builder's own type
 * */
abstract class ActionBuilderImpl<T : ActionBuilder<T>> : ActionBuilder<T> {
    protected lateinit var parent: TaskLengthConfiguration<T>

    override fun or(): TaskLengthConfiguration<T> {
        return parent
    }
}
