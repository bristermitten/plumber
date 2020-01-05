package me.bristermitten.plumber.boot

import com.google.inject.Inject
import com.google.inject.Provider
import io.github.classgraph.ClassGraph

/**
 * Guice [Provider] for [ClassGraph]
 * This lazily initialises the instance, and uses [PlumberInfo] to whitelist packages
 *
 *
 * @author Alexander Wood (BristerMitten)
 */
class ClassGraphProvider @Inject constructor(private val info: PlumberInfo) : Provider<ClassGraph> {

    private val classGraph: ClassGraph by lazy {
        val packages = arrayOf(info.externalPluginPackage, info.plumberPackage)

        ClassGraph()
            //enable method, annotation, and field scanning
            .enableAllInfo()
            //Only scan important packages
            .whitelistPackages(*packages)
            //no need to spend time scanning these
            .disableRuntimeInvisibleAnnotations()
            //No reason to have this
            .disableNestedJarScanning()
            //Gives a significant speed boost and all our classes are already loaded so not necessary
            .disableJarScanning()

    }

    override fun get(): ClassGraph {
        return classGraph
    }
}
