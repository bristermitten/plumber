---
title: TaskFactory - plumber
---

[plumber](../../index.html) / [me.bristermitten.plumber.scheduling](../index.html) / [TaskFactory](./index.html)

# TaskFactory

`interface TaskFactory`

Guice Assisted Injection factory for creating instances of [Task](../-task/index.html)

### Functions

| [create](create.html) | `abstract fun create(delay: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, period: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, run: `[`Runnable`](https://docs.oracle.com/javase/6/docs/api/java/lang/Runnable.html)`): `[`Task`](../-task/index.html)<br>`abstract fun create(delay: `[`Time`](../../me.bristermitten.plumber.scheduling.timings/-time/index.html)`, period: `[`Time`](../../me.bristermitten.plumber.scheduling.timings/-time/index.html)`, run: `[`Runnable`](https://docs.oracle.com/javase/6/docs/api/java/lang/Runnable.html)`): `[`Task`](../-task/index.html) |

