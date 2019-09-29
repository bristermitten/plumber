package me.bristermitten.plumber.newaspect

import com.google.common.collect.BiMap
import com.google.common.collect.HashBiMap
import com.google.inject.Guice
import com.google.inject.Singleton
import me.bristermitten.plumber.newaspect.modules.AspectModule
import me.bristermitten.plumber.newaspect.modules.InitialModule
import org.reflections.Reflections

@Suppress("UNCHECKED_CAST")
@Singleton
class AspectReflectionManager constructor(private val initialModule: InitialModule, private val reflections: Reflections) {
    private val bindings: BiMap<Class<out Annotation>, Class<out Aspect>> = HashBiMap.create()

    val requiredAspects: Set<Class<out Aspect>> by lazy {
        bindings.keys
                .filter { reflections.getTypesAnnotatedWith(it).isNotEmpty() }
                .mapNotNull { bindings[it] }
                .toSet() +
                reflections.getTypesAnnotatedWith(RequiredAspect::class.java)
                        .filter { it.isAssignableFrom(Aspect::class.java) }
                        .mapNotNull { it as Class<out Aspect> }
    }

    fun loadBaseBindings() {
        if (!bindings.isEmpty()) return
        reflections.getTypesAnnotatedWith(AspectAnnotation::class.java)
                .stream().filter { it.isAnnotation }
                .map { it as Class<out Annotation> }
                .forEach { annotation ->
                    val aa = annotation.getAnnotation(AspectAnnotation::class.java)
                    bindings[annotation] = aa.target.java
                }
    }

    fun addThirdPartyBinding(annotation: Class<out Annotation>, aspect: Class<out Aspect>): AspectReflectionManager {
        bindings[annotation] = aspect
        return this
    }


    fun classesForAspect(aspect: Aspect): Set<Class<*>> {
        val annotation = bindings.inverse()[aspect::class.java]
        return reflections.getTypesAnnotatedWith(annotation)
    }

    fun loadAll() {
        var module = AspectModule(initialModule, this)
        var injector = Guice.createInjector(module)
        val aspectInstances = requiredAspects.mapNotNull {
            injector.getInstance(it)
        }
        val aspects = aspectInstances.mapNotNull(Aspect::module)
        module = AspectModule(initialModule, this, *aspects.toTypedArray())
        injector = Guice.createInjector(module)
        aspectInstances.forEach {
            injector.injectMembers(it)
            it.enable()
        }
    }
}
