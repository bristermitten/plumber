---
title: DefaultTaskLengthConfiguration - plumber
---

[plumber](../../index.html) / [me.bristermitten.plumber.dsl.implementation](../index.html) / [DefaultTaskLengthConfiguration](./index.html)

# DefaultTaskLengthConfiguration

`open class DefaultTaskLengthConfiguration<B : `[`ActionBuilder`](../../me.bristermitten.plumber.dsl/-action-builder/index.html)`<B>> : `[`TaskLengthConfiguration`](../../me.bristermitten.plumber.dsl/-task-length-configuration/index.html)`<B>`

### Constructors

| [&lt;init&gt;](-init-.html) | `DefaultTaskLengthConfiguration(value: B, factory: `[`TimeUnitPickerFactory`](../../me.bristermitten.plumber.scheduling.timings/-time-unit-picker-factory/index.html)`, taskFactory: `[`TaskFactory`](../../me.bristermitten.plumber.scheduling/-task-factory/index.html)`)` |

### Functions

| [forever](forever.html) | Do the task forever`open fun forever(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [undoAfter](undo-after.html) | Undo the task (if applicable) after a certain length of time`open fun undoAfter(time: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`TimeUnitPicker`](../../me.bristermitten.plumber.scheduling.timings/-time-unit-picker/index.html)`<B>` |
| [until](until.html) | Do the task until certain conditions are met, at which point it will be cancelled/undone depending on the task`open fun until(): B` |

### Inheritors

| [PlayerTaskLengthConfiguration](../-player-task-length-configuration/index.html) | `class PlayerTaskLengthConfiguration : `[`DefaultTaskLengthConfiguration`](./index.html)`<`[`PlayerActionBuilder`](../../me.bristermitten.plumber.dsl/-player-action-builder/index.html)`>` |

