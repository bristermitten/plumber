---
title: PlayerActionBuilderImpl - plumber
---

[plumber](../../index.html) / [me.bristermitten.plumber.dsl.implementation](../index.html) / [PlayerActionBuilderImpl](./index.html)

# PlayerActionBuilderImpl

`class PlayerActionBuilderImpl : `[`ActionBuilderImpl`](../-action-builder-impl/index.html)`<`[`PlayerActionBuilder`](../../me.bristermitten.plumber.dsl/-player-action-builder/index.html)`>, `[`PlayerActionBuilder`](../../me.bristermitten.plumber.dsl/-player-action-builder/index.html)

### Constructors

| [&lt;init&gt;](-init-.html) | `PlayerActionBuilderImpl(player: `[`PPlayer`](../../me.bristermitten.plumber.struct.player/-p-player/index.html)`, onTrigger: `[`Runnable`](https://docs.oracle.com/javase/6/docs/api/java/lang/Runnable.html)`, factory: `[`ImplementationFactory`](../-implementation-factory/index.html)`, builderFactory: `[`BuilderFactory`](../../me.bristermitten.plumber.dsl/-builder-factory/index.html)`)` |

### Functions

| [keyChange](key-change.html) | Watch for a key change on the player`fun <K> keyChange(key: `[`DataKey`](../../me.bristermitten.plumber.struct.key/-data-key/index.html)`<K>): `[`KeyChangeChooser`](../../me.bristermitten.plumber.dsl/-key-change-chooser/index.html)`<`[`PlayerActionBuilder`](../../me.bristermitten.plumber.dsl/-player-action-builder/index.html)`, K>` |
| [playerLogout](player-logout.html) | Watch for the player to logout`fun playerLogout(): `[`PlayerActionBuilder`](../../me.bristermitten.plumber.dsl/-player-action-builder/index.html) |
| [reset](reset.html) | Reset the current data Implementation is interface specific`fun reset(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [run](run.html) | `fun run(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setKeyOnComplete](set-key-on-complete.html) | Set a Data Key when the action is complete`fun <K : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> setKeyOnComplete(key: `[`DataKey`](../../me.bristermitten.plumber.struct.key/-data-key/index.html)`<K>, value: K): `[`PlayerActionBuilder`](../../me.bristermitten.plumber.dsl/-player-action-builder/index.html) |
| [withMessageOnComplete](with-message-on-complete.html) | Set a message that will be sent when the action is complete`fun withMessageOnComplete(msg: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`PlayerActionBuilder`](../../me.bristermitten.plumber.dsl/-player-action-builder/index.html) |

