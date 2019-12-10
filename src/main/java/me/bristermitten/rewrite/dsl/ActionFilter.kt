package me.bristermitten.rewrite.dsl

interface ActionFilter<Finish, Us : ActionFilter<Finish, Us>> : IntermediateProducer<Us, Finish> {
    fun whenIsTrue(boolean: Boolean): BooleanCycle<Us, Finish>
}
