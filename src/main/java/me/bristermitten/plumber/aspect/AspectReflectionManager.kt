package me.bristermitten.plumber.aspect

import co.aikar.commands.annotation.CommandAlias
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
import me.bristermitten.plumber.command.CommandAspect
import org.reflections.Reflections
import java.lang.reflect.AnnotatedElement

@Suppress("UNCHECKED_CAST")
@Singleton
class AspectReflectionManager
@Inject constructor(private val initialModule: InitialModule,
                    private val injector: Injector,
                    private val reflections: Reflections) {

    /**
     * A multi map of bindings from [AspectAnnotation] annotation classes to their respective aspects
     */
    private val bindings: Multimap<Class<out Annotation>, Class<out Aspect>> = HashMultimap.create()

    /**
     * The aspects that must be loaded.
     * These are lazily initialised, and made up of
     * 1) Every [RequiredAspect] aspect
     * 2) Any [Aspect] where its [AspectAnnotation](s) are used at all
     */
    val requiredAspects: Set<Class<out Aspect>> by lazy {
        bindings.keys()
                .filter { reflections.getAnyAnnotatedWith(it).isNotEmpty() }
                .flatMap { bindings[it] }
                .toSet() + reflections.getTypesAnnotatedWith(RequiredAspect::class.java)
                .filter { Aspect::class.java.isAssignableFrom(it) }
                .mapNotNull { it as Class<out Aspect> }
    }

    /**
     * Load the aspect bindings.
     * This entails scanning all [AspectAnnotation] annotation classes,
     * getting each one's [AspectAnnotation.target], then adding it to the [bindings] map.
     */
    fun loadBaseBindings() {
        if (!bindings.isEmpty) return
        reflections.getTypesAnnotatedWith(AspectAnnotation::class.java)
                .stream().filter { it.isAnnotation }
                .map { it as Class<out Annotation> }
                .forEach { annotation ->
                    //unlikely but just in case
                    if (bindings.containsKey(annotation)) return@forEach

                    val aa = annotation.getAnnotation(AspectAnnotation::class.java)
                    if (bindings.containsValue(aa.target.java)) return@forEach
                    bindings.put(annotation, aa.target.java)
                }
    }

    /**
     * Add a third party, unofficial aspect binding
     * For example [CommandAlias] is bound to [CommandAspect] by default to ensure that the [CommandAspect] is mapped properly
     * @param annotation the annotation to map
     * @param aspect the aspect to map the annotation to
     */
    fun addThirdPartyBinding(annotation: Class<out Annotation>, aspect: Class<out Aspect>): AspectReflectionManager {
        bindings.put(annotation, aspect)
        return this
    }


    /**
     * Get all the classes associated with an aspect
     * @param aspect the aspect to find classes associated with
     */
    fun classesForAspect(aspect: Aspect): Set<Class<*>> {
        return classesForAspect(aspect::class.java)
    }

    /**
     * Get all the classes associated with an aspect
     * This entails getting all the [AspectAnnotation] annotations that map to the aspect,
     * and finding all classes annotated by one or more of these annotations
     * This is a slow operation and is not cached
     */
    fun classesForAspect(aspect: Class<out Aspect>): Set<Class<*>> {
        val inverse = Multimaps.invertFrom(bindings, HashMultimap.create())
        val annotations = inverse[aspect] ?: emptySet()
        return annotations.flatMap { reflections.getTypesAnnotatedWith(it) }.toSet()
    }

    /**
     * Load all aspects.
     * This is a complex process that can be broken down into steps:
     * 1) Create a new [AspectModule] with the current [InitialModule]. This performs operations detailed in [AspectModule.configure]
     * 2) Create a new injector, and then create a [FinalAspectModule] for aspects that define static modules that must be installed in [AspectModule]
     * 3) Go through every aspect, get its instance, and then enable it.
     * 4) Inject any required data into [plumberPlugin]
     *
     * @param plumberPlugin the plugin instance
     */
    fun loadAll(plumberPlugin: PlumberPlugin) {
        val module = AspectModule(initialModule, this, injector)
        var injector = Guice.createInjector(module)
        val finalModule = FinalAspectModule(module, injector, module.lateAspects)

        injector = Guice.createInjector(module, finalModule)
        requiredAspects.forEach {
            val aspect = injector.getInstance(it)
            aspect.enable()
        }
        injector.injectMembers(plumberPlugin)
    }

    /**
     * Extension function to get any [AnnotatedElement] annotated with a given annotation
     * @param annotation the annotation to look for elements annotated with
     */
    private fun Reflections.getAnyAnnotatedWith(annotation: Class<out Annotation>): Set<AnnotatedElement> {
        return getTypesAnnotatedWith(annotation) +
                getMethodsAnnotatedWith(annotation) +
                getFieldsAnnotatedWith(annotation) +
                getConstructorsAnnotatedWith(annotation)

    }
}
