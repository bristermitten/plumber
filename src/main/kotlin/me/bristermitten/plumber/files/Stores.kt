package me.bristermitten.plumber.files

import me.bristermitten.plumber.annotation.Unstable

@Unstable("Functional but not documented and undergoing heavy refactoring")
interface KeyValueStore<K, T> : Store<T>, MutableMap<K, T>
@Unstable("Functional but not documented and undergoing heavy refactoring")
interface ValueStore<T> : Store<T>, MutableList<T>
