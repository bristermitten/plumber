---
title: getAnnotationTargets - plumber
---

[plumber](../index.html) / [me.bristermitten.plumber.reflection](index.html) / [getAnnotationTargets](./get-annotation-targets.html)

# getAnnotationTargets

`fun getAnnotationTargets(annotation: `[`Class`](https://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<out `[`Annotation`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-annotation/index.html)`>): `[`Set`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)`<`[`CommonAnnotationTarget`](-common-annotation-target/index.html)`>`

Get all of the targets of an Annotation.
This provides compatibility for both Kotlin and Java annotations,
bringing them into a common [CommonAnnotationTarget](-common-annotation-target/index.html)

If the annotation has no explicit target, a set of all [CommonAnnotationTarget](-common-annotation-target/index.html)s will be returned.

### Parameters

`annotation` - The annotation to get the targets of

**Return**
A set of applicable [CommonAnnotationTarget](-common-annotation-target/index.html)s

