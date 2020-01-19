package me.bristermitten.plumber.newfiles.store

/**
 * @author Alexander Wood (BristerMitten)
 */
annotation class StoreStrategy(val strategy: StoreStrategyType)

enum class StoreStrategyType {
    INCREMENT,
    PROPERTY,
}
