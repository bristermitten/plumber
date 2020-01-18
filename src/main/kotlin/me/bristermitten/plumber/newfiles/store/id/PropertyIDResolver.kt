package me.bristermitten.plumber.newfiles.store.id

import com.google.inject.Inject
import me.bristermitten.plumber.files.Id
import me.bristermitten.reflector.Reflector
import me.bristermitten.reflector.property.Property

class PropertyIDResolver<I> @Inject constructor(private val reflector: Reflector) :
    IDResolver<I> {

    private val properties: MutableMap<Class<*>, Property> = HashMap()

    fun idPropertyFor(data: Any): Property {
        return properties.computeIfAbsent(data.javaClass) {
            reflector.getStructure(it).searchProperties()
                .byAnnotation(Id::class.java)
                .search().findFirst().orElseThrow {
                    IllegalArgumentException("${data.javaClass} has no @Id property")
                }
        }
    }


    override fun resolveID(any: Any): I {
        val value = idPropertyFor(any).getValue(any)
        return value as I
    }
}
