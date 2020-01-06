---
title: TimeUnitPickerFactory - plumber
---

[plumber](../../index.html) / [me.bristermitten.plumber.scheduling.timings](../index.html) / [TimeUnitPickerFactory](./index.html)

# TimeUnitPickerFactory

`class TimeUnitPickerFactory`

Simple factory class for creating instances of [TimeUnitPicker](../-time-unit-picker/index.html)
Due to the use of generics, we can't use Assisted Inject for this, so have to do it manually

May be changed in the future

### Constructors

| [&lt;init&gt;](-init-.html) | Simple factory class for creating instances of [TimeUnitPicker](../-time-unit-picker/index.html) Due to the use of generics, we can't use Assisted Inject for this, so have to do it manually`TimeUnitPickerFactory()` |

### Functions

| [pick](pick.html) | Create a new [TimeUnitPicker](../-time-unit-picker/index.html)`fun <T> pick(parent: T, callback: (`[`TimeUnit`](../-time-unit/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`TimeUnitPicker`](../-time-unit-picker/index.html)`<T>` |

