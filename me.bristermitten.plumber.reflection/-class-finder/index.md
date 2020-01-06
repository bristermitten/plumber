---
title: ClassFinder - plumber
---

[plumber](../../index.html) / [me.bristermitten.plumber.reflection](../index.html) / [ClassFinder](./index.html)

# ClassFinder

`class ClassFinder`

Helper that wraps [ClassGraph](#) into a cleaner system and provides
extra functionality

### Constructors

| [&lt;init&gt;](-init-.html) | Helper that wraps [ClassGraph](#) into a cleaner system and provides extra functionality`ClassFinder(plumberPlugin: `[`PlumberPlugin`](../../me.bristermitten.plumber/-plumber-plugin/index.html)`, classGraph: ClassGraph)` |

### Functions

| [findAllExtensionsFor](find-all-extensions-for.html) | `fun <T : `[`Extendable`](../../me.bristermitten.plumber.struct.extension/-extendable/index.html)`<T, out `[`Extension`](../../me.bristermitten.plumber.struct.extension/-extension.html)`<T>>> findAllExtensionsFor(clazz: `[`KClass`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html)`<T>): `[`Collection`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)`<`[`Class`](https://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<out `[`Extension`](../../me.bristermitten.plumber.struct.extension/-extension.html)`<T>>>` |
| [getClassesAnnotatedWith](get-classes-annotated-with.html) | Get all classes that are annotated with the given [annotation](get-classes-annotated-with.html#me.bristermitten.plumber.reflection.ClassFinder$getClassesAnnotatedWith(kotlin.reflect.KClass((kotlin.Annotation)))/annotation) in Kotlin [KClass](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html) format This simply makes calling from Kotlin cleaner as ::class can be used instead of ::class.java`fun getClassesAnnotatedWith(annotation: `[`KClass`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html)`<out `[`Annotation`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-annotation/index.html)`>): `[`Collection`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)`<`[`Class`](https://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<*>>` |
| [getClassesImplementing](get-classes-implementing.html) | Get all classes that implement the given class in Kotlin [KClass](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html) format`fun <T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> getClassesImplementing(clazz: `[`KClass`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html)`<T>): `[`Collection`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)`<`[`Class`](https://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<out T>>` |
| [getClassesWithAnnotationAnywhere](get-classes-with-annotation-anywhere.html) | Find all [Class](https://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)es with a given annotation in any of their fields, methods, constructors, or the class itself This checks the [annotation](get-classes-with-annotation-anywhere.html#me.bristermitten.plumber.reflection.ClassFinder$getClassesWithAnnotationAnywhere(java.lang.Class((kotlin.Annotation)))/annotation)'s [Target](https://docs.oracle.com/javase/6/docs/api/java/lang/annotation/Target.html) and only searches applicable elements for speed improvements`fun getClassesWithAnnotationAnywhere(annotation: `[`Class`](https://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<out `[`Annotation`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-annotation/index.html)`>): `[`Collection`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)`<`[`Class`](https://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<*>>` |
| [getRealClassesImplementing](get-real-classes-implementing.html) | Get all classes that implement the given class in Kotlin [KClass](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html) format, with abstract classes filtered out.`fun <T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> getRealClassesImplementing(clazz: `[`KClass`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html)`<T>): `[`Collection`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)`<`[`Class`](https://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<out T>>` |

### Companion Object Properties

| [SCAN_FILE_NAME](-s-c-a-n_-f-i-l-e_-n-a-m-e.html) | File name for the scan file. This will be looked for in the plugin's resources directory and may not exist, in which case scan results will be computed`const val SCAN_FILE_NAME: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

