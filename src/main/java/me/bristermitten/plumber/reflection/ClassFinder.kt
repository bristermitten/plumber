@file:Suppress("UNCHECKED_CAST")

package me.bristermitten.plumber.reflection

import com.google.inject.Inject
import com.google.inject.Singleton
import io.github.classgraph.ClassGraph
import io.github.classgraph.ClassInfo
import me.bristermitten.plumber.struct.extension.Extendable
import me.bristermitten.plumber.struct.extension.Extension
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

            if (targets.contains(CommonAnnotationTarget.CLASS))
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

    fun <T> getClassesImplementing(clazz: Class<T>): Collection<Class<out T>> =
            classGraph.scan().use { result ->
                return@use result.getClassesImplementing(clazz.name)
                        .filterNot { it.isAbstract }
                        .map { it.loadClass() as Class<out T> }
            }

    fun <T : Extendable<T, out Extension<T>>> findAllExtensionsFor(clazz: Class<T>): Collection<Class<out Extension<T>>> {
        return classGraph.scan().use { result ->
            return@use result.getClassesImplementing(Extension::class.java.name)
                    .filterNot { info -> info.isInterface }
                    .filter { info ->
                        //here info represents an interface : SomethingExtension : Extension<?>

                        //get the SomethingExtension
                        val extensionSuperInterface = info.interfaces.first {
                            it.implementsInterface(Extension::class.java.name)
                        }

                        //get the Extension<?>
                        val extension = extensionSuperInterface.typeSignature.superinterfaceSignatures.first {
                            it.fullyQualifiedClassName == Extension::class.java.name
                        }
                        //get the ?
                        val typeSignature = extension.typeArguments[0].typeSignature

                        typeSignature.toString() == clazz.name
                    }
                    .map { it.loadClass() as Class<out Extension<T>> }
        }
    }
}
