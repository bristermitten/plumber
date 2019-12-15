package me.bristermitten.rewrite.dsl.core

interface ReactorPicker<Us : ReactorPicker<Us>> {
    fun later() : BooleanOperator<Us>
    fun logout() : BooleanOperator<Us>

}
