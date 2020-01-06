package me.bristermitten.rewrite.dsl.core

import me.bristermitten.rewrite.dsl.player.PlayerReactorPicker
import javax.annotation.CheckReturnValue

interface PlumberEntity<T : PlumberEntity<T, F, RP>, F : ActionFilter<F>, RP : PlayerReactorPicker> {

    /**
     * Execute a task
     */
    @CheckReturnValue
    fun createTask(runnable: () -> Unit): F
    @CheckReturnValue
    fun executeTask(runnable: () -> Unit): LengthConfiguration<F, RP>
}
