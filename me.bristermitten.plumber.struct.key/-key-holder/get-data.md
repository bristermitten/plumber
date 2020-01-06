---
title: KeyHolder.getData - plumber
---

[plumber](../../index.html) / [me.bristermitten.plumber.struct.key](../index.html) / [KeyHolder](index.html) / [getData](./get-data.html)

# getData

`abstract fun <K : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> getData(key: `[`DataKey`](../-data-key/index.html)`<K>): K`

Get a key's value

### Parameters

`key` - the key to get

**Parameters**

**Return**
the value of the key, or the key's default value

`abstract fun <K : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> getData(key: `[`DataKey`](../-data-key/index.html)`<K>, defaultValue: K): K`

Get a key's value, with a default value if the value is null

### Parameters

`key` - the key to get

`defaultValue` - the default value if they key holder has a null value

**Parameters**

**Return**
the value of the key, which will not be null

