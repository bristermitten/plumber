---
title: ClassFinder.getClassesWithAnnotationAnywhere - plumber
---

[plumber](../../index.html) / [me.bristermitten.plumber.reflection](../index.html) / [ClassFinder](index.html) / [getClassesWithAnnotationAnywhere](./get-classes-with-annotation-anywhere.html)

# getClassesWithAnnotationAnywhere

`fun getClassesWithAnnotationAnywhere(annotation: `[`Class`](https://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<out `[`Annotation`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-annotation/index.html)`>): `[`Collection`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)`<`[`Class`](https://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<*>>`

Find all [Class](https://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)es with a given annotation in any of their fields, methods, constructors, or the class itself
This checks the [annotation](get-classes-with-annotation-anywhere.html#me.bristermitten.plumber.reflection.ClassFinder$getClassesWithAnnotationAnywhere(java.lang.Class((kotlin.Annotation)))/annotation)'s [Target](https://docs.oracle.com/javase/6/docs/api/java/lang/annotation/Target.html) and only searches applicable elements for speed improvements

### Parameters

`annotation` - the annotation to look for elements annotated with

**Return**
a collection of classes with the given annotation anywhere

