---
title: CommandAspect - plumber
---

[plumber](../../index.html) / [me.bristermitten.plumber.command](../index.html) / [CommandAspect](./index.html)

# CommandAspect

`@LoadIfPresent([CommandAlias]) class CommandAspect : `[`AbstractAspect`](../../me.bristermitten.plumber.aspect/-abstract-aspect/index.html)

Internal aspect that handles the scanning of command classes, and the registration of such classes

### Constructors

| [&lt;init&gt;](-init-.html) | Internal aspect that handles the scanning of command classes, and the registration of such classes`CommandAspect(plumberPlugin: `[`PlumberPlugin`](../../me.bristermitten.plumber/-plumber-plugin/index.html)`, manager: `[`PPlayerManager`](../../me.bristermitten.plumber.struct.player/-p-player-manager/index.html)`, classFinder: `[`ClassFinder`](../../me.bristermitten.plumber.reflection/-class-finder/index.html)`, reflector: Reflector)` |

### Functions

| [doDisable](do-disable.html) | Disable the aspect, unregistering all commands`fun doDisable(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [doEnable](do-enable.html) | Enable the aspect, causing the creation of a [PaperCommandManager](#), and the registration of all required commands.`fun doEnable(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [getModule](get-module.html) | Provide an optional Guice module to be installed. This is called *after* instantiation of the Aspect so nothing from this module can be used in the Aspect.`fun getModule(): Module` |

