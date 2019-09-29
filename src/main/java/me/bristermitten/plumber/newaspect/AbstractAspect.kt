package me.bristermitten.plumber.newaspect

import com.google.inject.Inject
import com.google.inject.Injector
import com.google.inject.Module
import org.slf4j.LoggerFactory

abstract class AbstractAspect : Aspect {

    protected val logger = LoggerFactory.getLogger(javaClass)

    private var enabled = false

    @Inject
    private lateinit var injector: Injector

    override fun enable() {
        logger.info("Enabling aspect " + javaClass.simpleName)
        doDisable()
        enabled = true
        logger.info("Done")
    }

    override fun disable() {
        logger.info("Disabling aspect " + javaClass.simpleName)
        doDisable()
        enabled = false
        logger.info("Done")
    }

    protected open fun doEnable() {}

    protected open fun doDisable() {}

    override fun module(): Module? = null

    protected fun <T> instance(clazz: Class<T>): T = injector.getInstance(clazz)
}
