package me.bristermitten.plumber.newaspect

import com.google.inject.Guice
import dev.misfitlabs.kotlinguice4.KotlinModule
import io.github.classgraph.ClassGraph
import me.bristermitten.plumber.PlumberPlugin
import me.bristermitten.plumber.reflection.ClassFinder

class PlumberLoader {

    fun loadPlumber(plumberPlugin: PlumberPlugin) {
        val externalPluginPackage = plumberPlugin.javaClass.`package`.name
        val plumberPackage = PlumberPlugin::class.java.`package`.name

        val packages = arrayOf(externalPluginPackage, plumberPackage)

        val classGraph = ClassGraph()
                .enableAllInfo()
                .whitelistPackages(*packages)
                .disableRuntimeInvisibleAnnotations()

        var injector = Guice.createInjector(object : KotlinModule() {
            override fun configure() {
                bind<ClassGraph>().toInstance(classGraph)
            }
        })

        val classFinder = injector.getInstance(ClassFinder::class.java)

        classFinder.getClassesImplementing(Aspect::class.java)
                .filter {
                    it.isAnnotationPresent(RequiredAspect::class.java)
                }
                .sortedByDescending { it.getAnnotation(RequiredAspect::class.java).priority }
                .map {
                    val instance = injector.getInstance(it)
                    instance.enable()
                    val module = instance.module()
                    if (module != null)
                        injector = injector.createChildInjector(module)
                }
    }
}
