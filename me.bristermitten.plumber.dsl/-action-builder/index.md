---
title: ActionBuilder - plumber
---

[plumber](../../index.html) / [me.bristermitten.plumber.dsl](../index.html) / [ActionBuilder](./index.html)

# ActionBuilder

`interface ActionBuilder<T : `[`ActionBuilder`](./index.html)`<T>> : `[`Runnable`](https://docs.oracle.com/javase/6/docs/api/java/lang/Runnable.html)`, `[`Resettable`](../../me.bristermitten.plumber.struct/-resettable/index.html)

It's quite hard to give a simple description for this interface, other than it provides
a specification for sub-classes like [PlayerActionBuilder](../-player-action-builder/index.html)
Generally Action Builder is used after [TaskLengthConfiguration](../-task-length-configuration/index.html) in the interface flow

### Parameters

`T` - the action builder's own type, so that any functions can return a child interface with the right parent type

### Functions

| [or](or.html) | Returns the parent object for further configuration`abstract fun or(): `[`TaskLengthConfiguration`](../-task-length-configuration/index.html)`<T>` |

### Inheritors

| [ActionBuilderImpl](../../me.bristermitten.plumber.dsl.implementation/-action-builder-impl/index.html) | Simple implementation of [ActionBuilder](./index.html) that holds a parent [TaskLengthConfiguration](../-task-length-configuration/index.html)`abstract class ActionBuilderImpl<T : `[`ActionBuilder`](./index.html)`<T>> : `[`ActionBuilder`](./index.html)`<T>` |
| [PlayerActionBuilder](../-player-action-builder/index.html) | Subclass of [ActionBuilder](./index.html) that defines various actions that a Player could do. In the default implementation, a callback is defined that is ran when any of the actions are complete`interface PlayerActionBuilder : `[`ActionBuilder`](./index.html)`<`[`PlayerActionBuilder`](../-player-action-builder/index.html)`>` |

