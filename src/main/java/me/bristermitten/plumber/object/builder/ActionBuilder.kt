package me.bristermitten.plumber.`object`.builder

import me.bristermitten.plumber.`object`.Resettable


interface ActionBuilder<T : ActionBuilder<T>> : Runnable, Resettable {

    /**
     * Returns the parent object for further configuration
     *
     * @return the parent
     */
    fun or(): TaskLengthConfiguration<T>


//    companion object {
//        var impl: Class<out ActionBuilder<*>> = ActionBuilderImpl::class.java
//    }
}
