package me.bristermitten.rewrite.dsl.core

import me.bristermitten.rewrite.dsl.player.PPlayer

/**
 * @author Alexander Wood (BristerMitten)
 */
val entity: PPlayer? = null

fun doSomething() {
    entity?.createTask{
        println("yo")
    }?.whenIsTrue {
        true
    }
}
