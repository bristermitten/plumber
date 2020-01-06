---
title: me.bristermitten.plumber.aspect - plumber
---

[plumber](../index.html) / [me.bristermitten.plumber.aspect](./index.html)

## Package me.bristermitten.plumber.aspect

### Types

| [AbstractAspect](-abstract-aspect/index.html) | Boilerplate-handling abstract implementation of [Aspect](-aspect/index.html) Provides logging, enabled-status handling, and a wrapper for Guice's [Injector](https://google.github.io/guice/api-docs/latest/javadoc/com/google/inject/Injector.html)`abstract class AbstractAspect : `[`Aspect`](-aspect/index.html) |
| [Aspect](-aspect/index.html) | A section of Plumber's functionality, for example, command handling or file management An Aspect should be considered the parent of this section, and manage dependency injection and initial setup`interface Aspect` |
| [AspectConfig](-aspect-config.html) | Configuration interface for an Aspect Users can extend this to customise functionality for an Aspect However it is the Aspect's responsibility to get the implementations from [ClassFinder](../me.bristermitten.plumber.reflection/-class-finder/index.html) and load them into the individual Aspect`interface AspectConfig<T : `[`Aspect`](-aspect/index.html)`>` |

### Annotations

| [AspectAnnotation](-aspect-annotation/index.html) | Binds an Annotation to an Aspect.`annotation class AspectAnnotation` |
| [LoadIfPresent](-load-if-present/index.html) | Only applicable to subclasses of [Aspect](-aspect/index.html).`annotation class LoadIfPresent` |
| [RequiredAspect](-required-aspect/index.html) | Only applicable to subclasses of [Aspect](-aspect/index.html).`annotation class RequiredAspect` |
| [StaticModule](-static-module/index.html) | Only applicable to subclasses of [Aspect](-aspect/index.html).`annotation class StaticModule` |

