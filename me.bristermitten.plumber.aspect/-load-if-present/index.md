---
title: LoadIfPresent - plumber
---

[plumber](../../index.html) / [me.bristermitten.plumber.aspect](../index.html) / [LoadIfPresent](./index.html)

# LoadIfPresent

`@Target([AnnotationTarget.CLASS]) annotation class LoadIfPresent`

Only applicable to subclasses of [Aspect](../-aspect/index.html).

Similar to [AspectAnnotation](../-aspect-annotation/index.html), this binds an annotation to an Aspect, but the other way around.

If any of the [targets](targets.html) are present at all on the classpath,
the annotated Aspect will be loaded if not already.

This annotation should only be used if the [targets](targets.html) are part of an external library
and cannot be given [AspectAnnotation](../-aspect-annotation/index.html). A good example is ACF's @CommandAlias,
which is third party, cannot be modified, but must be checked for loading the command aspect.

### Constructors

| [&lt;init&gt;](-init-.html) | Only applicable to subclasses of [Aspect](../-aspect/index.html).`LoadIfPresent(vararg targets: `[`KClass`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html)`<out `[`Annotation`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-annotation/index.html)`>)` |

### Properties

| [targets](targets.html) | `vararg val targets: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<out `[`KClass`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html)`<out `[`Annotation`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-annotation/index.html)`>>` |

