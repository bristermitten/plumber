---
title: ComponentAspect - plumber
---

[plumber](../../index.html) / [me.bristermitten.plumber.aspect.component](../index.html) / [ComponentAspect](./index.html)

# ComponentAspect

`@RequiredAspect(-2147483648) class ComponentAspect : `[`AbstractAspect`](../../me.bristermitten.plumber.aspect/-abstract-aspect/index.html)

Required Aspect that facilitates the injection of all [Component](../-component/index.html) classes
They are bound as eager singletons

### Constructors

| [&lt;init&gt;](-init-.html) | Required Aspect that facilitates the injection of all [Component](../-component/index.html) classes They are bound as eager singletons`ComponentAspect()` |

### Functions

| [getModule](get-module.html) | Provide an optional Guice module to be installed. This is called *after* instantiation of the Aspect so nothing from this module can be used in the Aspect.`fun getModule(): `[`Module`](https://google.github.io/guice/api-docs/latest/javadoc/com/google/inject/Module.html) |

