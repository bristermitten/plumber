package me.bristermitten.plumber

import org.junit.jupiter.api.Test
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

class Test {
    @ExperimentalContracts
    @Test
    fun test(): Boolean {
//        tryReturn {
//            return true
//        }
        val x: Number = 3
        tryReturn2(x)
        println("not returned")
        return false
    }


}

@ExperimentalContracts
fun tryReturn2(number: Number) {
    contract {
        returns() implies (number is Int)
    }
}
