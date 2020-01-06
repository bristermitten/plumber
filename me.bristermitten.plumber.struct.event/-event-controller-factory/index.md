---
title: EventControllerFactory - plumber
---

[plumber](../../index.html) / [me.bristermitten.plumber.struct.event](../index.html) / [EventControllerFactory](./index.html)

# EventControllerFactory

`class EventControllerFactory`

Simple factory class for creating instances of [EventController](../-event-controller/index.html)
Can't use Guice because of generics, so currently stuck to [EventControllerImpl](../-event-controller-impl/index.html)

### Constructors

| [&lt;init&gt;](-init-.html) | Simple factory class for creating instances of [EventController](../-event-controller/index.html) Can't use Guice because of generics, so currently stuck to [EventControllerImpl](../-event-controller-impl/index.html)`EventControllerFactory(plugin: `[`PlumberPlugin`](../../me.bristermitten.plumber/-plumber-plugin/index.html)`)` |

### Functions

| [createController](create-controller.html) | `fun <T> createController(clazz: `[`Class`](https://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<T>): `[`EventController`](../-event-controller/index.html)`<T> where T : `[`PlayerEvent`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/player/PlayerEvent.html)`, T : `[`Cancellable`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/Cancellable.html) |

