---
title: TimeUnitPicker - plumber
---

[plumber](../../index.html) / [me.bristermitten.plumber.scheduling.timings](../index.html) / [TimeUnitPicker](./index.html)

# TimeUnitPicker

`interface TimeUnitPicker<T>`

A TimeUnitPicker allows developers to choose a time unit for an action.
General best practice is to have the method that returns a TimeUnitPicker
take a long for the amount of time, for example
`
PPlayer#blockEvent(PlayerMoveEvent.class).undoAfter(30).seconds()
` *

**Parameters**

### Functions

| [days](days.html) | Pick days, where 1/86400 days are in a second`abstract fun days(): T` |
| [hours](hours.html) | Pick hours, where 1/3600 hours are in a second`abstract fun hours(): T` |
| [milliseconds](milliseconds.html) | Pick milliseconds, where 1000 milliseconds are in a second`abstract fun milliseconds(): T` |
| [minutes](minutes.html) | Pick minutes, where 1/60 minutes are in a second`abstract fun minutes(): T` |
| [seconds](seconds.html) | Pick seconds, where 1 second is in a second`abstract fun seconds(): T` |
| [ticks](ticks.html) | Pick ticks, where 20 ticks are in a second`abstract fun ticks(): T` |

### Companion Object Properties

| [impl](impl.html) | The default implementation for this class. Currently unused but theoretically used for customising Guice assisted injection factories`val impl: `[`Class`](https://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<out `[`TimeUnitPicker`](./index.html)`<*>>` |

