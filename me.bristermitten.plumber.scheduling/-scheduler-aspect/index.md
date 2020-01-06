---
title: SchedulerAspect - plumber
---

[plumber](../../index.html) / [me.bristermitten.plumber.scheduling](../index.html) / [SchedulerAspect](./index.html)

# SchedulerAspect

`@RequiredAspect(10) class SchedulerAspect : `[`AbstractAspect`](../../me.bristermitten.plumber.aspect/-abstract-aspect/index.html)

Aspect that handles the scheduler related functionality of Plumber
Currently, all it does is installs the required Assisted Injection factories

### Constructors

| [&lt;init&gt;](-init-.html) | Aspect that handles the scheduler related functionality of Plumber Currently, all it does is installs the required Assisted Injection factories`SchedulerAspect()` |

### Functions

| [getModule](get-module.html) | Provide an optional Guice module to be installed. This is called *after* instantiation of the Aspect so nothing from this module can be used in the Aspect.`fun getModule(): Module` |

