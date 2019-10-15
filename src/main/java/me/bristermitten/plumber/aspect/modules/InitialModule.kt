package me.bristermitten.plumber.aspect.modules

import com.google.inject.AbstractModule
import io.github.classgraph.ClassGraph
import me.bristermitten.plumber.PlumberPlugin

/**
 * First module in the Aspect module flow
 * Binds the bare bones of Plumber to their respective instances
 */
class InitialModule(
        private val plumberPlugin: PlumberPlugin,
        private val classGraph: ClassGraph
) : AbstractModule() {

    override fun configure() {
        bind(PlumberPlugin::class.java).toInstance(plumberPlugin)
        bind(plumberPlugin.javaClass).toInstance(plumberPlugin)
        bind(classGraph.javaClass).toInstance(classGraph)
        bind(InitialModule::class.java).toInstance(this)
    }
}
