package me.bristermitten.plumber.aspect

import com.google.common.collect.HashMultimap
import com.google.common.collect.Multimap
import com.google.common.collect.Multimaps
import com.google.inject.Guice
import com.google.inject.Inject
import com.google.inject.Injector
import com.google.inject.Singleton
import me.bristermitten.plumber.PlumberPlugin
import me.bristermitten.plumber.aspect.modules.AspectModule
import me.bristermitten.plumber.aspect.modules.FinalAspectModule
import me.bristermitten.plumber.aspect.modules.InitialModule
import org.reflections.Reflections
import java.lang.reflect.AnnotatedElement

@Suppress("UNCHECKED_CAST")
@Singleton
class AspectReflectionManager @Inject constructor(
        private val initialModule: InitialModule,
        private val injector: Injector,
        private val reflections: Reflections
) {
    private val bindings: Multimap<Class<out Annotation>, Class<out Aspect>> =
            HashMultimap.create()

    val requiredAspects: Set<Class<out Aspect>> by lazy {
        bindings.keys()
                .filter { reflections.getAnyAnnotatedWith(it).isNotEmpty() }
                .flatMap { bindings[it] }
                .toSet() +
                reflections.getTypesAnnotatedWith(RequiredAspect::class.java)
                        .filter { Aspect::class.java.isAssignableFrom(it) }
                        .mapNotNull { it as Class<out Aspect> }
                        .toSet()
    }

    fun loadBaseBindings() {
        if (!bindings.isEmpty) return
        reflections.getTypesAnnotatedWith(AspectAnnotation::class.java)
                .stream().filter { it.isAnnotation }
                .map { it as Class<out Annotation> }
                .forEach { annotation ->
                    val aa = annotation.getAnnotation(AspectAnnotation::class.java)
                    if (bindings.containsKey(annotation)) return@forEach
                    if (bindings.containsValue(aa.target.java)) return@forEach
                    bindings.put(annotation, aa.target.java)
                }
    }

    fun addThirdPartyBinding(annotation: Class<out Annotation>, aspect: Class<out Aspect>): AspectReflectionManager {
        bindings.put(annotation, aspect)
        return this
    }


    fun classesForAspect(aspect: Aspect): Set<Class<*>> {
        return classesForAspect(aspect::class.java)
    }

    fun classesForAspect(aspect: Class<out Aspect>): Set<Class<*>> {
        val inverse = Multimaps.invertFrom(bindings, HashMultimap.create())
        val annotations = inverse[aspect] ?: return emptySet()
        return annotations.flatMap {
            reflections.getTypesAnnotatedWith(it)
        }.toSet()
    }

    fun loadAll(plumberPlugin: PlumberPlugin) {
        val module = AspectModule(initialModule, this, injector = injector)
        var injector = Guice.createInjector(module)

        println(requiredAspects)
        val finalModule = FinalAspectModule(module, injector, module.requiredAspects)
        injector = Guice.createInjector(finalModule)


        requiredAspects.forEach {
            val aspect = injector.getInstance(it)
            aspect.enable()
        }
        injector.injectMembers(plumberPlugin)
    }

    private fun Reflections.getAnyAnnotatedWith(annotation: Class<out Annotation>): Set<AnnotatedElement> {
        return getTypesAnnotatedWith(annotation) +
                getMethodsAnnotatedWith(annotation) +
                getFieldsAnnotatedWith(annotation) +
                getConstructorsAnnotatedWith(annotation)

    }
}
