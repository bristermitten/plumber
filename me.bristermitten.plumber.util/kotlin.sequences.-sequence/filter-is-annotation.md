---
title: filterIsAnnotation - plumber
---

[plumber](../../index.html) / [me.bristermitten.plumber.util](../index.html) / [kotlin.sequences.Sequence](index.html) / [filterIsAnnotation](./filter-is-annotation.html)

# filterIsAnnotation

`fun `[`Sequence`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.sequences/-sequence/index.html)`<`[`Class`](https://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<*>>.filterIsAnnotation(): `[`Sequence`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.sequences/-sequence/index.html)`<`[`Class`](https://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<out `[`Annotation`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-annotation/index.html)`>>`

[Sequence](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.sequences/-sequence/index.html) extension to filter that all of the elements in a Sequence of [Class](https://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)es
are [Class.isAnnotation](https://docs.oracle.com/javase/6/docs/api/java/lang/Class.html#isAnnotation())
This then casts to the implied contract
TODO Iterable extension as well

