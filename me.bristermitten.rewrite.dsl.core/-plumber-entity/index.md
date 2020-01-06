---
title: PlumberEntity - plumber
---

[plumber](../../index.html) / [me.bristermitten.rewrite.dsl.core](../index.html) / [PlumberEntity](./index.html)

# PlumberEntity

`interface PlumberEntity<T : `[`PlumberEntity`](./index.html)`<T, F, RP>, F : `[`ActionFilter`](../-action-filter/index.html)`<F>, RP : `[`PlayerReactorPicker`](../../me.bristermitten.rewrite.dsl.player/-player-reactor-picker/index.html)`>`

### Functions

| [createTask](create-task.html) | Execute a task`abstract fun createTask(runnable: () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): F` |
| [executeTask](execute-task.html) | `abstract fun executeTask(runnable: () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`LengthConfiguration`](../-length-configuration/index.html)`<F, RP>` |

### Inheritors

| [MainPlumberEntity](../../me.bristermitten.rewrite.dsl.core.impl/-main-plumber-entity/index.html) | `class MainPlumberEntity<T : `[`PlumberEntity`](./index.html)`<T, F, RP>, F : `[`ActionFilter`](../-action-filter/index.html)`<F>, RP : `[`PlayerReactorPicker`](../../me.bristermitten.rewrite.dsl.player/-player-reactor-picker/index.html)`> : `[`PlumberEntity`](./index.html)`<T, F, RP>` |
| [PPlayer](../../me.bristermitten.rewrite.dsl.player/-p-player/index.html) | `interface PPlayer : `[`PlumberEntity`](./index.html)`<`[`PPlayer`](../../me.bristermitten.rewrite.dsl.player/-p-player/index.html)`, `[`PlayerActionFilter`](../../me.bristermitten.rewrite.dsl.player/-player-action-filter/index.html)`, `[`PlayerReactorPicker`](../../me.bristermitten.rewrite.dsl.player/-player-reactor-picker/index.html)`>` |

