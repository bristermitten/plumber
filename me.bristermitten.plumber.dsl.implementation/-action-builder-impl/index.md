---
title: ActionBuilderImpl - plumber
---

[plumber](../../index.html) / [me.bristermitten.plumber.dsl.implementation](../index.html) / [ActionBuilderImpl](./index.html)

# ActionBuilderImpl

`abstract class ActionBuilderImpl<T : `[`ActionBuilder`](../../me.bristermitten.plumber.dsl/-action-builder/index.html)`<T>> : `[`ActionBuilder`](../../me.bristermitten.plumber.dsl/-action-builder/index.html)`<T>`

Simple implementation of [ActionBuilder](../../me.bristermitten.plumber.dsl/-action-builder/index.html) that holds a parent [TaskLengthConfiguration](../../me.bristermitten.plumber.dsl/-task-length-configuration/index.html)

**Parameters**

### Constructors

| [&lt;init&gt;](-init-.html) | Simple implementation of [ActionBuilder](../../me.bristermitten.plumber.dsl/-action-builder/index.html) that holds a parent [TaskLengthConfiguration](../../me.bristermitten.plumber.dsl/-task-length-configuration/index.html)`ActionBuilderImpl()` |

### Properties

| [parent](parent.html) | `lateinit var parent: `[`TaskLengthConfiguration`](../../me.bristermitten.plumber.dsl/-task-length-configuration/index.html)`<T>` |

### Functions

| [or](or.html) | Returns the parent object for further configuration`open fun or(): `[`TaskLengthConfiguration`](../../me.bristermitten.plumber.dsl/-task-length-configuration/index.html)`<T>` |

### Inheritors

| [PlayerActionBuilderImpl](../-player-action-builder-impl/index.html) | `class PlayerActionBuilderImpl : `[`ActionBuilderImpl`](./index.html)`<`[`PlayerActionBuilder`](../../me.bristermitten.plumber.dsl/-player-action-builder/index.html)`>, `[`PlayerActionBuilder`](../../me.bristermitten.plumber.dsl/-player-action-builder/index.html) |

