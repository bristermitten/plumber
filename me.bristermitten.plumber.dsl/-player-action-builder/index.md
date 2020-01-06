---
title: PlayerActionBuilder - plumber
---

[plumber](../../index.html) / [me.bristermitten.plumber.dsl](../index.html) / [PlayerActionBuilder](./index.html)

# PlayerActionBuilder

`interface PlayerActionBuilder : `[`ActionBuilder`](../-action-builder/index.html)`<`[`PlayerActionBuilder`](./index.html)`>`

Subclass of [ActionBuilder](../-action-builder/index.html) that defines various actions that a Player could do.
In the default implementation, a callback is defined that is ran when any of the actions are complete

### Functions

| [keyChange](key-change.html) | Watch for a key change on the player`abstract fun <K> keyChange(key: `[`DataKey`](../../me.bristermitten.plumber.struct.key/-data-key/index.html)`<K>): `[`KeyChangeChooser`](../-key-change-chooser/index.html)`<`[`PlayerActionBuilder`](./index.html)`, K>` |
| [playerLogout](player-logout.html) | Watch for the player to logout`abstract fun playerLogout(): `[`PlayerActionBuilder`](./index.html) |
| [setKeyOnComplete](set-key-on-complete.html) | Set a Data Key when the action is complete`abstract fun <K : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> setKeyOnComplete(key: `[`DataKey`](../../me.bristermitten.plumber.struct.key/-data-key/index.html)`<K>, value: K): `[`PlayerActionBuilder`](./index.html) |
| [withMessageOnComplete](with-message-on-complete.html) | Set a message that will be sent when the action is complete`abstract fun withMessageOnComplete(msg: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`PlayerActionBuilder`](./index.html) |

### Companion Object Properties

| [impl](impl.html) | `var impl: `[`Class`](https://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<out `[`PlayerActionBuilder`](./index.html)`>` |

### Inheritors

| [PlayerActionBuilderImpl](../../me.bristermitten.plumber.dsl.implementation/-player-action-builder-impl/index.html) | `class PlayerActionBuilderImpl : `[`ActionBuilderImpl`](../../me.bristermitten.plumber.dsl.implementation/-action-builder-impl/index.html)`<`[`PlayerActionBuilder`](./index.html)`>, `[`PlayerActionBuilder`](./index.html) |

