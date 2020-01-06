---
title: StoreProxyHandler - plumber
---

[plumber](../../index.html) / [me.bristermitten.plumber.files](../index.html) / [StoreProxyHandler](./index.html)

# StoreProxyHandler

`sealed class StoreProxyHandler : `[`InvocationHandler`](https://docs.oracle.com/javase/6/docs/api/java/lang/reflect/InvocationHandler.html)

### Properties

| [collectionProxy](collection-proxy.html) | `val collectionProxy: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html) |
| [file](file.html) | `val file: `[`PlumberFile`](../-plumber-file/index.html) |
| [methodTable](method-table.html) | `val methodTable: Table<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Class`](https://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<*>>, (`[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`>) -> `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?>` |

### Functions

| [invoke](invoke.html) | `open fun invoke(proxy: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?, method: `[`Method`](https://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Method.html)`, arguments: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`>?): `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?` |
| [load](load.html) | `abstract fun load(data: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setType](set-type.html) | `open fun setType(type: `[`Class`](https://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<*>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| [KeyValueStoreProxyHandler](../-key-value-store-proxy-handler/index.html) | `class KeyValueStoreProxyHandler : `[`StoreProxyHandler`](./index.html) |
| [ValueStoreProxyHandler](../-value-store-proxy-handler/index.html) | `class ValueStoreProxyHandler : `[`StoreProxyHandler`](./index.html) |

