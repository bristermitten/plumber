---
title: AspectConfig - plumber
---

[plumber](../index.html) / [me.bristermitten.plumber.aspect](index.html) / [AspectConfig](./-aspect-config.html)

# AspectConfig

`interface AspectConfig<T : `[`Aspect`](-aspect/index.html)`>`

Configuration interface for an Aspect
Users can extend this to customise functionality for an Aspect
However it is the Aspect's responsibility to get the implementations from [ClassFinder](../me.bristermitten.plumber.reflection/-class-finder/index.html)
and load them into the individual Aspect

Do not use this interface, instead create a subclass that provides the required Type Parameter

### Inheritors

| [CommandAspectConfig](../me.bristermitten.plumber.command/-command-aspect-config/index.html) | `interface CommandAspectConfig : `[`AspectConfig`](./-aspect-config.html)`<`[`CommandAspect`](../me.bristermitten.plumber.command/-command-aspect/index.html)`>` |

