package me.bristermitten.rewrite.dsl.core

import me.bristermitten.rewrite.dsl.PlayerReactorPicker

interface PlumberEntity<out T : PlumberEntity<T, F, RP>, F : ActionFilter<F>, RP : PlayerReactorPicker> {
    fun `do`(runnable: Runnable): F
    fun doWhile(runnable: Runnable): LengthConfiguration<F, RP>
}
