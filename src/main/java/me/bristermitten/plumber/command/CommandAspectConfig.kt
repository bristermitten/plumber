package me.bristermitten.plumber.command

import co.aikar.commands.PaperCommandManager
import me.bristermitten.plumber.aspect.AspectConfig

interface CommandAspectConfig : AspectConfig<CommandAspect> {
    fun beforeRegistration(commandManager: PaperCommandManager)
    fun afterRegistration(commandManager: PaperCommandManager)
}
