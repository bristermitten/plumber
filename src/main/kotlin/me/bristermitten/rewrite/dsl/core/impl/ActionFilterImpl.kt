package me.bristermitten.rewrite.dsl.core.impl

import me.bristermitten.rewrite.dsl.core.ActionFilter
import me.bristermitten.rewrite.dsl.core.BooleanOperator
import java.util.function.Supplier

class ActionFilterImpl(private val runnable: ()->Unit) : ActionFilter<ActionFilterImpl> {
    private var allowedToRun = true

    override fun whenIsTrue(boolean: Boolean): BooleanOperator<ActionFilterImpl> {
        allowedToRun = boolean
        return BooleanOperatorImpl(this)
    }

    override fun whenIsTrue(boolean: Supplier<Boolean>): BooleanOperator<ActionFilterImpl> {
        return whenIsTrue(boolean.get())
    }

    override fun whenIsTrue(boolean: () -> Boolean): BooleanOperator<ActionFilterImpl> {
        return whenIsTrue(boolean())
    }

    override fun done() {
        if (allowedToRun)
            runnable()
    }
}
