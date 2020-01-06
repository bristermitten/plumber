---
title: PPlayerManager.<init> - plumber
---

[plumber](../../index.html) / [me.bristermitten.plumber.struct.player](../index.html) / [PPlayerManager](index.html) / [&lt;init&gt;](./-init-.html)

# &lt;init&gt;

`PPlayerManager(holder: `[`InjectorHolder`](../../me.bristermitten.plumber.boot/-injector-holder/index.html)`)`

Singleton for managing implementations of [PPlayer](../-p-player/index.html) bound to their underlying [Player](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)

Consumers should prioritise obtaining [PPlayer](../-p-player/index.html) instances from commands, events, or other things
rather than manually obtaining instances from [PPlayerManager](index.html)

