---
title: Store - plumber
---

[plumber](../../index.html) / [me.bristermitten.plumber.files](../index.html) / [Store](./index.html)

# Store

`interface Store<T>`

### Functions

| [flush](flush.html) | `abstract fun flush(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [loadWith](load-with.html) | `abstract fun loadWith(data: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [reload](reload.html) | `abstract fun reload(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [save](save.html) | `abstract fun save(t: T): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| [KeyValueStore](../-key-value-store.html) | `interface KeyValueStore<K, T> : `[`Store`](./index.html)`<T>, `[`MutableMap`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)`<K, T>` |
| [ValueStore](../-value-store.html) | `interface ValueStore<T> : `[`Store`](./index.html)`<T>, `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<T>` |

