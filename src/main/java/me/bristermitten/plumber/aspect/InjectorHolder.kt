package me.bristermitten.plumber.aspect

import com.google.inject.Inject
import com.google.inject.Injector
import com.google.inject.Singleton

/**
 * Holder class for Guice's [Injector]
 * Because the current [Injector] is modified frequently in Aspect creation, if an
 * Aspect has an instance of [Injector] injected it will not necessarily have every binding required.
 *
 * Instead, Aspects can have this injected to get the latest [Injector], which it is guaranteed to always hold.
 * @author Alexander Wood (BristerMitten)
 */
@Singleton
class InjectorHolder @Inject constructor(private val _injector: Injector) {
    private var locked = false

    var injector: Injector = _injector
        get() {
            if (locked) return field
            return _injector.getInstance(Injector::class.java)!!
        }
        private set

    fun lock(injector: Injector) {
        if (locked) return
        this.injector = injector
        locked = true
    }
}
