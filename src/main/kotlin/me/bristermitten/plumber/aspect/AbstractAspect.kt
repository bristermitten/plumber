package me.bristermitten.plumber.aspect

import com.google.inject.Inject
import com.google.inject.Injector
import com.google.inject.Module
import org.slf4j.LoggerFactory
import kotlin.system.measureTimeMillis

/**
 * Boilerplate-handling abstract implementation of [Aspect]
 * Provides logging, enabled-status handling, and a wrapper for Guice's [Injector]
 */
abstract class AbstractAspect : Aspect {

    protected val logger = LoggerFactory.getLogger(javaClass)!!

    private var enabled = false

    @Inject
    private lateinit var injector: Injector

    protected lateinit var classes: Collection<Class<*>>

    override fun enable(classes: Collection<Class<*>>) {
        this.classes = classes

        logger.debug("Enabling aspect {}", javaClass.simpleName)

        val length = measureTimeMillis {
            doEnable()
            enabled = true
        }
        logger.debug("Loaded in {} ms", length)
    }

    override fun disable() {
        classes = emptyList()

        logger.debug("Disabling aspect {}", javaClass.simpleName)

        val length = measureTimeMillis {
            doDisable()
            enabled = false
        }
        logger.debug("Unloaded in {} ms", length)
    }

    protected open fun doDisable() {}
    protected open fun doEnable() {}

    override fun getModule(): Module? = null

    protected fun <T> instance(clazz: Class<T>): T = injector.getInstance(clazz)
    protected inline fun <reified T> instance(): T = instance(T::class.java)
}
