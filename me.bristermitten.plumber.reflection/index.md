---
title: me.bristermitten.plumber.reflection - plumber
---

[plumber](../index.html) / [me.bristermitten.plumber.reflection](./index.html)

## Package me.bristermitten.plumber.reflection

### Types

| [ClassFinder](-class-finder/index.html) | Helper that wraps [ClassGraph](#) into a cleaner system and provides extra functionality`class ClassFinder` |
| [CommonAnnotationTarget](-common-annotation-target/index.html) | Annotation targets that are possible in both Java and Kotlin. Some values may be compressed, such as [AnnotationTarget.CONSTRUCTOR](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.annotation/-annotation-target/-c-o-n-s-t-r-u-c-t-o-r/index.html) which is classed as a Method in ClassGraph so serves no purpose to be standalone`enum class CommonAnnotationTarget` |

### Functions

| [getAnnotationTargets](get-annotation-targets.html) | Get all of the targets of an Annotation. This provides compatibility for both Kotlin and Java annotations, bringing them into a common [CommonAnnotationTarget](-common-annotation-target/index.html)`fun getAnnotationTargets(annotation: `[`Class`](https://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<out `[`Annotation`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-annotation/index.html)`>): `[`Set`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)`<`[`CommonAnnotationTarget`](-common-annotation-target/index.html)`>` |

