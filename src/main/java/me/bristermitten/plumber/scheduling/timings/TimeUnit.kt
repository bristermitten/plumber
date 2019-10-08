package me.bristermitten.plumber.scheduling.timings

/**
 * Simple Time Unit enum that includes Minecraft ticks,
 * where ideally 20 ticks are in a second.
 * Anything below a millisecond is not included, as realistically they are highly unlikely
 * to be needed in a Minecraft server
 */
enum class TimeUnit {
    TICKS {
        override fun oneUnitMillisTime(): Long {
            return SECONDS.oneUnitMillisTime() / 20
        }
    },
    MILLISECONDS {
        override fun oneUnitMillisTime(): Long = 1
    },
    SECONDS {
        override fun oneUnitMillisTime(): Long {
            return MILLISECONDS.oneUnitMillisTime() * 1000
        }
    },
    MINUTES {
        override fun oneUnitMillisTime(): Long {
            return SECONDS.oneUnitMillisTime() * 60
        }
    },
    HOURS {
        override fun oneUnitMillisTime(): Long {
            return MINUTES.oneUnitMillisTime() * 60
        }
    },
    DAYS {
        override fun oneUnitMillisTime(): Long {
            return HOURS.oneUnitMillisTime() * 24
        }
    };


    /**
     * @return the length of one "unit" of this time unit in milliseconds equivalent
     */
    open fun oneUnitMillisTime(): Long {
        return -1
    }

    /**
     * Convert a given time to ticks
     */
    fun toTicks(time: Long): Long {
        if (this == TICKS) return time
        return oneUnitMillisTime() * time / 50
    }
}
