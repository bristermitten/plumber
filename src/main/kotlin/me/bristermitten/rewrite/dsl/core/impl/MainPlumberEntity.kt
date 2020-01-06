package me.bristermitten.rewrite.dsl.core.impl

import me.bristermitten.rewrite.dsl.core.ActionFilter
import me.bristermitten.rewrite.dsl.core.LengthConfiguration
import me.bristermitten.rewrite.dsl.core.PlumberEntity
import me.bristermitten.rewrite.dsl.player.PlayerReactorPicker

class MainPlumberEntity<T : PlumberEntity<T, F, RP>, F : ActionFilter<F>, RP : PlayerReactorPicker> :
    PlumberEntity<T, F, RP> {

    override fun createTask(runnable: () -> Unit): F {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//        return ActionFilterImpl(runnable)
    }

    override fun executeTask(runnable: () -> Unit): LengthConfiguration<F, RP> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
