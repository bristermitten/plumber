package me.bristermitten.plumber.files.store

import me.bristermitten.plumber.annotation.Unstable

@Unstable("Functional but not documented and undergoing heavy refactoring")
interface Store<T> {
    fun flush()

    fun reload()

    fun loadWith(data: Any)

    fun save(t: T)
}

