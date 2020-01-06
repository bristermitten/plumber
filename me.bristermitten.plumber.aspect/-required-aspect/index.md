---
title: RequiredAspect - plumber
---

[plumber](../../index.html) / [me.bristermitten.plumber.aspect](../index.html) / [RequiredAspect](./index.html)

# RequiredAspect

`@Target([AnnotationTarget.CLASS]) annotation class RequiredAspect`

Only applicable to subclasses of [Aspect](../-aspect/index.html).

This annotation indicates that an Aspect is required and must always be loaded.
It should be used sparingly.

Required Aspects will be loaded before non-required Aspects.

### Parameters

`priority` - The priority for loading in relation to other required Aspects. Higher priorities load first.

### Constructors

| [&lt;init&gt;](-init-.html) | Only applicable to subclasses of [Aspect](../-aspect/index.html).`RequiredAspect(priority: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0)` |

### Properties

| [priority](priority.html) | The priority for loading in relation to other required Aspects. Higher priorities load first.`val priority: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |

