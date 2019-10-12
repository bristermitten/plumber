package me.bristermitten.plumber.aspect

import com.google.inject.Module

interface Aspect {
    fun enable()
    fun disable()

    fun module(): Module? = null
}
