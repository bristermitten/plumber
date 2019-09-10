package me.bristermitten.plumber.struct.builder

interface KeyChangeChooser<R, K> {
    fun toValue(value: K): R
}
