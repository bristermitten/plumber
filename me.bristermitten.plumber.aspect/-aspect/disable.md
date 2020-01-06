---
title: Aspect.disable - plumber
---

[plumber](../../index.html) / [me.bristermitten.plumber.aspect](../index.html) / [Aspect](index.html) / [disable](./disable.html)

# disable

`abstract fun disable(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Disable the Aspect.
Called internally and only once: server shutdown.
Often not needed, but some aspects may want to use this to flush data or similar operations.

//TODO Ensure that all classes will still be loaded when this is called

