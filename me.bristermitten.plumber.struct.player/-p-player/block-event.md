---
title: PPlayer.blockEvent - plumber
---

[plumber](../../index.html) / [me.bristermitten.plumber.struct.player](../index.html) / [PPlayer](index.html) / [blockEvent](./block-event.html)

# blockEvent

`abstract fun <T> blockEvent(e: `[`Class`](https://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<T>): `[`TaskLengthConfiguration`](../../me.bristermitten.plumber.dsl/-task-length-configuration/index.html)`<`[`PlayerActionBuilder`](../../me.bristermitten.plumber.dsl/-player-action-builder/index.html)`> where T : `[`PlayerEvent`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/player/PlayerEvent.html)`, T : `[`Cancellable`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/Cancellable.html)

Block a certain event class until a given condition is complete (if any)

### Parameters

`e` - the class to block

**Parameters**

**Return**
a [TaskLengthConfiguration](../../me.bristermitten.plumber.dsl/-task-length-configuration/index.html) for configuring the blocking

