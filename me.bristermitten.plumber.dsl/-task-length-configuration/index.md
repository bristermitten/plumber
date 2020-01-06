---
title: TaskLengthConfiguration - plumber
---

[plumber](../../index.html) / [me.bristermitten.plumber.dsl](../index.html) / [TaskLengthConfiguration](./index.html)

# TaskLengthConfiguration

`interface TaskLengthConfiguration<B : `[`ActionBuilder`](../-action-builder/index.html)`<*>>`

Interface for deciding how long a task should take

### Parameters

`B` - the child interface for later configuration

### Functions

| [forever](forever.html) | Do the task forever`abstract fun forever(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [undoAfter](undo-after.html) | Undo the task (if applicable) after a certain length of time`abstract fun undoAfter(time: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`TimeUnitPicker`](../../me.bristermitten.plumber.scheduling.timings/-time-unit-picker/index.html)`<B>` |
| [until](until.html) | Do the task until certain conditions are met, at which point it will be cancelled/undone depending on the task`abstract fun until(): B` |

### Companion Object Properties

| [impl](impl.html) | `var impl: `[`Class`](https://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<out `[`TaskLengthConfiguration`](./index.html)`<*>>` |

### Inheritors

| [DefaultTaskLengthConfiguration](../../me.bristermitten.plumber.dsl.implementation/-default-task-length-configuration/index.html) | `open class DefaultTaskLengthConfiguration<B : `[`ActionBuilder`](../-action-builder/index.html)`<B>> : `[`TaskLengthConfiguration`](./index.html)`<B>` |

