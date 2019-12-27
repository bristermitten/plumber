package me.bristermitten.plumber.newaspect

import com.google.inject.Module

interface Aspect {

    fun enable()

    fun disable()

    fun module() : Module?
}
