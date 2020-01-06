---
title: DSLAspect.getModule - plumber
---

[plumber](../../index.html) / [me.bristermitten.plumber.dsl](../index.html) / [DSLAspect](index.html) / [getModule](./get-module.html)

# getModule

`fun getModule(): `[`Module`](https://google.github.io/guice/api-docs/latest/javadoc/com/google/inject/Module.html)

Provide an optional Guice module to be installed.
This is called *after* instantiation of the Aspect so nothing from this module can be used in the Aspect.

Ideally, this should be the only module associated with the Aspect to avoid confusing code structures.
However some Aspects may need 2 modules for configuring bindings into the Aspect itself:

**See Also**

[StaticModule](../../me.bristermitten.plumber.aspect/-static-module/index.html)

