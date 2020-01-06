---
title: KeyHolder - plumber
---

[plumber](../../index.html) / [me.bristermitten.plumber.struct.key](../index.html) / [KeyHolder](./index.html)

# KeyHolder

`interface KeyHolder`

A KeyHolder defines an entity that holds key-value storage in the form of [DataKey](../-data-key/index.html)

### Functions

| [getData](get-data.html) | Get a key's value`abstract fun <K : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> getData(key: `[`DataKey`](../-data-key/index.html)`<K>): K`<br>Get a key's value, with a default value if the value is null`abstract fun <K : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> getData(key: `[`DataKey`](../-data-key/index.html)`<K>, defaultValue: K): K` |
| [rawSetData](raw-set-data.html) | Update a key's value The key's handlers WILL NOT be called`abstract fun <K : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> rawSetData(key: `[`DataKey`](../-data-key/index.html)`<K>, data: K): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setData](set-data.html) | Update a key's value The key's handlers WILL be called`abstract fun <K : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> setData(key: `[`DataKey`](../-data-key/index.html)`<K>, data: K): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| [PPlayer](../../me.bristermitten.plumber.struct.player/-p-player/index.html) | Plumber wrapper for the [Player](#) class Allows lots of boilerplate on Players do be done easily`interface PPlayer : `[`KeyHolder`](./index.html)`, `[`Extendable`](../../me.bristermitten.plumber.struct.extension/-extendable/index.html)`<`[`PPlayer`](../../me.bristermitten.plumber.struct.player/-p-player/index.html)`, `[`PlayerExtension`](../../me.bristermitten.plumber.struct.player/-player-extension.html)`>` |

