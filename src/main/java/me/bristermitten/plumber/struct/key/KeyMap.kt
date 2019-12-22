package me.bristermitten.plumber.struct.key

import java.util.*

/**
 * Simple delegate of [HashMap] with generics overridden
 */
class KeyMap : MutableMap<DataKey<*>, Any > by HashMap()
