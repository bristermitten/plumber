package me.bristermitten.plumber.aspect.components

import com.google.inject.AbstractModule
import com.google.inject.Inject
import com.google.inject.Module
import me.bristermitten.plumber.aspect.AbstractAspect
import me.bristermitten.plumber.aspect.AspectReflectionManager
import me.bristermitten.plumber.aspect.RequiredAspect

@RequiredAspect
class ComponentAspect : AbstractAspect() {

    @Inject
    lateinit var manager: AspectReflectionManager

    override fun module(): Module? {
        return object : AbstractModule() {
            override fun configure() {
                manager.classesForAspect(this@ComponentAspect)
                        .forEach {
                            bind(it).asEagerSingleton()
                            println("Bound Component class $it")
                        }
            }
        }
    }
}
