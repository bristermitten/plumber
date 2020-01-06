---
title: StorageType - plumber
---

[plumber](../../index.html) / [me.bristermitten.plumber.files](../index.html) / [StorageType](./index.html)

# StorageType

`enum class StorageType`

Types of File or storage to use for saving and loading data

### Enum Values

| [JSON](-j-s-o-n.html) | Use Gson to load and save to a JSON file |
| [YAML](-y-a-m-l.html) | Use Gson and SnakeYaml to load and save to a YAML file. Significantly slower than JSON as because of limitations with generics, The data is first deserialized by Snakeyaml as [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), then serialized to a JSON Tree by Gson, then deserialized to the required type |
| [SQL](-s-q-l.html) |  |
| [INFER](-i-n-f-e-r.html) | Infer the type from the given file name in [MappedTo](../-mapped-to/index.html) |

