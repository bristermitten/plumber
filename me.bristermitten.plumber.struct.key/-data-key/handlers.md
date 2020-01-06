---
title: DataKey.handlers - plumber
---

[plumber](../../index.html) / [me.bristermitten.plumber.struct.key](../index.html) / [DataKey](index.html) / [handlers](./handlers.html)

# handlers

`val handlers: `[`KeySetView`](https://docs.oracle.com/javase/6/docs/api/java/util/concurrent/ConcurrentHashMap/KeySetView.html)`<Consumer<T>!, `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`!>`

List of Handlers for when the key's value is updated.
These are not actually handled in the Key object, and instead should be called inside
classes that implement [KeyHolder](../-key-holder/index.html) or hold instances of [DataKey](index.html)
For example, in [PPlayer.setData](exec-handlers.html) is called every time the key's data is updated.

This approach avoids having to store the current value in a [DataKey](index.html), fulfilling the idea of it being a key only,
whereas the value is stored in entities.

