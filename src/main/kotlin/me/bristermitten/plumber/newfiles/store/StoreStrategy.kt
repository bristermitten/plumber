package me.bristermitten.plumber.newfiles.store

/**
 * @author Alexander Wood (BristerMitten)
 */
annotation class StoreStrategy(val type: StoreStrategyType)
enum class StoreStrategyType {

    INDEXED,
    KEY_VALUE,
}
