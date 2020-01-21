package me.bristermitten.plumber.newfiles.store.id

import me.bristermitten.plumber.aspect.AspectConfig
import me.bristermitten.plumber.newfiles.FilesAspect

/**
 * @author Alexander Wood (BristerMitten)
 */
interface ResolverConfig : AspectConfig<FilesAspect> {

    fun registerResolvers(idResolvers: IDResolvers)
}
