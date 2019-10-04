package me.bristermitten.plumber.aspect.modules

import com.google.inject.AbstractModule
import com.google.inject.Injector
import me.bristermitten.plumber.aspect.Aspect
import me.bristermitten.plumber.aspect.AspectModuleLink
import me.bristermitten.plumber.aspect.AspectReflectionManager

class AspectModule(private val parent: InitialModule,
                   private val aspectReflectionManager: AspectReflectionManager,
                   val requiredAspects: MutableSet<Class<out Aspect>> = aspectReflectionManager.requiredAspects.toMutableSet(),
                   private val injector: Injector? = null) : AbstractModule() {


    override fun configure() {
        install(parent)
        bind(aspectReflectionManager.javaClass).toInstance(aspectReflectionManager)

        val lateInitAspects: MutableSet<Class<out Aspect>> = HashSet()
        requiredAspects.forEach { aspect: Class<out Aspect> ->
            if (aspect.isAnnotationPresent(AspectModuleLink::class.java)) {
                val target = injector?.getInstance(aspect.getAnnotation(AspectModuleLink::class.java).target.java)
                install(target)
                lateInitAspects.add(aspect)
            } else {
                if (injector != null) {
                    val instance = injector.getInstance(aspect)
                    bind(instance.javaClass).toInstance(instance)
                }
            }
        }
        requiredAspects.clear()
        requiredAspects.addAll(lateInitAspects)
    }
}
