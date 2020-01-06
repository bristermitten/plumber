---
title: MappedTo.<init> - plumber
---

[plumber](../../index.html) / [me.bristermitten.plumber.files](../index.html) / [MappedTo](index.html) / [&lt;init&gt;](./-init-.html)

# &lt;init&gt;

`MappedTo(fileName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, type: `[`StorageType`](../-storage-type/index.html)` = StorageType.INFER)`

Map an object to a persistent store i.e. a File or Database

### Parameters

`fileName` - The name of the storage. Files will be made in the plugin directory

`type` - The type of storage to use. If not specified, it will be inferred from the file extension