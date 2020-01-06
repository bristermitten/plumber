---
title: MappingType - plumber
---

[plumber](../../index.html) / [me.bristermitten.plumber.files](../index.html) / [MappingType](./index.html)

# MappingType

`@Unstable("Not yet implemented") enum class MappingType`

Methods of mapping data to a backend storage

### Enum Values

| [TWO_WAY](-t-w-o_-w-a-y.html) | Changes to the object affect the storage and vice versa. |
| [ONE_WAY_TO_STORAGE](-o-n-e_-w-a-y_-t-o_-s-t-o-r-a-g-e.html) | Changes to the object affect the storage but after initial loading the object is not changed. |
| [ONE_WAY_FROM_STORAGE](-o-n-e_-w-a-y_-f-r-o-m_-s-t-o-r-a-g-e.html) | Changes to the object do not affect the storage but if the storage changes the object is updated. Only applicable to SQL. |

