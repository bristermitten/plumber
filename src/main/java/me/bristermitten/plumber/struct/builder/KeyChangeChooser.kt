package me.bristermitten.plumber.struct.builder

import me.bristermitten.plumber.struct.Resettable

interface KeyChangeChooser<R, K> : Resettable {
    fun toValue(value: K): R
}
