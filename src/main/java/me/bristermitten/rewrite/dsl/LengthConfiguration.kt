package me.bristermitten.rewrite.dsl

interface LengthConfiguration<out Filter : ActionFilter<Finish, out Filter>, out Reactor: ReactorPicker<Finish>, Finish> {
    fun forever()

    fun once(): Filter

    fun until() : Reactor

}
