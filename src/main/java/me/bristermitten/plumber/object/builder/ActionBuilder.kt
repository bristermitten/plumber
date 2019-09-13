package me.bristermitten.plumber.`object`.builder


interface ActionBuilder<T : ActionBuilder<T>> {

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
