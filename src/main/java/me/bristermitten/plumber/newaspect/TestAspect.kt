package me.bristermitten.plumber.newaspect

import org.slf4j.LoggerFactory


class TestAspect : Aspect {
    private val logger = LoggerFactory.getLogger(javaClass)
    
    override fun enable() {
        logger.info("Enabled {}", javaClass)
    }

    override fun disable() {
    }
}
