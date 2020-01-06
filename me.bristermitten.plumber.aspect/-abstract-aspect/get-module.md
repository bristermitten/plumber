---
title: AbstractAspect.getModule - plumber
---

[plumber](../../index.html) / [me.bristermitten.plumber.aspect](../index.html) / [AbstractAspect](index.html) / [getModule](./get-module.html)

# getModule

`open fun getModule(): Module?`

Provide an optional Guice module to be installed.
This is called *after* instantiation of the Aspect so nothing from this module can be used in the Aspect.

Ideally, this should be the only module associated with the Aspect to avoid confusing code structures.
However some Aspects may need 2 modules for configuring bindings into the Aspect itself:

**See Also**

[StaticModule](../-static-module/index.html)

