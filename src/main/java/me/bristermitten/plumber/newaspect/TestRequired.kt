package me.bristermitten.plumber.newaspect

import com.google.inject.Inject
import com.google.inject.Module
import dev.misfitlabs.kotlinguice4.KotlinModule
import org.slf4j.LoggerFactory

@RequiredAspect
class TestRequired : Aspect {
    private val logger = LoggerFactory.getLogger(javaClass)
    override fun enable() {
        logger.info("Enabled")
    }

    override fun disable() {

    }

    override fun module(): Module? {
        return object : KotlinModule() {
            override fun configure() {
                bind<Int>().toInstance(3)
            }
        }
    }
}

@RequiredAspect
class TestRequired2 @Inject constructor(val int: Int) : Aspect {
    private val logger = LoggerFactory.getLogger(javaClass)
    override fun enable() {
        logger.info("Enabled {}", int)
    }

    override fun disable() {

    }

    override fun module(): Module? {
        return null
    }
}
