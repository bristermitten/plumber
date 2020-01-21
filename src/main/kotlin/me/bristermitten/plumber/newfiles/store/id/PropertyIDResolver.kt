package me.bristermitten.plumber.newfiles.store.id

import me.bristermitten.reflector.property.Property

class PropertyIDResolver<I>(private val property: Property) : IDResolver<I> {


    @Suppress("UNCHECKED_CAST")
    override fun resolveID(value: Any): I {
        return property.getValue(value) as I
    }
}
