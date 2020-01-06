---
title: AbstractAspect - plumber
---

[plumber](../../index.html) / [me.bristermitten.plumber.aspect](../index.html) / [AbstractAspect](./index.html)

# AbstractAspect

`abstract class AbstractAspect : `[`Aspect`](../-aspect/index.html)

Boilerplate-handling abstract implementation of [Aspect](../-aspect/index.html)
Provides logging, enabled-status handling, and a wrapper for Guice's [Injector](https://google.github.io/guice/api-docs/latest/javadoc/com/google/inject/Injector.html)

### Constructors

| [&lt;init&gt;](-init-.html) | Boilerplate-handling abstract implementation of [Aspect](../-aspect/index.html) Provides logging, enabled-status handling, and a wrapper for Guice's [Injector](https://google.github.io/guice/api-docs/latest/javadoc/com/google/inject/Injector.html)`AbstractAspect()` |

### Properties

| [classes](classes.html) | `lateinit var classes: `[`Collection`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)`<`[`Class`](https://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<*>>` |
| [logger](logger.html) | `val logger: Logger` |

### Functions

| [disable](disable.html) | Disable the Aspect. Called internally and only once: server shutdown. Often not needed, but some aspects may want to use this to flush data or similar operations.`open fun disable(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [doDisable](do-disable.html) | `open fun doDisable(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [doEnable](do-enable.html) | `open fun doEnable(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [enable](enable.html) | Enable the Aspect. This is called internally and only once: on server startup.`open fun enable(classes: `[`Collection`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)`<`[`Class`](https://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<*>>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [getModule](get-module.html) | Provide an optional Guice module to be installed. This is called *after* instantiation of the Aspect so nothing from this module can be used in the Aspect.`open fun getModule(): `[`Module`](https://google.github.io/guice/api-docs/latest/javadoc/com/google/inject/Module.html)`?` |
| [instance](instance.html) | `fun <T> instance(clazz: `[`Class`](https://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<T>): T` |

### Inheritors

| [CommandAspect](../../me.bristermitten.plumber.command/-command-aspect/index.html) | Internal aspect that handles the scanning of command classes, and the registration of such classes`class CommandAspect : `[`AbstractAspect`](./index.html) |
| [ComponentAspect](../../me.bristermitten.plumber.aspect.component/-component-aspect/index.html) | Required Aspect that facilitates the injection of all [Component](../../me.bristermitten.plumber.aspect.component/-component/index.html) classes They are bound as eager singletons`class ComponentAspect : `[`AbstractAspect`](./index.html) |
| [DSLAspect](../../me.bristermitten.plumber.dsl/-d-s-l-aspect/index.html) | Aspect containing the management of all default DSL implementations`class DSLAspect : `[`AbstractAspect`](./index.html) |
| [FilesAspect](../../me.bristermitten.plumber.files/-files-aspect/index.html) | `class FilesAspect : `[`AbstractAspect`](./index.html) |
| [SchedulerAspect](../../me.bristermitten.plumber.scheduling/-scheduler-aspect/index.html) | Aspect that handles the scheduler related functionality of Plumber Currently, all it does is installs the required Assisted Injection factories`class SchedulerAspect : `[`AbstractAspect`](./index.html) |

