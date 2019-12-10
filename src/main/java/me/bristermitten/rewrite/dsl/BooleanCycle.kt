package me.bristermitten.rewrite.dsl

interface BooleanCycle<P,  F> {
    fun or(): P
    fun done(): F
}
