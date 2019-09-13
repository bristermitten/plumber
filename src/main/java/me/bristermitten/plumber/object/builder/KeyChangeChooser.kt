package me.bristermitten.plumber.`object`.builder

interface KeyChangeChooser<R, K> {
    fun toValue(value: K): R
}
