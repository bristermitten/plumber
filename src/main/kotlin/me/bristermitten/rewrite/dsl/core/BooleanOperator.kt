package me.bristermitten.rewrite.dsl.core

/**
 * Used for chaining multiple tasks
 */
interface BooleanOperator<P> {
    fun or(): P
    fun and(): P
    fun xor() : P
    fun nand() : P
}
