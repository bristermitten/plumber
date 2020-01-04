package me.bristermitten.plumber.aspect

import com.google.inject.Inject
import com.google.inject.Singleton
import me.bristermitten.plumber.PlumberPlugin
import me.bristermitten.plumber.reflection.ClassFinder

/**
 * Holds info about the running Plumber instance.
 * Currently, this only includes the package name of the [PlumberPlugin] implementation
 * for [ClassFinder], but may have more in the future.
 *
 * TODO - I'm not a fan of this class's coupling with [PlumberPlugin], however this approach seems cleaner than
 *   - requiring it to be created in [PlumberLoader] or something similar. Ideas would be appreciated
 *
 * @author Alexander Wood (BristerMitten)
 */
@Singleton
class PlumberInfo {

    /**
     * For mocking.
     */
    constructor(externalPackage: String) {
        this.externalPluginPackage = externalPackage
    }

    @Inject
    constructor(plumberPlugin: PlumberPlugin) {
        this.externalPluginPackage = plumberPlugin.javaClass.packageName
    }

    /**
     * The external plugin's package (eg me.author.plugin)
     */
    val externalPluginPackage: String
    /**
     * Plumber's package for internals
     */
    val plumberPackage: String = PlumberPlugin::class.java.packageName
}
