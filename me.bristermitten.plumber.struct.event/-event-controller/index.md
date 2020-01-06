---
title: EventController - plumber
---

[plumber](../../index.html) / [me.bristermitten.plumber.struct.event](../index.html) / [EventController](./index.html)

# EventController

`interface EventController<T> : Listener where T : PlayerEvent, T : Cancellable`

A wrapper for handling events that provides simple boilerplate handling
Currently, only supports [Cancellable](#) instances of [PlayerEvent](#)
All instances have an [EventPriority](#) of [EventPriority.NORMAL](#)
For performance reasons, if no handling functionality is defined, the controller is not registered into Bukkit

**Parameters**

### Functions

| [cancelAll](cancel-all.html) | Cancel all instances of the event by calling [Cancellable.setCancelled](#)`abstract fun cancelAll(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [cancelIf](cancel-if.html) | Cancel any instance of the event if a certain predicate is fulfilled.`abstract fun cancelIf(predicate: Predicate<T>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [ignoreAll](ignore-all.html) | Ignore all instances of the event. For performance reasons, this is equivalent to calling [EventController.unRegister](un-register.html)`abstract fun ignoreAll(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [unRegister](un-register.html) | Unregister the controller, causing all handling to be undone. This may be called internally for performance reasons`abstract fun unRegister(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| [EventControllerImpl](../-event-controller-impl/index.html) | Default implementation of [EventController](./index.html)`class EventControllerImpl<T> : `[`EventController`](./index.html)`<T> where T : PlayerEvent, T : Cancellable` |

