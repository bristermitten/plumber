---
title: TimeUnit - plumber
---

[plumber](../../index.html) / [me.bristermitten.plumber.scheduling.timings](../index.html) / [TimeUnit](./index.html)

# TimeUnit

`enum class TimeUnit`

Simple Time Unit enum that includes Minecraft ticks,
where ideally 20 ticks are in a second.
Anything below a millisecond is not included, as realistically they are highly unlikely
to be needed in a Minecraft server

### Enum Values

| [TICKS](-t-i-c-k-s/index.html) |  |
| [MILLISECONDS](-m-i-l-l-i-s-e-c-o-n-d-s/index.html) |  |
| [SECONDS](-s-e-c-o-n-d-s/index.html) |  |
| [MINUTES](-m-i-n-u-t-e-s/index.html) |  |
| [HOURS](-h-o-u-r-s/index.html) |  |
| [DAYS](-d-a-y-s/index.html) |  |

### Functions

| [oneUnitMillisTime](one-unit-millis-time.html) | `fun oneUnitMillisTime(): `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [toTicks](to-ticks.html) | Convert a given time to ticks`fun toTicks(time: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |

