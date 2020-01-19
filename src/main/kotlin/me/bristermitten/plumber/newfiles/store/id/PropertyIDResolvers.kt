package me.bristermitten.plumber.newfiles.store.id

import com.google.inject.Inject
import com.google.inject.Singleton
import me.bristermitten.plumber.files.Id
import me.bristermitten.reflector.Reflector
import me.bristermitten.reflector.property.Property

/**
 * @author Alexander Wood (BristerMitten)
 */
@Singleton
class PropertyIDResolvers @Inject constructor(private val reflector: Reflector) {
    private val properties: MutableMap<Class<*>, Property> = HashMap()

    fun <I> resolverFor(type: Class<I>, expectedIDType: Class<*>): IDResolver<I> {
        val property = properties.computeIfAbsent(type) {
            reflector.getStructure(it).searchProperties()
                .byAnnotation(Id::class.java)
                .byType(expectedIDType)
                .search().findFirst().orElseThrow {
                    IllegalArgumentException("$type has no @Id property")
                }
        }
        return PropertyIDResolver(property)
    }
}
