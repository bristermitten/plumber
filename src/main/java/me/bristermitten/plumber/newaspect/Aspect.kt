package me.bristermitten.plumber.newaspect

import com.google.inject.Module

interface Aspect {

    fun enable(classes: Collection<Class<*>>) {}

    fun disable() {}

    fun module(): Module? = null
}
