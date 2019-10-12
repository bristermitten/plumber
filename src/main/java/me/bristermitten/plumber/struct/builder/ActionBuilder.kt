package me.bristermitten.plumber.struct.builder

import me.bristermitten.plumber.struct.Resettable


/**
 * It's quite hard to give a simple description for this interface, other than it provides
 * a specification for sub-classes like [PlayerActionBuilder]
 * Generally Action Builder is used after [TaskLengthConfiguration] in the interface control flow
 * @param T the action builder's own type, so that any functions can return a child interface with the right parent type
 */
interface ActionBuilder<T : ActionBuilder<T>> : Runnable, Resettable {

    /**
     * Returns the parent object for further configuration
     *
     * @return the parent
     */
    fun or(): TaskLengthConfiguration<T>

}
