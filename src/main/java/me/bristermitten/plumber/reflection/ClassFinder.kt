package me.bristermitten.plumber.reflection

import com.google.inject.Inject
import com.google.inject.Singleton
import io.github.classgraph.ClassGraph
import io.github.classgraph.ClassInfo
import java.lang.annotation.Target

@Singleton
class ClassFinder @Inject constructor(private val classGraph: ClassGraph,
                                      private val annotationService: AnnotationService) {

    /**
     * Find all [Class]es with a given annotation in any of their fields, methods, constructors, or the class itself
     * This checks the [annotation]'s [Target] and only searches applicable elements
     * @param annotation the annotation to look for elements annotated with
     */
    fun getAnyAnnotatedWith(annotation: Class<out Annotation>): Collection<Class<*>> {
        val name = annotation.name
        val targets = annotationService.getAnnotationTargets(annotation)

        classGraph.scan().use {
            val elements = mutableSetOf<ClassInfo>()

            if (targets.contains(CommonAnnotationTarget.FIELD))
                elements.addAll(it.getClassesWithFieldAnnotation(name))

            if (targets.contains(CommonAnnotationTarget.TYPE))
                elements.addAll(it.getClassesWithAnnotation(name))

            if (targets.contains(CommonAnnotationTarget.METHOD) || targets.contains(CommonAnnotationTarget.CONSTRUCTOR)) {
                elements.addAll(it.getClassesWithMethodAnnotation(name))
            }

            return elements.map(ClassInfo::loadClass)
        }
    }

    fun getClassesAnnotatedWith(annotation: Class<out Annotation>): Collection<Class<*>> {
        val name = annotation.name
        classGraph.scan().use {
            return it.getClassesWithAnnotation(name).loadClasses()
        }
    }
}
