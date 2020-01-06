---
title: EventControllerImpl - plumber
---

[plumber](../../index.html) / [me.bristermitten.plumber.struct.event](../index.html) / [EventControllerImpl](./index.html)

# EventControllerImpl

`class EventControllerImpl<T> : `[`EventController`](../-event-controller/index.html)`<T> where T : PlayerEvent, T : Cancellable`

Default implementation of [EventController](../-event-controller/index.html)

**Parameters**

### Constructors

| [&lt;init&gt;](-init-.html) | Default implementation of [EventController](../-event-controller/index.html)`EventControllerImpl(plugin: `[`PlumberPlugin`](../../me.bristermitten.plumber/-plumber-plugin/index.html)`, clazz: `[`Class`](https://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<T>)` |

### Functions

| [cancelAll](cancel-all.html) | Cancel all instances of the event by calling [Cancellable.setCancelled](#)`fun cancelAll(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [cancelIf](cancel-if.html) | Cancel any instance of the event if a certain predicate is fulfilled.`fun cancelIf(predicate: Predicate<T>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [ignoreAll](ignore-all.html) | Ignore all instances of the event. For performance reasons, this is equivalent to calling [EventController.unRegister](../-event-controller/un-register.html)`fun ignoreAll(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [unRegister](un-register.html) | Unregister the controller, causing all handling to be undone. This may be called internally for performance reasons`fun unRegister(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

