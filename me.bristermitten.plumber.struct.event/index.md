---
title: me.bristermitten.plumber.struct.event - plumber
---

[plumber](../index.html) / [me.bristermitten.plumber.struct.event](./index.html)

## Package me.bristermitten.plumber.struct.event

### Types

| [EventController](-event-controller/index.html) | A wrapper for handling events that provides simple boilerplate handling Currently, only supports [Cancellable](#) instances of [PlayerEvent](#) All instances have an [EventPriority](#) of [EventPriority.NORMAL](#) For performance reasons, if no handling functionality is defined, the controller is not registered into Bukkit`interface EventController<T> : Listener where T : PlayerEvent, T : Cancellable` |
| [EventControllerFactory](-event-controller-factory/index.html) | Simple factory class for creating instances of [EventController](-event-controller/index.html) Can't use Guice because of generics, so currently stuck to [EventControllerImpl](-event-controller-impl/index.html)`class EventControllerFactory` |
| [EventControllerImpl](-event-controller-impl/index.html) | Default implementation of [EventController](-event-controller/index.html)`class EventControllerImpl<T> : `[`EventController`](-event-controller/index.html)`<T> where T : PlayerEvent, T : Cancellable` |

