---
title: CommonAnnotationTarget - plumber
---

[plumber](../../index.html) / [me.bristermitten.plumber.reflection](../index.html) / [CommonAnnotationTarget](./index.html)

# CommonAnnotationTarget

`enum class CommonAnnotationTarget`

Annotation targets that are possible in both Java and Kotlin.
Some values may be compressed, such as [AnnotationTarget.CONSTRUCTOR](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.annotation/-annotation-target/-c-o-n-s-t-r-u-c-t-o-r/index.html)
which is classed as a Method in ClassGraph so serves no purpose to be standalone

### Enum Values

| [METHOD](-m-e-t-h-o-d.html) | Methods, Constructors or TODO Kotlin setters? |
| [CLASS](-c-l-a-s-s.html) | Any type of Class |
| [FIELD](-f-i-e-l-d.html) | Any field |

