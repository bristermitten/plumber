---
title: AbstractPlumberFile - plumber
---

[plumber](../../index.html) / [me.bristermitten.plumber.files](../index.html) / [AbstractPlumberFile](./index.html)

# AbstractPlumberFile

`@Unstable("Functional but not documented and undergoing heavy refactoring") abstract class AbstractPlumberFile : `[`PlumberFile`](../-plumber-file/index.html)

### Constructors

| [&lt;init&gt;](-init-.html) | `AbstractPlumberFile(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, plugin: `[`PlumberPlugin`](../../me.bristermitten.plumber/-plumber-plugin/index.html)`)` |

### Properties

| [mapped](mapped.html) | `lateinit var mapped: `[`Store`](../-store/index.html)`<*>` |
| [type](type.html) | `lateinit var type: TypeToken<*>` |

### Functions

| [loadData](load-data.html) | `open fun loadData(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [loadFrom](load-from.html) | `abstract fun loadFrom(inputStream: `[`InputStream`](https://docs.oracle.com/javase/6/docs/api/java/io/InputStream.html)`): `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html) |
| [saveData](save-data.html) | `open fun saveData(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [saveTo](save-to.html) | `abstract fun saveTo(outputStream: `[`OutputStream`](https://docs.oracle.com/javase/6/docs/api/java/io/OutputStream.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| [JsonPlumberFile](../-json-plumber-file/index.html) | `class JsonPlumberFile : `[`AbstractPlumberFile`](./index.html) |
| [YamlPlumberFile](../-yaml-plumber-file/index.html) | `class YamlPlumberFile : `[`AbstractPlumberFile`](./index.html) |

