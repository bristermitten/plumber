---
title: me.bristermitten.plumber.scheduling - plumber
---

[plumber](../index.html) / [me.bristermitten.plumber.scheduling](./index.html)

## Package me.bristermitten.plumber.scheduling

### Types

| [SchedulerAspect](-scheduler-aspect/index.html) | Aspect that handles the scheduler related functionality of Plumber Currently, all it does is installs the required Assisted Injection factories`class SchedulerAspect : `[`AbstractAspect`](../me.bristermitten.plumber.aspect/-abstract-aspect/index.html) |
| [Task](-task/index.html) | A Task wraps Bukkit's Scheduler system into a single object. Currently, all tasks are ran asynchronously, but this will be improved in the future.`class Task : `[`Runnable`](https://docs.oracle.com/javase/6/docs/api/java/lang/Runnable.html)`, `[`Resettable`](../me.bristermitten.plumber.struct/-resettable/index.html) |
| [TaskFactory](-task-factory/index.html) | Guice Assisted Injection factory for creating instances of [Task](-task/index.html)`interface TaskFactory` |

### Annotations

| [ScheduledTask](-scheduled-task/index.html) | Aspect annotation linking to [SchedulerAspect](-scheduler-aspect/index.html) Currently, does nothing as the scheduler aspect is always loaded`annotation class ScheduledTask` |

