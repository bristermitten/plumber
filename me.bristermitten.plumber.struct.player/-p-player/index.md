---
title: PPlayer - plumber
---

[plumber](../../index.html) / [me.bristermitten.plumber.struct.player](../index.html) / [PPlayer](./index.html)

# PPlayer

`interface PPlayer : `[`KeyHolder`](../../me.bristermitten.plumber.struct.key/-key-holder/index.html)`, `[`Extendable`](../../me.bristermitten.plumber.struct.extension/-extendable/index.html)`<`[`PPlayer`](./index.html)`, `[`PlayerExtension`](../-player-extension.html)`>`

Plumber wrapper for the [Player](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html) class
Allows lots of boilerplate on Players do be done easily

Instances can be obtained from [PPlayerManager](../-p-player-manager/index.html) if necessary,
otherwise it's advised to use events or command injection, rather than storing
and manually obtaining instances.

Per online player, one [PPlayer](./index.html) instance exists. As with Bukkit's Player,
this will be removed from storage if the player logs out,
so it's advised not to store instances if possible, as they will not be able to be
garbage collected otherwise. If necessary, weak references are advised

### Functions

| [blockEvent](block-event.html) | Block a certain event class until a given condition is complete (if any)`abstract fun <T> blockEvent(e: `[`Class`](https://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<T>): `[`TaskLengthConfiguration`](../../me.bristermitten.plumber.dsl/-task-length-configuration/index.html)`<`[`PlayerActionBuilder`](../../me.bristermitten.plumber.dsl/-player-action-builder/index.html)`> where T : `[`PlayerEvent`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/player/PlayerEvent.html)`, T : `[`Cancellable`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/Cancellable.html) |
| [message](message.html) | Send a message to the player. The String will be colored for Bukkit color codes`abstract fun message(msg: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [player](player.html) | `abstract fun player(): `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html) |

