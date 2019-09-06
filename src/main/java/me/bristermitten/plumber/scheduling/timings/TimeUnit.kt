package me.bristermitten.plumber.scheduling.timings

internal enum class TimeUnit {
    TICKS {
        override fun oneUnitMillisTime(): Long {
            return SECONDS.oneUnitMillisTime() / 20
        }
    },
    MILLISECONDS {
        override fun oneUnitMillisTime(): Long {
            return 1
        }
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


    open fun oneUnitMillisTime(): Long {
        return -1
    }
}
