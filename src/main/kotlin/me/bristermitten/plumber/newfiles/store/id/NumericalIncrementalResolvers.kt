package me.bristermitten.plumber.newfiles.store.id

import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.atomic.AtomicLong

/**
 * @author Alexander Wood (BristerMitten)
 */

class LongIncrementalResolver : IDResolver<Long> {
    private val count = AtomicLong()

    override fun resolveID(value: Any): Long = count.incrementAndGet()
}

class IntIncrementalResolver : IDResolver<Int> {
    private val count = AtomicInteger()

    override fun resolveID(value: Any): Int = count.incrementAndGet()

}


class NumericalResolverConfig : ResolverConfig {
    override fun registerResolvers(idResolvers: IDResolvers) {
        idResolvers.registerResolver(::IntIncrementalResolver)
        idResolvers.registerResolver(::LongIncrementalResolver)
    }
}
