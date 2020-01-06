---
title: ImplementationFactory.createKeyChangeChooser - plumber
---

[plumber](../../index.html) / [me.bristermitten.plumber.dsl.implementation](../index.html) / [ImplementationFactory](index.html) / [createKeyChangeChooser](./create-key-change-chooser.html)

# createKeyChangeChooser

`fun <R, K> createKeyChangeChooser(key: `[`DataKey`](../../me.bristermitten.plumber.struct.key/-data-key/index.html)`<K>, r: R, callback: `[`Runnable`](https://docs.oracle.com/javase/6/docs/api/java/lang/Runnable.html)`): `[`KeyChangeChooser`](../../me.bristermitten.plumber.dsl/-key-change-chooser/index.html)`<R, K>`

Create a [KeyChangeChooser](../../me.bristermitten.plumber.dsl/-key-change-chooser/index.html)

### Parameters

`key` - the key to watch

`r` - the value to watch for

`callback` - the callback for when the key is set to the right value

`K` - the type of the key

`R` - the type of value