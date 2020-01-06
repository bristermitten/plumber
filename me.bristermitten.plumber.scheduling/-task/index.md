---
title: Task - plumber
---

[plumber](../../index.html) / [me.bristermitten.plumber.scheduling](../index.html) / [Task](./index.html)

# Task

`class Task : `[`Runnable`](https://docs.oracle.com/javase/6/docs/api/java/lang/Runnable.html)`, `[`Resettable`](../../me.bristermitten.plumber.struct/-resettable/index.html)

A Task wraps Bukkit's Scheduler system into a single object.
Currently, all tasks are ran asynchronously, but this will be improved in the future.

Generally, all Tasks are created with [TaskFactory](../-task-factory/index.html)

### Constructors

| [&lt;init&gt;](-init-.html) | `Task(plugin: `[`PlumberPlugin`](../../me.bristermitten.plumber/-plumber-plugin/index.html)`, delay: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, period: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, delegate: `[`Runnable`](https://docs.oracle.com/javase/6/docs/api/java/lang/Runnable.html)`)`<br>`Task(plugin: `[`PlumberPlugin`](../../me.bristermitten.plumber/-plumber-plugin/index.html)`, delay: `[`Time`](../../me.bristermitten.plumber.scheduling.timings/-time/index.html)`, period: `[`Time`](../../me.bristermitten.plumber.scheduling.timings/-time/index.html)`, delegate: `[`Runnable`](https://docs.oracle.com/javase/6/docs/api/java/lang/Runnable.html)`)` |

### Functions

| [reset](reset.html) | Reset the current data Implementation is interface specific`fun reset(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [run](run.html) | `fun run(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [start](start.html) | `fun start(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [stop](stop.html) | `fun stop(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

