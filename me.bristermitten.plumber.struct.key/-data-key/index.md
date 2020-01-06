---
title: DataKey - plumber
---

[plumber](../../index.html) / [me.bristermitten.plumber.struct.key](../index.html) / [DataKey](./index.html)

# DataKey

`data class DataKey<T>`

A DataKey provides a key for storing key-value data in entities
It only stores the key, and a default value. It does NOT store the values, these are stored in the entities
Means that Strings don't have to be passed around for simple storage

### Constructors

| [&lt;init&gt;](-init-.html) | `DataKey(defaultValue: T)`<br>A DataKey provides a key for storing key-value data in entities It only stores the key, and a default value. It does NOT store the values, these are stored in the entities Means that Strings don't have to be passed around for simple storage`DataKey(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, defaultValue: T)` |

### Properties

| [defaultValue](default-value.html) | `val defaultValue: T` |
| [handlers](handlers.html) | List of Handlers for when the key's value is updated. These are not actually handled in the Key object, and instead should be called inside classes that implement [KeyHolder](../-key-holder/index.html) or hold instances of [DataKey](./index.html) For example, in [PPlayer.setData](exec-handlers.html) is called every time the key's data is updated.`val handlers: `[`KeySetView`](https://docs.oracle.com/javase/6/docs/api/java/util/concurrent/ConcurrentHashMap/KeySetView.html)`<Consumer<T>!, `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`!>` |
| [key](key.html) | `val key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Functions

| [execHandlers](exec-handlers.html) | Execute all handlers with a new value This should be called before the value is set upon`fun execHandlers(value: T): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

