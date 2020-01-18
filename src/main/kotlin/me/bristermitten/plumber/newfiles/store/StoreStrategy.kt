package me.bristermitten.plumber.newfiles.store

/**
 * @author Alexander Wood (BristerMitten)
 */
annotation class StoreStrategy(val strategy: StoreKeyStrategy)
enum class StoreKeyStrategy {
    INCREMENT,
    PROPERTY,
}
