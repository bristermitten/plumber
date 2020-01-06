---
title: Time - plumber
---

[plumber](../../index.html) / [me.bristermitten.plumber.scheduling.timings](../index.html) / [Time](./index.html)

# Time

`data class Time`

Represents a length of time, with a unit

### Constructors

| [&lt;init&gt;](-init-.html) | Represents a length of time, with a unit`Time(unit: `[`TimeUnit`](../-time-unit/index.html)` = TimeUnit.SECONDS, length: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)` = 0)` |

### Properties

| [length](length.html) | `var length: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [unit](unit.html) | `var unit: `[`TimeUnit`](../-time-unit/index.html) |

### Functions

| [equals](equals.html) | `fun equals(other: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [hashCode](hash-code.html) | `fun hashCode(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [toTicks](to-ticks.html) | `fun toTicks(): `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |

### Companion Object Properties

| [EMPTY](-e-m-p-t-y.html) | An empty time. Defined internally as 0 seconds`val EMPTY: `[`Time`](./index.html) |
| [NONE](-n-o-n-e.html) | No time. Internally equal to -1 seconds, but should result in the number being ignored. For example, in [me.bristermitten.plumber.scheduling.Task](../../me.bristermitten.plumber.scheduling/-task/index.html) if the period is [NONE](-n-o-n-e.html), then a task is scheduled as only running once, whereas a period of [EMPTY](-e-m-p-t-y.html) may cause the event to repeatedly run as the delay between execution is 0 ticks`val NONE: `[`Time`](./index.html) |
| [NONE_TICKS](-n-o-n-e_-t-i-c-k-s.html) | [NONE](-n-o-n-e.html) in ticks. Numerically equal to -20`val NONE_TICKS: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |

