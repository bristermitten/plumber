---
title: TaskBuilder - plumber
---

[plumber](../../index.html) / [me.bristermitten.plumber.scheduling.timings](../index.html) / [TaskBuilder](./index.html)

# TaskBuilder

`interface TaskBuilder`

Builder for configuring times in the future for scheduling
This can be safely injected

### Functions

| [build](build.html) | Create a new Task from this Builder`abstract fun build(): `[`Task`](../../me.bristermitten.plumber.scheduling/-task/index.html) |
| [doing](doing.html) | Set the functionality for this Task`abstract fun doing(r: `[`Runnable`](https://docs.oracle.com/javase/6/docs/api/java/lang/Runnable.html)`): `[`TaskBuilder`](./index.html) |
| [every](every.html) | Define a repeating period in which the task is executed`abstract fun every(period: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`TimeUnitPicker`](../-time-unit-picker/index.html)`<`[`TaskBuilder`](./index.html)`>` |
| [in](in.html) | Define an initial delay for the task.`abstract fun in(wait: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`TimeUnitPicker`](../-time-unit-picker/index.html)`<`[`TaskBuilder`](./index.html)`>` |

### Companion Object Properties

| [impl](impl.html) | Default implementation, can be customised to change what Guice uses when creating instances`val impl: `[`Class`](https://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<out `[`TaskBuilder`](./index.html)`>` |

