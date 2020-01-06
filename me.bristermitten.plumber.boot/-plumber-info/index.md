---
title: PlumberInfo - plumber
---

[plumber](../../index.html) / [me.bristermitten.plumber.boot](../index.html) / [PlumberInfo](./index.html)

# PlumberInfo

`class PlumberInfo`

Holds info about the running Plumber instance.
Currently, this only includes the package name of the [PlumberPlugin](../../me.bristermitten.plumber/-plumber-plugin/index.html) implementation
for [ClassFinder](../../me.bristermitten.plumber.reflection/-class-finder/index.html), but may have more in the future.

TODO - I'm not a fan of this class's coupling with [PlumberPlugin](../../me.bristermitten.plumber/-plumber-plugin/index.html), however this approach seems cleaner than

* requiring it to be created in [PlumberLoader](../-plumber-loader/index.html) or something similar. Ideas would be appreciated

**Author**
Alexander Wood (BristerMitten)

### Constructors

| [&lt;init&gt;](-init-.html) | For mocking.`PlumberInfo(externalPackage: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`)``PlumberInfo(plumberPlugin: `[`PlumberPlugin`](../../me.bristermitten.plumber/-plumber-plugin/index.html)`)` |

### Properties

| [externalPluginPackage](external-plugin-package.html) | The external plugin's package (eg me.author.plugin)`val externalPluginPackage: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [plumberPackage](plumber-package.html) | Plumber's package for internals`val plumberPackage: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

