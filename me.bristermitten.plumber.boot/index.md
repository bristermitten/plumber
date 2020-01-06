---
title: me.bristermitten.plumber.boot - plumber
---

[plumber](../index.html) / [me.bristermitten.plumber.boot](./index.html)

## Package me.bristermitten.plumber.boot

### Types

| [ClassGraphProvider](-class-graph-provider/index.html) | Guice [Provider](https://google.github.io/guice/api-docs/latest/javadoc/com/google/inject/Provider.html) for [ClassGraph](#) This lazily initialises the instance, and uses [PlumberInfo](-plumber-info/index.html) to whitelist packages`class ClassGraphProvider : `[`Provider`](https://google.github.io/guice/api-docs/latest/javadoc/com/google/inject/Provider.html)`<ClassGraph>` |
| [InjectorHolder](-injector-holder/index.html) | Holder class for Guice's [Injector](https://google.github.io/guice/api-docs/latest/javadoc/com/google/inject/Injector.html) Because the current [Injector](https://google.github.io/guice/api-docs/latest/javadoc/com/google/inject/Injector.html) is modified frequently in Aspect creation, if an Aspect has an instance of [Injector](https://google.github.io/guice/api-docs/latest/javadoc/com/google/inject/Injector.html) injected it will not necessarily have every binding required.`class InjectorHolder` |
| [PlumberInfo](-plumber-info/index.html) | Holds info about the running Plumber instance. Currently, this only includes the package name of the [PlumberPlugin](../me.bristermitten.plumber/-plumber-plugin/index.html) implementation for [ClassFinder](../me.bristermitten.plumber.reflection/-class-finder/index.html), but may have more in the future.`class PlumberInfo` |
| [PlumberLoader](-plumber-loader/index.html) | Class responsible for loading the entirety of Plumber.`class PlumberLoader` |

