package me.bristermitten.rewrite.dsl

interface PlayerActionFilter<F> : ActionFilter<F, PlayerActionFilter<F>> {

    fun whenIsInWorld(worldName: String): BooleanCycle<PlayerActionFilter<F>, F>
}
