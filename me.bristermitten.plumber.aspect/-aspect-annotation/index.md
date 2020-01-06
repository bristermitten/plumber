---
title: AspectAnnotation - plumber
---

[plumber](../../index.html) / [me.bristermitten.plumber.aspect](../index.html) / [AspectAnnotation](./index.html)

# AspectAnnotation

`@Target([AnnotationTarget.ANNOTATION_CLASS]) annotation class AspectAnnotation`

Binds an Annotation to an Aspect.

If the annotated annotation is present at all on the classpath,
the given [target](target.html) will be loaded if not already.

### Constructors

| [&lt;init&gt;](-init-.html) | Binds an Annotation to an Aspect.`AspectAnnotation(target: `[`KClass`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html)`<out `[`Aspect`](../-aspect/index.html)`>)` |

### Properties

| [target](target.html) | `val target: `[`KClass`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html)`<out `[`Aspect`](../-aspect/index.html)`>` |

