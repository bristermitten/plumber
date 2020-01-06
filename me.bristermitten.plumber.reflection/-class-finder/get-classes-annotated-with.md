---
title: ClassFinder.getClassesAnnotatedWith - plumber
---

[plumber](../../index.html) / [me.bristermitten.plumber.reflection](../index.html) / [ClassFinder](index.html) / [getClassesAnnotatedWith](./get-classes-annotated-with.html)

# getClassesAnnotatedWith

`fun getClassesAnnotatedWith(annotation: `[`KClass`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html)`<out `[`Annotation`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-annotation/index.html)`>): `[`Collection`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)`<`[`Class`](https://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<*>>`

Get all classes that are annotated with the given [annotation](get-classes-annotated-with.html#me.bristermitten.plumber.reflection.ClassFinder$getClassesAnnotatedWith(kotlin.reflect.KClass((kotlin.Annotation)))/annotation) in Kotlin [KClass](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html) format
This simply makes calling from Kotlin cleaner as ::class can be used instead of ::class.java

### Parameters

`annotation` - the Kotlin annotation class

**Return**
a collection of classes annotated with the given annotation

