package me.bristermitten.plumber.`object`.builder

import me.bristermitten.plumber.`object`.Resettable

interface KeyChangeChooser<R, K> : Resettable {
    fun toValue(value: K): R
}
