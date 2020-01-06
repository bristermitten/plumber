---
title: EventController - plumber
---

[plumber](../../index.html) / [me.bristermitten.plumber.struct.event](../index.html) / [EventController](./index.html)

# EventController

`interface EventController<T> : `[`Listener`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/Listener.html)` where T : `[`PlayerEvent`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/player/PlayerEvent.html)`, T : `[`Cancellable`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/Cancellable.html)

A wrapper for handling events that provides simple boilerplate handling
Currently, only supports [Cancellable](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/Cancellable.html) instances of [PlayerEvent](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/player/PlayerEvent.html)
All instances have an [EventPriority](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/EventPriority.html) of [EventPriority.NORMAL](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/EventPriority.html#NORMAL)
For performance reasons, if no handling functionality is defined, the controller is not registered into Bukkit

**Parameters**

### Functions

| [cancelAll](cancel-all.html) | Cancel all instances of the event by calling [Cancellable.setCancelled](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/Cancellable.html#setCancelled(boolean))`abstract fun cancelAll(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [cancelIf](cancel-if.html) | Cancel any instance of the event if a certain predicate is fulfilled.`abstract fun cancelIf(predicate: Predicate<T>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [ignoreAll](ignore-all.html) | Ignore all instances of the event. For performance reasons, this is equivalent to calling [EventController.unRegister](un-register.html)`abstract fun ignoreAll(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [unRegister](un-register.html) | Unregister the controller, causing all handling to be undone. This may be called internally for performance reasons`abstract fun unRegister(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| [EventControllerImpl](../-event-controller-impl/index.html) | Default implementation of [EventController](./index.html)`class EventControllerImpl<T> : `[`EventController`](./index.html)`<T> where T : `[`PlayerEvent`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/player/PlayerEvent.html)`, T : `[`Cancellable`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/Cancellable.html) |

