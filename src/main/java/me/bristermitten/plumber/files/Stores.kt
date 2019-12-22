package me.bristermitten.plumber.files

interface ValueStore<T>: Store<T>, MutableList<T>

interface KeyValueStore<K, T>: Store<T>, MutableMap<K, T>
