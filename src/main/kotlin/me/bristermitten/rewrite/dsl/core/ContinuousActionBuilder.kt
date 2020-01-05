package me.bristermitten.rewrite.dsl.core

import me.bristermitten.rewrite.dsl.player.PPlayer
import org.bukkit.event.player.PlayerMoveEvent

interface ContinuousActionBuilder<F> {

    companion object {
        private lateinit var pPlayer: PPlayer
        fun test() {
            pPlayer.execute(Runnable { println("hello world") }).whenIsInWorld("test world").or().whenIsTrue(true)
            pPlayer.executeTask(Runnable { println("test") }).until().death().or().logout().or().death().and().death().nand().logout()
            pPlayer.blockEvent(PlayerMoveEvent::class.java).until().death()
        }
    }
}
