---
title: StaticModule.<init> - plumber
---

[plumber](../../index.html) / [me.bristermitten.plumber.aspect](../index.html) / [StaticModule](index.html) / [&lt;init&gt;](./-init-.html)

# &lt;init&gt;

`StaticModule(target: `[`KClass`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html)`<out Module>)`

Only applicable to subclasses of [Aspect](../-aspect/index.html).

Used to configure a static module for an Aspect.
This is useful when an Aspect requires some bindings from Guice to be injected into it.

Normally, injection would happen, and then [Aspect.getModule](../-aspect/get-module.html) would be installed,
but no bindings would exist from the module when the Aspect is created.

This annotation solves that problem.
If an Aspect has it, the given [target](target.html) will be installed first,
and then the Aspect will be injected with the bindings from the module.

