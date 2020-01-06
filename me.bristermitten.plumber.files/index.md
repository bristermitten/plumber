---
title: me.bristermitten.plumber.files - plumber
---

[plumber](../index.html) / [me.bristermitten.plumber.files](./index.html)

## Package me.bristermitten.plumber.files

### Types

| [AbstractPlumberFile](-abstract-plumber-file/index.html) | `abstract class AbstractPlumberFile : `[`PlumberFile`](-plumber-file/index.html) |
| [FilesAspect](-files-aspect/index.html) | `class FilesAspect : `[`AbstractAspect`](../me.bristermitten.plumber.aspect/-abstract-aspect/index.html) |
| [FilesAspectStaticModule](-files-aspect-static-module/index.html) | `class FilesAspectStaticModule : `[`AbstractModule`](https://google.github.io/guice/api-docs/latest/javadoc/com/google/inject/AbstractModule.html) |
| [JsonPlumberFile](-json-plumber-file/index.html) | `class JsonPlumberFile : `[`AbstractPlumberFile`](-abstract-plumber-file/index.html) |
| [KeyValueStore](-key-value-store.html) | `interface KeyValueStore<K, T> : `[`Store`](-store/index.html)`<T>, `[`MutableMap`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)`<K, T>` |
| [KeyValueStoreProxyHandler](-key-value-store-proxy-handler/index.html) | `class KeyValueStoreProxyHandler : `[`StoreProxyHandler`](-store-proxy-handler/index.html) |
| [MappingType](-mapping-type/index.html) | Methods of mapping data to a backend storage`enum class MappingType` |
| [PlumberFile](-plumber-file/index.html) | `interface PlumberFile` |
| [PlumberFileFactory](-plumber-file-factory/index.html) | `interface PlumberFileFactory` |
| [StorageType](-storage-type/index.html) | Types of File or storage to use for saving and loading data`enum class StorageType` |
| [Store](-store/index.html) | `interface Store<T>` |
| [StoreProxyHandler](-store-proxy-handler/index.html) | `sealed class StoreProxyHandler : `[`InvocationHandler`](https://docs.oracle.com/javase/6/docs/api/java/lang/reflect/InvocationHandler.html) |
| [ValueStore](-value-store.html) | `interface ValueStore<T> : `[`Store`](-store/index.html)`<T>, `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<T>` |
| [ValueStoreProxyHandler](-value-store-proxy-handler/index.html) | `class ValueStoreProxyHandler : `[`StoreProxyHandler`](-store-proxy-handler/index.html) |
| [YamlPlumberFile](-yaml-plumber-file/index.html) | `class YamlPlumberFile : `[`AbstractPlumberFile`](-abstract-plumber-file/index.html) |

### Annotations

| [Id](-id/index.html) | Define the Id parameter for a data class This is only needed for Key-Value storage, and is used as the key`annotation class Id` |
| [MappedTo](-mapped-to/index.html) | Map an object to a persistent store i.e. a File or Database`annotation class MappedTo` |
| [StorageMapping](-storage-mapping/index.html) | The type of mapping to use from memory to storage`annotation class StorageMapping` |

