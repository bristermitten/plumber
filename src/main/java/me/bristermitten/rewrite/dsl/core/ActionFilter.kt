package me.bristermitten.rewrite.dsl.core

interface ActionFilter<Us : ActionFilter<Us>> {
    fun whenIsTrue(boolean: Boolean): BooleanOperator<Us>
}
