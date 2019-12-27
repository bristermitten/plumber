@file:Suppress("UNCHECKED_CAST")

package me.bristermitten.plumber.reflection

import com.google.inject.Inject
import com.google.inject.Singleton
import io.github.classgraph.ClassGraph
import io.github.classgraph.ClassInfo
import io.github.classgraph.ScanResult
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

        scan {
            val elements = mutableSetOf<ClassInfo>()

            if (targets.contains(CommonAnnotationTarget.FIELD))
                elements.addAll(getClassesWithFieldAnnotation(name))

            if (targets.contains(CommonAnnotationTarget.CLASS))
                elements.addAll(getClassesWithAnnotation(name))

            if (targets.contains(CommonAnnotationTarget.METHOD) || targets.contains(CommonAnnotationTarget.CONSTRUCTOR)) {
                elements.addAll(getClassesWithMethodAnnotation(name))
            }

            return elements.map(ClassInfo::loadClass)
        }
    }

    fun getClassesAnnotatedWith(annotation: Class<out Annotation>): Collection<Class<*>> {
        val name = annotation.name
        return scan {
            getClassesWithAnnotation(name).loadClasses()
        }
    }

    fun <T> getClassesImplementing(clazz: Class<T>): Collection<Class<out T>> {
        val name = clazz.name
        return scan {
            getClassesImplementing(name).map { it.loadClass() as Class<out T> }
        }
    }
//    fun <T : Extendable<T, out Extension<T>>> findAllExtensionsFor(clazz: Class<T>): Collection<Class<out Extension<T>>> {
//        return classGraph.scan().use { result ->
//            result.getClassesImplementing(Extension::class.java.name)
//                    .filterNot { info -> info.isInterface }
//                    .filter { info ->
//                        //here info represents an interface : SomethingExtension : Extension<?>
//
//                        //get the SomethingExtension
//                        val extensionSuperInterface = info.interfaces.first {
//                            it.implementsInterface(Extension::class.java.name)
//                        }
//
//                        //get the Extension<?>
//                        val extension = extensionSuperInterface.typeSignature.superinterfaceSignatures.first {
//                            it.fullyQualifiedClassName == Extension::class.java.name
//                        }
//                        //get the ?
//                        val typeSignature = extension.typeArguments[0].typeSignature
//
//                        typeSignature.toString() == clazz.name
//                    }
//                    .map { it.loadClass() as Class<out Extension<T>> }
//        }
//    }

    private inline fun <T> scan(receiver: ScanResult.() -> T): T {
        return classGraph.scan().use(receiver)
    }
}
