---
title: Aspect - plumber
---

[plumber](../../index.html) / [me.bristermitten.plumber.aspect](../index.html) / [Aspect](./index.html)

# Aspect

`interface Aspect`

A section of Plumber's functionality, for example, command handling or file management
An Aspect should be considered the parent of this section, and manage dependency injection and initial setup

Aspects are considered singletons and will only be internally instantiated once.

Instances are created with Guice, so [Inject](#) can be used.
However, bear in mind that injection will occur before [getModule](get-module.html)
is called, and so an Aspect cannot be injected with bindings in its [getModule](get-module.html) return value

If you need to make bindings and then inject into your aspect, use the annotation [StaticModule](../-static-module/index.html),
which defines a module that will be installed before Aspect creation.
A module can still be returned from [getModule](get-module.html), however the same conditions apply.

On its own, an aspect will not automatically be loaded to reduce startup time.
Instead, it must be given a "reason" to load. This can be one or multiple of 3 things:

1. Annotating the class with [RequiredAspect](../-required-aspect/index.html), which ensures it will always be loaded
2. Any [AspectAnnotation](../-aspect-annotation/index.html)s that target this aspect being present anywhere on the classpath
3. Annotating the class with [LoadIfPresent](../-load-if-present/index.html) to load the aspect if a given annotation is present
anywhere on the classpath

**Author**
Alexander Wood (knightzmc)

### Functions

| [disable](disable.html) | Disable the Aspect. Called internally and only once: server shutdown. Often not needed, but some aspects may want to use this to flush data or similar operations.`abstract fun disable(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [enable](enable.html) | Enable the Aspect. This is called internally and only once: on server startup.`abstract fun enable(classes: `[`Collection`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)`<`[`Class`](https://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<*>>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [getModule](get-module.html) | Provide an optional Guice module to be installed. This is called *after* instantiation of the Aspect so nothing from this module can be used in the Aspect.`abstract fun getModule(): Module?` |

### Inheritors

| [AbstractAspect](../-abstract-aspect/index.html) | Boilerplate-handling abstract implementation of [Aspect](./index.html) Provides logging, enabled-status handling, and a wrapper for Guice's [Injector](#)`abstract class AbstractAspect : `[`Aspect`](./index.html) |

