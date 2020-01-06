---
title: me.bristermitten.plumber.scheduling.timings - plumber
---

[plumber](../index.html) / [me.bristermitten.plumber.scheduling.timings](./index.html)

## Package me.bristermitten.plumber.scheduling.timings

### Types

| [TaskBuilder](-task-builder/index.html) | Builder for configuring times in the future for scheduling This can be safely injected`interface TaskBuilder` |
| [Time](-time/index.html) | Represents a length of time, with a unit`data class Time` |
| [TimeUnit](-time-unit/index.html) | Simple Time Unit enum that includes Minecraft ticks, where ideally 20 ticks are in a second. Anything below a millisecond is not included, as realistically they are highly unlikely to be needed in a Minecraft server`enum class TimeUnit` |
| [TimeUnitPicker](-time-unit-picker/index.html) | A TimeUnitPicker allows developers to choose a time unit for an action. General best practice is to have the method that returns a TimeUnitPicker take a long for the amount of time, for example `
PPlayer#blockEvent(PlayerMoveEvent.class).undoAfter(30).seconds()
` *`interface TimeUnitPicker<T>` |
| [TimeUnitPickerFactory](-time-unit-picker-factory/index.html) | Simple factory class for creating instances of [TimeUnitPicker](-time-unit-picker/index.html) Due to the use of generics, we can't use Assisted Inject for this, so have to do it manually`class TimeUnitPickerFactory` |

