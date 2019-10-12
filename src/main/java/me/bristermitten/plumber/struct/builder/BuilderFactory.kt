package me.bristermitten.plumber.struct.builder

import com.google.inject.assistedinject.Assisted
import me.bristermitten.plumber.struct.builder.impl.PlayerTaskLengthConfiguration
import me.bristermitten.plumber.struct.player.PPlayer

/**
 * Guice Factory for creating various builder interfaces
 */
interface BuilderFactory {

    /**
     * Create a new [PlayerTaskLengthConfiguration]
     * @param value the parent object
     */
    fun createPlayerTaskLengthConfiguration(@Assisted value: PlayerActionBuilder): PlayerTaskLengthConfiguration

    /**
     * Create a new [PlayerActionBuilder]
     * @param player the player who this action acts on
     * @param onTrigger a callback that will happen when the action happens
     */
    fun createPlayerActionBuilder(@Assisted player: PPlayer, @Assisted onTrigger: Runnable): PlayerActionBuilder


}
