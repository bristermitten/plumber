---
title: ActionFilter - plumber
---

[plumber](../../index.html) / [me.bristermitten.rewrite.dsl.core](../index.html) / [ActionFilter](./index.html)

# ActionFilter

`interface ActionFilter<Us : `[`ActionFilter`](./index.html)`<Us>>`

### Functions

| [done](done.html) | `abstract fun done(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [whenIsTrue](when-is-true.html) | `abstract fun whenIsTrue(boolean: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`BooleanOperator`](../-boolean-operator/index.html)`<Us>`<br>`abstract fun whenIsTrue(boolean: Supplier<`[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`>): `[`BooleanOperator`](../-boolean-operator/index.html)`<Us>`<br>`abstract fun whenIsTrue(boolean: () -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`BooleanOperator`](../-boolean-operator/index.html)`<Us>` |

### Inheritors

| [ActionFilterImpl](../../me.bristermitten.rewrite.dsl.core.impl/-action-filter-impl/index.html) | `class ActionFilterImpl : `[`ActionFilter`](./index.html)`<`[`ActionFilterImpl`](../../me.bristermitten.rewrite.dsl.core.impl/-action-filter-impl/index.html)`>` |
| [PlayerActionFilter](../../me.bristermitten.rewrite.dsl.player/-player-action-filter/index.html) | `interface PlayerActionFilter : `[`ActionFilter`](./index.html)`<`[`PlayerActionFilter`](../../me.bristermitten.rewrite.dsl.player/-player-action-filter/index.html)`>` |

