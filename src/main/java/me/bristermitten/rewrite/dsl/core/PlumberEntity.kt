package me.bristermitten.rewrite.dsl.core

import me.bristermitten.rewrite.dsl.player.PlayerReactorPicker

interface PlumberEntity<T : PlumberEntity<T, F, RP>, F : ActionFilter<F>, RP : PlayerReactorPicker> {

    /**
     * Execute a task
     */
    fun execute(runnable: Runnable): F

    fun executeTask(runnable: Runnable): LengthConfiguration<F, RP>
}
