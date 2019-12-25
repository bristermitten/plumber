package me.bristermitten.plumber.files

interface KeyValueStore<K, T> : Store<T>, MutableMap<K, T>

interface ValueStore<T> : Store<T>, MutableList<T>
