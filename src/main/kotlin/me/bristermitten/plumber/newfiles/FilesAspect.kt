package me.bristermitten.plumber.newfiles

import com.google.inject.Inject
import com.google.inject.Module
import me.bristermitten.plumber.aspect.AbstractAspect
import me.bristermitten.plumber.aspect.RequiredAspect
import me.bristermitten.plumber.newfiles.store.Store
import me.bristermitten.plumber.newfiles.store.StoreFactory
import me.bristermitten.plumber.newfiles.store.StoreProxyHandler
import me.bristermitten.plumber.newfiles.store.id.IDResolvers
import me.bristermitten.plumber.newfiles.store.id.ResolverConfig
import me.bristermitten.plumber.reflection.ClassFinder
import me.bristermitten.plumber.util.Reflection.createGuiceModule
import java.lang.reflect.Proxy
import kotlin.streams.toList

/**
 * @author Alexander Wood (BristerMitten)
 */
@RequiredAspect
class FilesAspect @Inject constructor(
    private val idResolvers: IDResolvers,
    private val classFinder: ClassFinder,
    private val storeFactory: StoreFactory,
    private val classLoader: ClassLoader
) : AbstractAspect() {

    private var stores: Collection<Store<*, *>> = ArrayList()

    override fun doEnable() {

        classFinder.getRealClassesImplementing<ResolverConfig>()
            .map { instance(it) }
            .forEach {
                it.registerResolvers(idResolvers)
            }

        stores = classFinder.getClassesImplementing<Store<*, *>>()
            .parallelStream().map {
                @Suppress("UNCHECKED_CAST")
                val clazz = it as Class<Store<Any, Any>>

                logger.debug("Created implementation for {}", clazz)
                storeFactory.createStoreImplementation(clazz)
            }.toList()
    }

    override fun getModule(): Module {
        return createGuiceModule {
            for (store in stores) {

                val handler = Proxy.getInvocationHandler(store)
                if (handler !is StoreProxyHandler<*, *>) continue

                @Suppress("UNCHECKED_CAST") val storeClass = handler.proxying as Class<Store<*, *>>

                bind(storeClass).toInstance(store)
            }
        }
    }
}
