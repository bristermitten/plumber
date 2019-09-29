package me.bristermitten.plumber.newaspect.modules

import com.google.inject.AbstractModule
import me.bristermitten.plumber.PlumberPlugin
import me.bristermitten.plumber.newaspect.AspectReflectionManager
import org.reflections.Reflections

class InitialModule(private val plumberPlugin: PlumberPlugin, private val reflections: Reflections) : AbstractModule() {

    override fun configure() {
        bind(plumberPlugin.javaClass).toInstance(plumberPlugin)
        bind(reflections.javaClass).toInstance(reflections)
        bind(AspectReflectionManager::class.java).toInstance(AspectReflectionManager(this, reflections))
    }
}
