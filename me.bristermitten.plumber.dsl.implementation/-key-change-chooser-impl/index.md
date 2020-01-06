---
title: KeyChangeChooserImpl - plumber
---

[plumber](../../index.html) / [me.bristermitten.plumber.dsl.implementation](../index.html) / [KeyChangeChooserImpl](./index.html)

# KeyChangeChooserImpl

`class KeyChangeChooserImpl<R, K> : `[`KeyChangeChooser`](../../me.bristermitten.plumber.dsl/-key-change-chooser/index.html)`<R, K>`

### Constructors

| [&lt;init&gt;](-init-.html) | `KeyChangeChooserImpl(r: R, watching: `[`DataKey`](../../me.bristermitten.plumber.struct.key/-data-key/index.html)`<K>, callback: `[`Runnable`](https://docs.oracle.com/javase/6/docs/api/java/lang/Runnable.html)`)` |

### Functions

| [reset](reset.html) | Reset the current data Implementation is interface specific`fun reset(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [toValue](to-value.html) | Set the value that will trigger a callback`fun toValue(value: K): R` |

