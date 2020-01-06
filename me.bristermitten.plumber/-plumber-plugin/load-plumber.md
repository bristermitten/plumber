---
title: PlumberPlugin.loadPlumber - plumber
---

[plumber](../../index.html) / [me.bristermitten.plumber](../index.html) / [PlumberPlugin](index.html) / [loadPlumber](./load-plumber.html)

# loadPlumber

`protected fun loadPlumber(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Load the framework.
This entails scanning classes in the classpath, creating instances and injectors
through Guice, and loading all necessary aspects.
This should be called before anything else in [onEnable](on-enable.html)

