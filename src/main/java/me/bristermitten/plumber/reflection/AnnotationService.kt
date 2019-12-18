package me.bristermitten.plumber.reflection

import com.google.inject.Singleton
import java.lang.annotation.ElementType
import java.lang.annotation.Target
import java.util.*
import kotlin.annotation.Target as KotlinTarget

@Singleton
class AnnotationService {

    fun getAnnotationTargets(annotation: Class<out Annotation>): Set<CommonAnnotationTarget> {
        val kTarget = annotation.getAnnotation(KotlinTarget::class.java)

        if (kTarget != null) {
            return getKotlinAnnotationTargets(kTarget)
        }

        val jTarget = annotation.getAnnotation(Target::class.java)

        if (jTarget != null) {
            return getJDKAnnotationTargets(jTarget)
        }
        return emptySet()
    }


    private fun getKotlinAnnotationTargets(annotation: KotlinTarget): Set<CommonAnnotationTarget> {
        return annotation.allowedTargets.mapNotNull { targetBindings[it] }.toCollection(EnumSet.noneOf(CommonAnnotationTarget::class.java))
    }

    private fun getJDKAnnotationTargets(annotation: Target): Set<CommonAnnotationTarget> {
        return annotation.value.mapNotNull { targetBindings[it] }.toCollection(EnumSet.noneOf(CommonAnnotationTarget::class.java))
    }


    private val targetBindings = mapOf(
            ElementType.TYPE to CommonAnnotationTarget.TYPE,
            AnnotationTarget.TYPE to CommonAnnotationTarget.TYPE,

            ElementType.METHOD to CommonAnnotationTarget.METHOD,
            AnnotationTarget.FUNCTION to CommonAnnotationTarget.METHOD,

            ElementType.CONSTRUCTOR to CommonAnnotationTarget.CONSTRUCTOR,
            AnnotationTarget.CONSTRUCTOR to CommonAnnotationTarget.CONSTRUCTOR,

            ElementType.FIELD to CommonAnnotationTarget.FIELD,
            AnnotationTarget.FIELD to CommonAnnotationTarget.FIELD,
            AnnotationTarget.PROPERTY to CommonAnnotationTarget.FIELD
    )

}

enum class CommonAnnotationTarget {
    METHOD,
    TYPE,
    CONSTRUCTOR,
    FIELD
}
