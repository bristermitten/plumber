---
title: FilesAspect - plumber
---

[plumber](../../index.html) / [me.bristermitten.plumber.files](../index.html) / [FilesAspect](./index.html)

# FilesAspect

`@RequiredAspect class FilesAspect : `[`AbstractAspect`](../../me.bristermitten.plumber.aspect/-abstract-aspect/index.html)

### Types

| [FileInfo](-file-info/index.html) | `data class FileInfo` |

### Constructors

| [&lt;init&gt;](-init-.html) | `FilesAspect(reflector: Reflector, plumberFileFactory: `[`PlumberFileFactory`](../-plumber-file-factory/index.html)`)` |

### Functions

| [doEnable](do-enable.html) | `fun doEnable(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [getModule](get-module.html) | Provide an optional Guice module to be installed. This is called *after* instantiation of the Aspect so nothing from this module can be used in the Aspect.`fun getModule(): `[`Module`](https://google.github.io/guice/api-docs/latest/javadoc/com/google/inject/Module.html) |

