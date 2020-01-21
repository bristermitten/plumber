package me.bristermitten.plumber.newfiles

import com.google.inject.Inject
import com.google.inject.Module
import me.bristermitten.plumber.aspect.AbstractAspect
import me.bristermitten.plumber.aspect.RequiredAspect
import me.bristermitten.plumber.newfiles.store.Store
import me.bristermitten.plumber.newfiles.store.StoreFactory
import me.bristermitten.plumber.newfiles.store.id.IDResolvers
import me.bristermitten.plumber.newfiles.store.id.ResolverConfig
import me.bristermitten.plumber.reflection.ClassFinder
import me.bristermitten.plumber.util.Reflection.createGuiceModule

/**
 * @author Alexander Wood (BristerMitten)
 */
@RequiredAspect
class FilesAspect @Inject constructor(
    private val idResolvers: IDResolvers,
    private val classFinder: ClassFinder,
    private val storeFactory: StoreFactory
) : AbstractAspect() {

    private var stores: Collection<Store<*, *>> = ArrayList()
    override fun doEnable() {

        classFinder.getRealClassesImplementing<ResolverConfig>()
            .map { instance(it) }
            .forEach {
                it.registerResolvers(idResolvers)
            }

        stores = classFinder.getRealClassesImplementing<Store<*, *>>().map {
            @Suppress("UNCHECKED_CAST")
            val clazz = it as Class<out Store<Any, Any>>

            logger.debug("Created implementation for {}", clazz)
            storeFactory.createStoreImplementation(clazz)
        }.toList()
    }

    override fun getModule(): Module {
        return createGuiceModule {
            stores.forEach {
                bind(it.javaClass).toInstance(it)
            }
        }
    }
}
