package me.bristermitten.plumber.newfiles.store.id

import com.google.inject.Inject
import com.google.inject.Singleton
import me.bristermitten.reflector.Reflector
import me.bristermitten.reflector.property.Property
import nonapi.io.github.classgraph.json.Id

/**
 * @author Alexander Wood (BristerMitten)
 */

@Singleton
class PropertyIDResolvers @Inject constructor(private val reflector: Reflector) {
    private val properties: MutableMap<Class<*>, Property> = HashMap()

    fun <I> resolverFor(type: Class<*>, idType: Class<I>): IDResolver<I> {
        val property = properties.computeIfAbsent(type) {
            reflector.getStructure(it).searchProperties()
                .byAnnotation(ID::class.java)
                .byType(idType)
                .search()
                .findFirst().orElseThrow {
                    IllegalArgumentException("$type has no @ID property")
                }
        }
        return PropertyIDResolver(property)
    }
}
