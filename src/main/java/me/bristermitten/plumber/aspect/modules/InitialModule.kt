package me.bristermitten.plumber.aspect.modules

import com.google.inject.AbstractModule
import me.bristermitten.plumber.PlumberPlugin
import org.reflections.Reflections

class InitialModule(
        private val plumberPlugin: PlumberPlugin,
        private val reflections: Reflections
) : AbstractModule() {

    override fun configure() {
        bind(PlumberPlugin::class.java).toInstance(plumberPlugin)
        bind(plumberPlugin.javaClass).toInstance(plumberPlugin)
        bind(reflections.javaClass).toInstance(reflections)
        bind(InitialModule::class.java).toInstance(this)
//        bind(AspectReflectionManager::class.java)
//                .toInstance(AspectReflectionManager(this, reflections))
    }
}
