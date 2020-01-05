package me.bristermitten.plumber.scheduling.timings.compare

import me.bristermitten.plumber.annotation.Unstable


/**
 * Picker interface for picking a distance from a certain time
 */
@Unstable(reason = "No implementation yet")
interface CompareRootTimePicker {
    /**
     * Compare the time to the current time at point of execution,
     * ie [System.currentTimeMillis]
     */
    fun ago(): Boolean

    /**
     * Compare the time to a given point in unix time
     */
    fun from(epoch: Long): Boolean
}
