---
title: MappedTo - plumber
---

[plumber](../../index.html) / [me.bristermitten.plumber.files](../index.html) / [MappedTo](./index.html)

# MappedTo

`@AspectAnnotation(FilesAspect) @Target([AnnotationTarget.CLASS]) annotation class MappedTo`

Map an object to a persistent store i.e. a File or Database

### Parameters

`fileName` - The name of the storage. Files will be made in the plugin directory

`type` - The type of storage to use. If not specified, it will be inferred from the file extension

### Constructors

| [&lt;init&gt;](-init-.html) | Map an object to a persistent store i.e. a File or Database`MappedTo(fileName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, type: `[`StorageType`](../-storage-type/index.html)` = StorageType.INFER)` |

### Properties

| [fileName](file-name.html) | The name of the storage. Files will be made in the plugin directory`val fileName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [type](type.html) | The type of storage to use. If not specified, it will be inferred from the file extension`val type: `[`StorageType`](../-storage-type/index.html) |

