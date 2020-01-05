package me.bristermitten.plumber.reflection

import java.lang.annotation.ElementType
import java.util.*
import java.lang.annotation.Target as JDKTarget
import kotlin.annotation.Target as KotlinTarget


private val ALL_COMMON_TARGETS = EnumSet.allOf(CommonAnnotationTarget::class.java)
private val NO_COMMON_TARGETS = EnumSet.noneOf(CommonAnnotationTarget::class.java)
/**
 * Get all of the targets of an Annotation.
 * This provides compatibility for both Kotlin and Java annotations,
 * bringing them into a common [CommonAnnotationTarget]
 *
 * If the annotation has no explicit target, a set of all [CommonAnnotationTarget]s will be returned.
 *
 * @param annotation The annotation to get the targets of
 * @return A set of applicable [CommonAnnotationTarget]s
 */
fun getAnnotationTargets(annotation: Class<out Annotation>): Set<CommonAnnotationTarget> {
    val kotlinTarget = annotation.getAnnotation(KotlinTarget::class.java)

    if (kotlinTarget != null) {
        return getKotlinAnnotationTargets(kotlinTarget)
    }

    val javaTarget = annotation.getAnnotation(JDKTarget::class.java)

    if (javaTarget != null) {
        return getJDKAnnotationTargets(javaTarget)
    }

    return EnumSet.copyOf(ALL_COMMON_TARGETS)
}


/**
 * Get the Annotation Targets for a Kotlin based annotation.
 * @param annotation A [KotlinTarget] annotation
 * @return a set of [CommonAnnotationTarget]s that match the targets
 */
private fun getKotlinAnnotationTargets(annotation: KotlinTarget): Set<CommonAnnotationTarget> {
    return annotation.allowedTargets
        .mapNotNull { targetBindings[it] }
        .toCollection(EnumSet.copyOf(NO_COMMON_TARGETS))
}
/**
 * Get the Annotation Targets for a JDK based annotation.
 * @param annotation A [JDKTarget] annotation
 * @return a set of [CommonAnnotationTarget]s that match the targets
 */
private fun getJDKAnnotationTargets(annotation: JDKTarget): Set<CommonAnnotationTarget> {
    return annotation.value
        .mapNotNull { targetBindings[it] }
        .toCollection(EnumSet.copyOf(NO_COMMON_TARGETS))
}


/**
 * Map binding both Kotlin and Java annotation target
 * types to [CommonAnnotationTarget].
 */
private val targetBindings = mapOf(
    ElementType.TYPE to CommonAnnotationTarget.CLASS,
    AnnotationTarget.CLASS to CommonAnnotationTarget.CLASS,

    ElementType.METHOD to CommonAnnotationTarget.METHOD,
    AnnotationTarget.FUNCTION to CommonAnnotationTarget.METHOD,
    ElementType.CONSTRUCTOR to CommonAnnotationTarget.METHOD,
    AnnotationTarget.CONSTRUCTOR to CommonAnnotationTarget.METHOD,

    ElementType.FIELD to CommonAnnotationTarget.FIELD,
    AnnotationTarget.FIELD to CommonAnnotationTarget.FIELD,
    AnnotationTarget.PROPERTY to CommonAnnotationTarget.FIELD
)
