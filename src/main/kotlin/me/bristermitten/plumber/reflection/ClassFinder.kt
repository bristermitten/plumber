@file:Suppress("UNCHECKED_CAST")

package me.bristermitten.plumber.reflection

import com.google.inject.Inject
import com.google.inject.Singleton
import io.github.classgraph.ClassGraph
import io.github.classgraph.ClassInfo
import io.github.classgraph.ScanResult
import me.bristermitten.plumber.PlumberPlugin
import me.bristermitten.plumber.struct.extension.Extendable
import me.bristermitten.plumber.struct.extension.Extension
import java.lang.annotation.Target
import kotlin.reflect.KClass

/**
 * Helper that wraps [ClassGraph] into a cleaner system and provides
 * extra functionality
 */
@Singleton
class ClassFinder @Inject constructor(
    private val plumberPlugin: PlumberPlugin,
    private val classGraph: ClassGraph
) {

    companion object {
        /**
         * File name for the scan file. This will be looked for in the plugin's resources directory
         * and may not exist, in which case scan results will be computed
         */
        const val SCAN_FILE_NAME = "classes.json"
    }


    fun <T : Extendable<T, out Extension<T>>> findAllExtensionsFor(clazz: KClass<T>): Collection<Class<out Extension<T>>> {
        scan {
            return getClassesImplementing(Extension::class.java.name)
                .filterNot { info -> info.isAbstract }
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

                    typeSignature.toString() == clazz.qualifiedName
                }
                .map { it.loadClass() as Class<out Extension<T>> }
        }
    }

    /**
     * Find all [Class]es with a given annotation in any of their fields, methods, constructors, or the class itself
     * This checks the [annotation]'s [Target] and only searches applicable elements for speed improvements
     *
     * @param annotation the annotation to look for elements annotated with
     * @return a collection of classes with the given annotation anywhere
     */
    fun getClassesWithAnnotationAnywhere(annotation: Class<out Annotation>): Collection<Class<*>> {

        val name = annotation.name

        val targets = getAnnotationTargets(annotation)

        scan {
            val elements = mutableSetOf<ClassInfo>()

            if (targets.contains(CommonAnnotationTarget.FIELD))
                elements.addAll(getClassesWithFieldAnnotation(name))

            if (targets.contains(CommonAnnotationTarget.CLASS))
                elements.addAll(getClassesWithAnnotation(name))

            if (targets.contains(CommonAnnotationTarget.METHOD)) {
                elements.addAll(getClassesWithMethodAnnotation(name))
            }

            return elements.map(ClassInfo::loadClass)
        }
    }

    /**
     * Get all classes that are annotated with the given [annotation] in Kotlin [KClass] format
     * This simply makes calling from Kotlin cleaner as ::class can be used instead of ::class.java
     *
     * @param annotation the Kotlin annotation class
     * @return a collection of classes annotated with the given annotation
     */
    fun getClassesAnnotatedWith(annotation: KClass<out Annotation>): Collection<Class<*>> {
        val name = annotation.qualifiedName
        return scan {
            getClassesWithAnnotation(name).loadClasses()
        }
    }

    /**
     * Get all classes that implement the given class in Kotlin [KClass] format
     *
     * This simply makes calling from Kotlin cleaner as ::class can be used instead of ::class.java
     * but will also load the classes into Java [Class]es with the inferred type parameters
     */
    fun <T : Any> getClassesImplementing(clazz: KClass<T>): Collection<Class<out T>> {
        val name = clazz.qualifiedName

        return scan {
            getClassesImplementing(name).loadClasses().map { it as Class<out T> }
        }
    }

    /**
     * Get all classes that implement the given class in Kotlin [KClass] format,
     * with abstract classes filtered out.
     *
     * This simply makes calling from Kotlin cleaner as ::class can be used instead of ::class.java
     * but will also load the classes into Java [Class]es with the inferred type parameters
     */
    fun <T : Any> getRealClassesImplementing(clazz: KClass<T>): Collection<Class<out T>> {
        val name = clazz.qualifiedName

        return scan {
            getClassesImplementing(name).filterNot { it.isAbstract }.map { it.loadClass() as Class<out T> }
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

    /**
     * The contents of our [SCAN_FILE_NAME] file, if it exists
     * This is lazily evaluated by reading the file once if it exists, otherwise it will be null.
     */
    private var scanFileContents: String? = null
        get() {
            if (field != null) return field
            val file = plumberPlugin.getResource(SCAN_FILE_NAME) ?: return null
            file.use {
                field = String(it.readBytes())
            }
            return field
        }

    /**
     * Helper function for ClassGraph's [ClassGraph.scan] that
     * will use a file-based scan result if possible, and will
     * automatically close the result
     */
    private inline fun <T> scan(receiver: ScanResult.() -> T): T {
        val fileContents = scanFileContents

        val scan: ScanResult = if (fileContents != null)
            ScanResult.fromJSON(fileContents)
        else
            classGraph.scan()

        return scan.use(receiver)
    }

}
