package me.bristermitten.rewrite.dsl.player

import me.bristermitten.rewrite.dsl.core.BooleanOperator
import me.bristermitten.rewrite.dsl.core.ReactorPicker
import org.bukkit.event.player.PlayerEvent
import kotlin.reflect.KClass

interface PlayerReactorPicker : ReactorPicker<PlayerReactorPicker> {
    fun death(): BooleanOperator<PlayerReactorPicker>

    fun nextEvent(clazz : Class<out PlayerEvent>) : BooleanOperator<PlayerReactorPicker>

    fun nextEvent(clazz : KClass<out PlayerEvent>) : BooleanOperator<PlayerReactorPicker>

}
