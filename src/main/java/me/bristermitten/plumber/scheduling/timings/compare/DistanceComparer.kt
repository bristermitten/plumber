package me.bristermitten.plumber.scheduling.timings.compare

import me.bristermitten.plumber.annotation.Unstable
import me.bristermitten.plumber.scheduling.timings.TimeUnitPicker

/**
 * DSL Picker for comparing lengths, often of time
 */
@Unstable(reason = "No implementation yet")
interface DistanceComparer<T> {
    fun moreThan(time : Long): TimeUnitPicker<T>
    fun lessThan(time : Long): TimeUnitPicker<T>
    fun exactly(time : Long): TimeUnitPicker<T>
}
