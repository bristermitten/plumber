---
title: Resettable - plumber
---

[plumber](../../index.html) / [me.bristermitten.plumber.struct](../index.html) / [Resettable](./index.html)

# Resettable

`@Unstable("The future of this interface is not yet decided, and it may be removed due to lack of usefulness or creating convoluted implementations") interface Resettable`

Indicates that something can be reset

### Functions

| [reset](reset.html) | Reset the current data Implementation is interface specific`abstract fun reset(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| [ActionBuilder](../../me.bristermitten.plumber.dsl/-action-builder/index.html) | It's quite hard to give a simple description for this interface, other than it provides a specification for sub-classes like [PlayerActionBuilder](../../me.bristermitten.plumber.dsl/-player-action-builder/index.html) Generally Action Builder is used after [TaskLengthConfiguration](../../me.bristermitten.plumber.dsl/-task-length-configuration/index.html) in the interface flow`interface ActionBuilder<T : `[`ActionBuilder`](../../me.bristermitten.plumber.dsl/-action-builder/index.html)`<T>> : `[`Runnable`](https://docs.oracle.com/javase/6/docs/api/java/lang/Runnable.html)`, `[`Resettable`](./index.html) |
| [KeyChangeChooser](../../me.bristermitten.plumber.dsl/-key-change-chooser/index.html) | Interfaces that wraps watching a [DataKey](../../me.bristermitten.plumber.struct.key/-data-key/index.html) for a specific value`interface KeyChangeChooser<R, K> : `[`Resettable`](./index.html) |
| [Task](../../me.bristermitten.plumber.scheduling/-task/index.html) | A Task wraps Bukkit's Scheduler system into a single object. Currently, all tasks are ran asynchronously, but this will be improved in the future.`class Task : `[`Runnable`](https://docs.oracle.com/javase/6/docs/api/java/lang/Runnable.html)`, `[`Resettable`](./index.html) |

