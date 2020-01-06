---
title: InjectorHolder - plumber
---

[plumber](../../index.html) / [me.bristermitten.plumber.boot](../index.html) / [InjectorHolder](./index.html)

# InjectorHolder

`class InjectorHolder`

Holder class for Guice's [Injector](#)
Because the current [Injector](#) is modified frequently in Aspect creation, if an
Aspect has an instance of [Injector](#) injected it will not necessarily have every binding required.

For example, if an Aspect is initialised it will be injected with the Injector used to create it.
However, after if installs a module, said injector will not contain the bindings from that module.
One solution would be to re-inject into the Aspect, but this brings a performance toll along with
the inconsistencies that come with mutability. Instead, Aspects should have [InjectorHolder](./index.html) injected
which will carry the latest injector and will be updated after each Aspect's [Aspect.getModule](../../me.bristermitten.plumber.aspect/-aspect/get-module.html) declaration

Instead, Aspects can have this injected to get the latest [Injector](#), which it is guaranteed to always hold.

**Author**
Alexander Wood (BristerMitten)

### Constructors

| [&lt;init&gt;](-init-.html) | Holder class for Guice's [Injector](#) Because the current [Injector](#) is modified frequently in Aspect creation, if an Aspect has an instance of [Injector](#) injected it will not necessarily have every binding required.`InjectorHolder(default: Injector)` |

### Properties

| [injector](injector.html) | `var injector: Injector` |

### Functions

| [lock](lock.html) | `fun lock(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

