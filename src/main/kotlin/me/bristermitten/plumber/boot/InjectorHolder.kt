package me.bristermitten.plumber.boot

import com.google.inject.Inject
import com.google.inject.Injector
import com.google.inject.Singleton
import me.bristermitten.plumber.aspect.Aspect
import org.slf4j.LoggerFactory

/**
 * Holder class for Guice's [Injector]
 * Because the current [Injector] is modified frequently in Aspect creation, if an
 * Aspect has an instance of [Injector] injected it will not necessarily have every binding required.
 *
 * For example, if an Aspect is initialised it will be injected with the Injector used to create it.
 * However, after if installs a module, said injector will not contain the bindings from that module.
 * One solution would be to re-inject into the Aspect, but this brings a performance toll along with
 * the inconsistencies that come with mutability. Instead, Aspects should have [InjectorHolder] injected
 * which will carry the latest injector and will be updated after each Aspect's [Aspect.getModule] declaration
 *
 * Instead, Aspects can have this injected to get the latest [Injector], which it is guaranteed to always hold.
 * @author Alexander Wood (BristerMitten)
 */
@Singleton
class InjectorHolder  @Inject constructor(default: Injector) {
    private var locked = false

    var injector: Injector = default
        @Synchronized
        // TODO - Aspects are able to change this value. Could be dangerous, look into access modifier
        set(value) {
            if (locked) throw IllegalStateException("Holder locked")
            field = value
        }

    fun lock() {
        if (locked) return
    }
}
