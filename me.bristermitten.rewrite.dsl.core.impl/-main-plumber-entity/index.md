---
title: MainPlumberEntity - plumber
---

[plumber](../../index.html) / [me.bristermitten.rewrite.dsl.core.impl](../index.html) / [MainPlumberEntity](./index.html)

# MainPlumberEntity

`class MainPlumberEntity<T : `[`PlumberEntity`](../../me.bristermitten.rewrite.dsl.core/-plumber-entity/index.html)`<T, F, RP>, F : `[`ActionFilter`](../../me.bristermitten.rewrite.dsl.core/-action-filter/index.html)`<F>, RP : `[`PlayerReactorPicker`](../../me.bristermitten.rewrite.dsl.player/-player-reactor-picker/index.html)`> : `[`PlumberEntity`](../../me.bristermitten.rewrite.dsl.core/-plumber-entity/index.html)`<T, F, RP>`

### Constructors

| [&lt;init&gt;](-init-.html) | `MainPlumberEntity()` |

### Functions

| [createTask](create-task.html) | Execute a task`fun createTask(runnable: () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): F` |
| [executeTask](execute-task.html) | `fun executeTask(runnable: () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`LengthConfiguration`](../../me.bristermitten.rewrite.dsl.core/-length-configuration/index.html)`<F, RP>` |

