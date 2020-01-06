---
title: me.bristermitten.plumber.dsl - plumber
---

[plumber](../index.html) / [me.bristermitten.plumber.dsl](./index.html)

## Package me.bristermitten.plumber.dsl

### Types

| [ActionBuilder](-action-builder/index.html) | It's quite hard to give a simple description for this interface, other than it provides a specification for sub-classes like [PlayerActionBuilder](-player-action-builder/index.html) Generally Action Builder is used after [TaskLengthConfiguration](-task-length-configuration/index.html) in the interface flow`interface ActionBuilder<T : `[`ActionBuilder`](-action-builder/index.html)`<T>> : `[`Runnable`](https://docs.oracle.com/javase/6/docs/api/java/lang/Runnable.html)`, `[`Resettable`](../me.bristermitten.plumber.struct/-resettable/index.html) |
| [BuilderFactory](-builder-factory/index.html) | Guice Factory for creating various builder interfaces`interface BuilderFactory` |
| [DSLAspect](-d-s-l-aspect/index.html) | Aspect containing the management of all default DSL implementations`class DSLAspect : `[`AbstractAspect`](../me.bristermitten.plumber.aspect/-abstract-aspect/index.html) |
| [KeyChangeChooser](-key-change-chooser/index.html) | Interfaces that wraps watching a [DataKey](../me.bristermitten.plumber.struct.key/-data-key/index.html) for a specific value`interface KeyChangeChooser<R, K> : `[`Resettable`](../me.bristermitten.plumber.struct/-resettable/index.html) |
| [PlayerActionBuilder](-player-action-builder/index.html) | Subclass of [ActionBuilder](-action-builder/index.html) that defines various actions that a Player could do. In the default implementation, a callback is defined that is ran when any of the actions are complete`interface PlayerActionBuilder : `[`ActionBuilder`](-action-builder/index.html)`<`[`PlayerActionBuilder`](-player-action-builder/index.html)`>` |
| [TaskLengthConfiguration](-task-length-configuration/index.html) | Interface for deciding how long a task should take`interface TaskLengthConfiguration<B : `[`ActionBuilder`](-action-builder/index.html)`<*>>` |

