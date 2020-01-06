---
title: StorageType.YAML - plumber
---

[plumber](../../index.html) / [me.bristermitten.plumber.files](../index.html) / [StorageType](index.html) / [YAML](./-y-a-m-l.html)

# YAML

`YAML`

Use Gson and SnakeYaml to load and save to a YAML file.
Significantly slower than JSON as because of limitations with generics,
The data is first deserialized by Snakeyaml as [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html),
then serialized to a JSON Tree by Gson, then deserialized to the required type

