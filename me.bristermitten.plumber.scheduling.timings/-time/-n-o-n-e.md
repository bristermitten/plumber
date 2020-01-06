---
title: Time.NONE - plumber
---

[plumber](../../index.html) / [me.bristermitten.plumber.scheduling.timings](../index.html) / [Time](index.html) / [NONE](./-n-o-n-e.html)

# NONE

`val NONE: `[`Time`](index.html)

No time. Internally equal to -1 seconds, but should result in the number
being ignored. For example, in [me.bristermitten.plumber.scheduling.Task](../../me.bristermitten.plumber.scheduling/-task/index.html) if the period
is [NONE](./-n-o-n-e.html), then a task is scheduled as only running once, whereas a period of [EMPTY](-e-m-p-t-y.html)
may cause the event to repeatedly run as the delay between execution is 0 ticks

