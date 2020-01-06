---
title: RequiredAspect.<init> - plumber
---

[plumber](../../index.html) / [me.bristermitten.plumber.aspect](../index.html) / [RequiredAspect](index.html) / [&lt;init&gt;](./-init-.html)

# &lt;init&gt;

`RequiredAspect(priority: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0)`

Only applicable to subclasses of [Aspect](../-aspect/index.html).

This annotation indicates that an Aspect is required and must always be loaded.
It should be used sparingly.

Required Aspects will be loaded before non-required Aspects.

### Parameters

`priority` - The priority for loading in relation to other required Aspects. Higher priorities load first.