---
title: PPlayerManager - plumber
---

[plumber](../../index.html) / [me.bristermitten.plumber.struct.player](../index.html) / [PPlayerManager](./index.html)

# PPlayerManager

`class PPlayerManager`

Singleton for managing implementations of [PPlayer](../-p-player/index.html) bound to their underlying [Player](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)

Consumers should prioritise obtaining [PPlayer](../-p-player/index.html) instances from commands, events, or other things
rather than manually obtaining instances from [PPlayerManager](./index.html)

### Constructors

| [&lt;init&gt;](-init-.html) | Singleton for managing implementations of [PPlayer](../-p-player/index.html) bound to their underlying [Player](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`PPlayerManager(holder: `[`InjectorHolder`](../../me.bristermitten.plumber.boot/-injector-holder/index.html)`)` |

### Functions

| [of](of.html) | Create or get an instance of [PPlayer](../-p-player/index.html) from a given [UUID](https://docs.oracle.com/javase/6/docs/api/java/util/UUID.html)`fun of(p: `[`UUID`](https://docs.oracle.com/javase/6/docs/api/java/util/UUID.html)`): `[`PPlayer`](../-p-player/index.html) |
| [ofPlayer](of-player.html) | Create or get an instance of [PPlayer](../-p-player/index.html) corresponding to the given [Player](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`fun ofPlayer(p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`): `[`PPlayer`](../-p-player/index.html) |

