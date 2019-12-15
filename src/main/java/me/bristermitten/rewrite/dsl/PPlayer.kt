package me.bristermitten.rewrite.dsl

import me.bristermitten.rewrite.dsl.core.LengthConfiguration
import me.bristermitten.rewrite.dsl.core.PlumberEntity
import org.bukkit.event.Cancellable
import org.bukkit.event.player.PlayerEvent

interface PPlayer : PlumberEntity<PPlayer, PlayerActionFilter, PlayerReactorPicker> {
    fun <T > blockEvent(clazz: Class<T>) : LengthConfiguration<PlayerActionFilter, PlayerReactorPicker> where T : PlayerEvent, T : Cancellable
}
