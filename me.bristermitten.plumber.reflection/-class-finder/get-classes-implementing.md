---
title: ClassFinder.getClassesImplementing - plumber
---

[plumber](../../index.html) / [me.bristermitten.plumber.reflection](../index.html) / [ClassFinder](index.html) / [getClassesImplementing](./get-classes-implementing.html)

# getClassesImplementing

`fun <T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> getClassesImplementing(clazz: `[`KClass`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html)`<T>): `[`Collection`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)`<`[`Class`](https://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<out T>>`

Get all classes that implement the given class in Kotlin [KClass](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html) format

This simply makes calling from Kotlin cleaner as ::class can be used instead of ::class.java
but will also load the classes into Java [Class](https://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)es with the inferred type parameters

