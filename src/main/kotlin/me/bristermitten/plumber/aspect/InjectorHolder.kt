package me.bristermitten.plumber.aspect

import com.google.inject.Inject
import com.google.inject.Injector
import com.google.inject.Singleton

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
class InjectorHolder @Inject constructor(_injector: Injector)  {
    private var locked = false

    var injector: Injector = _injector
        get() {
            if (locked) return field
            return field.getInstance(Injector::class.java)!!
        }
        @Synchronized
        // TODO - Aspects are able to change this value. Could be dangerous, look into access modifier
        set(value) {
            if (locked) throw IllegalStateException("Holder locked")
            field = value
        }

    fun lock(injector: Injector) {
        if (locked) return
        this.injector = injector
        locked = true
    }
}
