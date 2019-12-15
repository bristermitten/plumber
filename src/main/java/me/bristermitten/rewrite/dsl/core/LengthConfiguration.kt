package me.bristermitten.rewrite.dsl.core

interface LengthConfiguration<out Filter : ActionFilter<out Filter>, out Reactor: ReactorPicker<*>> {
    fun forever()

    fun once(): Filter

    fun until() : Reactor

}
