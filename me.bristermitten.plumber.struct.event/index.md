---
title: me.bristermitten.plumber.struct.event - plumber
---

[plumber](../index.html) / [me.bristermitten.plumber.struct.event](./index.html)

## Package me.bristermitten.plumber.struct.event

### Types

| [EventController](-event-controller/index.html) | A wrapper for handling events that provides simple boilerplate handling Currently, only supports [Cancellable](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/Cancellable.html) instances of [PlayerEvent](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/player/PlayerEvent.html) All instances have an [EventPriority](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/EventPriority.html) of [EventPriority.NORMAL](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/EventPriority.html#NORMAL) For performance reasons, if no handling functionality is defined, the controller is not registered into Bukkit`interface EventController<T> : `[`Listener`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/Listener.html)` where T : `[`PlayerEvent`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/player/PlayerEvent.html)`, T : `[`Cancellable`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/Cancellable.html) |
| [EventControllerFactory](-event-controller-factory/index.html) | Simple factory class for creating instances of [EventController](-event-controller/index.html) Can't use Guice because of generics, so currently stuck to [EventControllerImpl](-event-controller-impl/index.html)`class EventControllerFactory` |
| [EventControllerImpl](-event-controller-impl/index.html) | Default implementation of [EventController](-event-controller/index.html)`class EventControllerImpl<T> : `[`EventController`](-event-controller/index.html)`<T> where T : `[`PlayerEvent`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/player/PlayerEvent.html)`, T : `[`Cancellable`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/Cancellable.html) |

