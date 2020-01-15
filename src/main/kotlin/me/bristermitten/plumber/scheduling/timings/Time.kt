package me.bristermitten.plumber.scheduling.timings

/**
 * Represents a length of time, with a unit
 */
data class Time(var unit: TimeUnit = TimeUnit.SECONDS, var length: Long = 0) {
    fun toTicks(): Long {
        return unit.toTicks(length)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Time

        if (toTicks() != other.toTicks()) return false

        return true
    }

    override fun hashCode(): Int {
        return toTicks().hashCode()
    }


    companion object {
        /**
         * An empty time. Defined internally as 0 seconds
         */
        private val EMPTY = Time()
        /**
         * No time. Internally equal to -1 seconds, but should result in the number
         * being ignored. For example, in [me.bristermitten.plumber.scheduling.Task] if the period
         * is [NONE], then a task is scheduled as only running once, whereas a period of [EMPTY]
         * may cause the event to repeatedly run as the delay between execution is 0 ticks
         */
        val NONE = Time(length = -1)
        /**
         * [NONE] in ticks.
         * Numerically equal to -20
         */
        val NONE_TICKS = NONE.toTicks()
    }
}
