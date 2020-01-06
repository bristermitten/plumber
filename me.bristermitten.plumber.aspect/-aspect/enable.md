---
title: Aspect.enable - plumber
---

[plumber](../../index.html) / [me.bristermitten.plumber.aspect](../index.html) / [Aspect](index.html) / [enable](./enable.html)

# enable

`abstract fun enable(classes: `[`Collection`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)`<`[`Class`](https://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<*>>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Enable the Aspect. This is called internally and only once: on server startup.

### Parameters

`classes` - Classes considered to be "part" of this Aspect. This includes classes with an
[AspectAnnotation](../-aspect-annotation/index.html) targeting this aspect, or with any [LoadIfPresent.targets](../-load-if-present/targets.html)