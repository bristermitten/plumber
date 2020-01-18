package me.bristermitten.plumber.newfiles.store.id

import java.util.concurrent.atomic.AtomicLong

class IncrementIDResolver<ID: Number> : IDResolver<ID> {
    private val count = AtomicLong()

    override fun resolveID(any: Any): ID {
        return count.incrementAndGet() as ID
    }
}
