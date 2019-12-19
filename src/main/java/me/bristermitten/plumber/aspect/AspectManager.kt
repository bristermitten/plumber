package me.bristermitten.plumber.aspect

import com.google.common.collect.HashMultimap
import com.google.common.collect.Multimap
import com.google.common.collect.Multimaps
import com.google.inject.Guice
import com.google.inject.Inject
import com.google.inject.Injector
import com.google.inject.Singleton
import io.github.classgraph.ClassGraph
import me.bristermitten.plumber.PlumberPlugin
import me.bristermitten.plumber.aspect.modules.AspectModule
import me.bristermitten.plumber.aspect.modules.FinalAspectModule
import me.bristermitten.plumber.aspect.modules.InitialModule
import me.bristermitten.plumber.reflection.ClassFinder

@Suppress("UNCHECKED_CAST")
@Singleton
class AspectManager
@Inject constructor(private val initialModule: InitialModule,
                    private val injector: Injector,
                    private val classGraph: ClassGraph,
                    private val classFinder: ClassFinder) {

    /**
     * A multimap of bindings from [AspectAnnotation] annotation classes to their respective aspects
     * This is a multimap because many annotations can point to the same aspect,
     * and when inverted this
     */
    private val bindings: Multimap<Class<out Annotation>, Class<out Aspect>> = HashMultimap.create()

    /**
     * The aspects that must be loaded for Plumber to function as intended
     * These consist of:
     * 1) Any [Aspect] where its [AspectAnnotation](s) are used at all
     * 2) Every [Aspect] class annotated by [RequiredAspect]
     */
    val requiredAspects: Set<Class<out Aspect>> by lazy {
        classGraph.scan().use { scan ->
            bindings.keys()
                    .filter { classFinder.getAnyAnnotatedWith(it).isNotEmpty() }
                    .flatMap { bindings[it] }.toSet() +
                    scan.getClassesWithAnnotation(RequiredAspect::class.java.name)
                            .filter { it.implementsInterface(Aspect::class.java.name) }
                            .mapNotNull { it.loadClass() as Class<out Aspect> }
        }
    }

    /**
     * Load the aspect bindings.
     * This entails finding all [AspectAnnotation] annotation classes,
     * getting each one's [AspectAnnotation.target], then adding it to the [bindings] map.
     *
     */
    fun loadBaseBindings() {
        if (!bindings.isEmpty) return

        classFinder.getClassesAnnotatedWith(AspectAnnotation::class.java)
                .filter { it.isAnnotation }
                .map { it as Class<out Annotation> }
                .forEach { annotation ->
                    val aa = annotation.getAnnotation(AspectAnnotation::class.java)
                    bindings.put(annotation, aa.target.java)
                }

        classFinder.getClassesAnnotatedWith(ThirdPartyAspectBinding::class.java)
                .filter {
                    Aspect::class.java.isAssignableFrom(it)
                }.map {
                    it as Class<out Aspect> to it.getAnnotation(ThirdPartyAspectBinding::class.java)
                }
                .forEach {
                    it.second.targets.forEach { target ->
                        bindings.put(target.java, it.first)
                    }
                }
    }

    /**
     * Add a third party, unofficial aspect binding
     * This will ensure that if the given [annotation] is present at all then the given [aspect] will be loaded
     * @param annotation the annotation to map
     * @param aspect the aspect to map the annotation to
     */
    fun addThirdPartyBinding(annotation: Class<out Annotation>, aspect: Class<out Aspect>): AspectManager {
        bindings.put(annotation, aspect)
        return this
    }


    /**
     * Get all the classes associated with an aspect
     * @param aspect the aspect to find classes associated with
     */
    fun classesForAspect(aspect: Aspect): Collection<Class<*>> {
        return classesForAspect(aspect.javaClass)
    }

    /**.
     * Get all the classes associated with an aspect
     * This entails getting all the [AspectAnnotation] annotations that map to the aspect,
     * and finding all classes annotated by one or more of these annotations
     * This is a slow operation and is not cached, so bear that in mind when calling
     */
    fun classesForAspect(aspect: Class<out Aspect>): Collection<Class<*>> {
        val inverse = Multimaps.invertFrom(bindings, HashMultimap.create())

        val annotations = inverse[aspect] ?: return emptySet()
        if (annotations.isEmpty()) return emptySet()

        return annotations.flatMap { classFinder.getAnyAnnotatedWith(it) }
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

}
