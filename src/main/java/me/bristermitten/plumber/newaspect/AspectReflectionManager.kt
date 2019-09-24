package me.bristermitten.plumber.newaspect

import com.google.common.collect.BiMap
import com.google.common.collect.HashBiMap
import com.google.inject.Singleton
import org.reflections.Reflections
import kotlin.reflect.KClass

@Singleton
class AspectReflectionManager(val reflections: Reflections) {


    val bindings: BiMap<KClass<out Annotation>, KClass<out Aspect>> = HashBiMap.create()

    @Suppress("UNCHECKED_CAST")
    fun loadBaseBindings() {
        if (!bindings.isEmpty()) return
        reflections.getTypesAnnotatedWith(AspectAnnotation::class.java)
                .stream().filter { it.isAnnotation }
                .map { it as Class<out Annotation>}
                .forEach { annotation ->
                    val aa = annotation.getAnnotation(AspectAnnotation::class.java)
                    bindings[Reflection.createKotlinClass(annotation)] = aa.target
                }
    }

    fun addThirdPartyBinding()

    fun classesForAspect(aspect: Aspect): Set<Class<*>> {

        return emptySet()
    }
}
