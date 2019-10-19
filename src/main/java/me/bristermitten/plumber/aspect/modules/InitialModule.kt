package me.bristermitten.plumber.aspect.modules

import com.google.inject.AbstractModule
import me.bristermitten.plumber.PlumberPlugin
import org.reflections.Reflections

/**
 * First module in the Aspect module flow
 * Binds the bare bones of Plumber to their respective instances
 */
class InitialModule(
        private val plumberPlugin: PlumberPlugin,
        private val reflections: Reflections
) : AbstractModule() {

    override fun configure() {
        bind(PlumberPlugin::class.java).toInstance(plumberPlugin)
        bind(plumberPlugin.javaClass).toInstance(plumberPlugin)
        bind(reflections.javaClass).toInstance(reflections)
        bind(javaClass).toInstance(this)
    }
}
