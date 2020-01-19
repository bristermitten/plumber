package me.bristermitten.plumber.newfiles.store.id

import me.bristermitten.reflector.property.Property

class PropertyIDResolver<I> (private val property: Property) :
    IDResolver<I> {


    @Suppress("UNCHECKED_CAST")
    override fun resolveID(any: Any): I {
        val value = property.getValue(any)
        return value as I
    }
}
