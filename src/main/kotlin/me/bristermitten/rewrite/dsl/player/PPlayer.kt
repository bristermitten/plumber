package me.bristermitten.rewrite.dsl.player

import me.bristermitten.rewrite.dsl.core.LengthConfiguration
import me.bristermitten.rewrite.dsl.core.PlumberEntity
import org.bukkit.event.Cancellable
import org.bukkit.event.player.PlayerEvent
import kotlin.reflect.KClass

interface PPlayer : PlumberEntity<PPlayer, PlayerActionFilter, PlayerReactorPicker> {

    fun <T> blockEvent(clazz: Class<T>): LengthConfiguration<PlayerActionFilter, PlayerReactorPicker> where T : PlayerEvent, T : Cancellable

    fun <T> blockEvent(clazz: KClass<T>): LengthConfiguration<PlayerActionFilter, PlayerReactorPicker> where T : PlayerEvent, T : Cancellable

    fun sendMessage(message: String)

    fun kill()
}
