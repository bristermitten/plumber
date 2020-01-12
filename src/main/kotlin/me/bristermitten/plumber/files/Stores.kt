package me.bristermitten.plumber.files

import me.bristermitten.plumber.annotation.Unstable

@Unstable("Functional but not documented and undergoing heavy refactoring")
@StoreDelegate(HashMap::class)
interface DictionaryStore<K, T> : Store<T>, MutableMap<K, T>

@Unstable("Functional but not documented and undergoing heavy refactoring")
@StoreDelegate(ArrayList::class)
interface ObjectStore<T> : Store<T>, MutableList<T>
