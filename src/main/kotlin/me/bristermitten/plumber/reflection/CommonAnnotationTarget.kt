package me.bristermitten.plumber.reflection

/**
 * Annotation targets that are possible in both Java and Kotlin.
 * Some values may be compressed, such as [AnnotationTarget.CONSTRUCTOR]
 * which is classed as a Method in ClassGraph so serves no purpose to be standalone
 */
enum class CommonAnnotationTarget {
    /**
     * Methods, Constructors or TODO Kotlin setters?
     */
    METHOD,
    /**
     * Any type of Class
     */
    CLASS,
    /**
     * Any field
     */
    FIELD
}
