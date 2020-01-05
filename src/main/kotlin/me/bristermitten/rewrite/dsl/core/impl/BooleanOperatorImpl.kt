package me.bristermitten.rewrite.dsl.core.impl

import me.bristermitten.rewrite.dsl.core.BooleanOperator

class BooleanOperatorImpl<P>(private val p: P) : BooleanOperator<P> {

    override fun or(): P {
        return p
    }

    override fun and(): P {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun xor(): P {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun nand(): P {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
