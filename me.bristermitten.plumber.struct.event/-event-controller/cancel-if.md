---
title: EventController.cancelIf - plumber
---

[plumber](../../index.html) / [me.bristermitten.plumber.struct.event](../index.html) / [EventController](index.html) / [cancelIf](./cancel-if.html)

# cancelIf

`abstract fun cancelIf(predicate: Predicate<T>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Cancel any instance of the event if a certain predicate is fulfilled.

### Parameters

`predicate` - the predicate to determine if the event is cancelled or not