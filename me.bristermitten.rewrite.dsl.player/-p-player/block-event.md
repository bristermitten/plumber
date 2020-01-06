---
title: PPlayer.blockEvent - plumber
---

[plumber](../../index.html) / [me.bristermitten.rewrite.dsl.player](../index.html) / [PPlayer](index.html) / [blockEvent](./block-event.html)

# blockEvent

`abstract fun <T> blockEvent(clazz: `[`Class`](https://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<T>): `[`LengthConfiguration`](../../me.bristermitten.rewrite.dsl.core/-length-configuration/index.html)`<`[`PlayerActionFilter`](../-player-action-filter/index.html)`, `[`PlayerReactorPicker`](../-player-reactor-picker/index.html)`> where T : PlayerEvent, T : Cancellable`
`abstract fun <T> blockEvent(clazz: `[`KClass`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html)`<T>): `[`LengthConfiguration`](../../me.bristermitten.rewrite.dsl.core/-length-configuration/index.html)`<`[`PlayerActionFilter`](../-player-action-filter/index.html)`, `[`PlayerReactorPicker`](../-player-reactor-picker/index.html)`> where T : PlayerEvent, T : Cancellable`