package me.bristermitten.rewrite.dsl.core

import java.util.function.Supplier

interface ActionFilter<Us : ActionFilter<Us>> {
    fun whenIsTrue(boolean: Boolean): BooleanOperator<Us>
    fun whenIsTrue(boolean: Supplier<Boolean>): BooleanOperator<Us>
    fun whenIsTrue(boolean: () -> Boolean): BooleanOperator<Us>
    fun done()
}
