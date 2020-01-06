---
title: KeyChangeChooser - plumber
---

[plumber](../../index.html) / [me.bristermitten.plumber.dsl](../index.html) / [KeyChangeChooser](./index.html)

# KeyChangeChooser

`interface KeyChangeChooser<R, K> : `[`Resettable`](../../me.bristermitten.plumber.struct/-resettable/index.html)

Interfaces that wraps watching a [DataKey](../../me.bristermitten.plumber.struct.key/-data-key/index.html) for a specific value

### Functions

| [toValue](to-value.html) | Set the value that will trigger a callback`abstract fun toValue(value: K): R` |

### Inheritors

| [KeyChangeChooserImpl](../../me.bristermitten.plumber.dsl.implementation/-key-change-chooser-impl/index.html) | `class KeyChangeChooserImpl<R, K> : `[`KeyChangeChooser`](./index.html)`<R, K>` |

