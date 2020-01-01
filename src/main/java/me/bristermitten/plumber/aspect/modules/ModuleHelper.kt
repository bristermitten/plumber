package me.bristermitten.plumber.aspect.modules

import com.google.inject.AbstractModule
import com.google.inject.Binder

class ModuleHelper(private val configureFun: (Binder) -> Unit) : AbstractModule() {
    override fun configure() {
        configureFun(binder())
    }
}
