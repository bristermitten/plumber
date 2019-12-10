package me.bristermitten.rewrite.dsl

interface ReactorPicker<F> : IntermediateProducer<ReactorPicker<F>, F> {
    fun later() : BooleanCycle<ReactorPicker<F>, F>
    fun logout() : BooleanCycle<ReactorPicker<F>, F>

}
