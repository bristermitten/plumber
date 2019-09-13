package me.bristermitten.plumber.`object`.builder

import com.google.inject.assistedinject.Assisted
import me.bristermitten.plumber.`object`.builder.impl.PlayerTaskLengthConfiguration
import me.bristermitten.plumber.`object`.player.PPlayer

interface BuilderFactory {
    fun createPlayerConfiguration(@Assisted value: PlayerActionBuilder): PlayerTaskLengthConfiguration


    fun createPlayerActionBuilder(@Assisted player: PPlayer): PlayerActionBuilder


}
