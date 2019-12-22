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

    override fun enable() {
        logger.debug("Enabling aspect " + javaClass.simpleName)
        val length = measureTimeMillis {
            doEnable()
            enabled = true
        }
        logger.debug("Loaded in {} ms", length)
    }

    override fun disable() {
        logger.debug("Disabling aspect " + javaClass.simpleName)
        val length = measureTimeMillis {
            doDisable()
            enabled = false
        }
        logger.debug("Unloaded in {} ms", length)
    }

    protected open fun doEnable() {}

    protected open fun doDisable() {}

    override fun module() = module

    protected open fun loadModule(): Module? = null
    val module: Module? by lazy { loadModule() }

    protected fun <T> instance(clazz: Class<T>): T = injector.getInstance(clazz)
}
