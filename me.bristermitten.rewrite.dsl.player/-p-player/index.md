---
title: PPlayer - plumber
---

[plumber](../../index.html) / [me.bristermitten.rewrite.dsl.player](../index.html) / [PPlayer](./index.html)

# PPlayer

`interface PPlayer : `[`PlumberEntity`](../../me.bristermitten.rewrite.dsl.core/-plumber-entity/index.html)`<`[`PPlayer`](./index.html)`, `[`PlayerActionFilter`](../-player-action-filter/index.html)`, `[`PlayerReactorPicker`](../-player-reactor-picker/index.html)`>`

### Functions

| [blockEvent](block-event.html) | `abstract fun <T> blockEvent(clazz: `[`Class`](https://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<T>): `[`LengthConfiguration`](../../me.bristermitten.rewrite.dsl.core/-length-configuration/index.html)`<`[`PlayerActionFilter`](../-player-action-filter/index.html)`, `[`PlayerReactorPicker`](../-player-reactor-picker/index.html)`> where T : `[`PlayerEvent`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/player/PlayerEvent.html)`, T : `[`Cancellable`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/Cancellable.html)<br>`abstract fun <T> blockEvent(clazz: `[`KClass`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html)`<T>): `[`LengthConfiguration`](../../me.bristermitten.rewrite.dsl.core/-length-configuration/index.html)`<`[`PlayerActionFilter`](../-player-action-filter/index.html)`, `[`PlayerReactorPicker`](../-player-reactor-picker/index.html)`> where T : `[`PlayerEvent`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/player/PlayerEvent.html)`, T : `[`Cancellable`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/Cancellable.html) |
| [kill](kill.html) | `abstract fun kill(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [sendMessage](send-message.html) | `abstract fun sendMessage(message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

