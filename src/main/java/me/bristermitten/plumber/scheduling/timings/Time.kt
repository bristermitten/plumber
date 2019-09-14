package me.bristermitten.plumber.scheduling.timings

data class Time(var unit: TimeUnit = TimeUnit.SECONDS, var length: Long = 0) {
    fun toTicks(): Long {
        return unit.toTicks(length)
    }

    companion object {
        val EMPTY = Time()
        val NONE = Time(length = -1)
        val NONE_TICKS = NONE.toTicks()
    }
}
