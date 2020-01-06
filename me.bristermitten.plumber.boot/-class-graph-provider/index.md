---
title: ClassGraphProvider - plumber
---

[plumber](../../index.html) / [me.bristermitten.plumber.boot](../index.html) / [ClassGraphProvider](./index.html)

# ClassGraphProvider

`class ClassGraphProvider : `[`Provider`](https://google.github.io/guice/api-docs/latest/javadoc/com/google/inject/Provider.html)`<ClassGraph>`

Guice [Provider](https://google.github.io/guice/api-docs/latest/javadoc/com/google/inject/Provider.html) for [ClassGraph](#)
This lazily initialises the instance, and uses [PlumberInfo](../-plumber-info/index.html) to whitelist packages

**Author**
Alexander Wood (BristerMitten)

### Constructors

| [&lt;init&gt;](-init-.html) | Guice [Provider](https://google.github.io/guice/api-docs/latest/javadoc/com/google/inject/Provider.html) for [ClassGraph](#) This lazily initialises the instance, and uses [PlumberInfo](../-plumber-info/index.html) to whitelist packages`ClassGraphProvider(info: `[`PlumberInfo`](../-plumber-info/index.html)`)` |

### Functions

| [get](get.html) | `fun get(): ClassGraph` |

