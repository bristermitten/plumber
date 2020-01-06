---
title: ActionFilterImpl - plumber
---

[plumber](../../index.html) / [me.bristermitten.rewrite.dsl.core.impl](../index.html) / [ActionFilterImpl](./index.html)

# ActionFilterImpl

`class ActionFilterImpl : `[`ActionFilter`](../../me.bristermitten.rewrite.dsl.core/-action-filter/index.html)`<`[`ActionFilterImpl`](./index.html)`>`

### Constructors

| [&lt;init&gt;](-init-.html) | `ActionFilterImpl(runnable: () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`)` |

### Functions

| [done](done.html) | `fun done(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [whenIsTrue](when-is-true.html) | `fun whenIsTrue(boolean: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`BooleanOperator`](../../me.bristermitten.rewrite.dsl.core/-boolean-operator/index.html)`<`[`ActionFilterImpl`](./index.html)`>`<br>`fun whenIsTrue(boolean: Supplier<`[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`>): `[`BooleanOperator`](../../me.bristermitten.rewrite.dsl.core/-boolean-operator/index.html)`<`[`ActionFilterImpl`](./index.html)`>`<br>`fun whenIsTrue(boolean: () -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`BooleanOperator`](../../me.bristermitten.rewrite.dsl.core/-boolean-operator/index.html)`<`[`ActionFilterImpl`](./index.html)`>` |

