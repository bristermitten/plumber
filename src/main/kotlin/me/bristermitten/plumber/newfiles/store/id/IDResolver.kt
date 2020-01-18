package me.bristermitten.plumber.newfiles.store.id

interface IDResolver<I> {
    fun resolveID(any: Any): I
}
