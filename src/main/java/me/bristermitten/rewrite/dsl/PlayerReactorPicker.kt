package me.bristermitten.rewrite.dsl

import me.bristermitten.rewrite.dsl.core.BooleanOperator
import me.bristermitten.rewrite.dsl.core.ReactorPicker

interface PlayerReactorPicker : ReactorPicker<PlayerReactorPicker> {
    fun death(): BooleanOperator<PlayerReactorPicker>
}
