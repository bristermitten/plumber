---
title: me.bristermitten.plumber.struct.key - plumber
---

[plumber](../index.html) / [me.bristermitten.plumber.struct.key](./index.html)

## Package me.bristermitten.plumber.struct.key

### Types

| [DataKey](-data-key/index.html) | A DataKey provides a key for storing key-value data in entities It only stores the key, and a default value. It does NOT store the values, these are stored in the entities Means that Strings don't have to be passed around for simple storage`data class DataKey<T>` |
| [KeyHolder](-key-holder/index.html) | A KeyHolder defines an entity that holds key-value storage in the form of [DataKey](-data-key/index.html)`interface KeyHolder` |
| [KeyMap](-key-map/index.html) | Simple delegate of [HashMap](https://docs.oracle.com/javase/6/docs/api/java/util/HashMap.html) with generics overridden`class KeyMap : `[`MutableMap`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)`<`[`DataKey`](-data-key/index.html)`<*>, `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`>` |

