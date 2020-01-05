package me.bristermitten.plumber.command

import co.aikar.commands.BaseCommand
import co.aikar.commands.PaperCommandManager
import co.aikar.commands.annotation.CommandAlias
import com.google.inject.Inject
import com.google.inject.Module
import me.bristermitten.plumber.PlumberPlugin
import me.bristermitten.plumber.aspect.AbstractAspect
import me.bristermitten.plumber.aspect.LoadIfPresent
import me.bristermitten.plumber.reflection.ClassFinder
import me.bristermitten.plumber.util.Reflection.createGuiceModule
import me.bristermitten.plumber.struct.player.PPlayer
import me.bristermitten.plumber.struct.player.PPlayerManager
import me.bristermitten.plumber.struct.player.PlayerExtension
import me.bristermitten.reflector.Reflector
import org.bukkit.Bukkit

/**
 * Internal aspect that handles the scanning of command classes, and the registration of such classes
 */

//Only load if we see @CommandAlias at all. CommandAlias is necessary for ACF so we can assume it will be used
@LoadIfPresent(CommandAlias::class)
class CommandAspect @Inject constructor(
    private val plumberPlugin: PlumberPlugin,
    private val manager: PPlayerManager,
    private val classFinder: ClassFinder,
    private val reflector: Reflector
) : AbstractAspect() {

    private lateinit var commandManager: PaperCommandManager

    private val commands: MutableSet<BaseCommand> = mutableSetOf()
    /**
     * Enable the aspect, causing the creation of a [PaperCommandManager],
     * and the registration of all required commands.
     */
    override fun doEnable() {
        commandManager = PaperCommandManager(plumberPlugin)

        setupCompletions()
        setupContexts()

        val configs = classFinder.getRealClassesImplementing(CommandAspectConfig::class)
            .map { instance(it) }

        configs.forEach { it.beforeRegistration(commandManager) }

        classes
            .map(reflector::getStructure)
            .filter { it.isFullClass }
            .forEach { load(it.type) }

        configs.forEach { it.beforeRegistration(commandManager) }
    }

    override fun getModule(): Module {
        return createGuiceModule {
            for (command in commands) {
                bind(command.javaClass).toInstance(command)
            }
        }
    }

    private fun setupContexts() {
        commandManager.commandContexts
            .registerContext(PPlayer::class.java) { context ->
                val arg = context.popFirstArg()
                manager.ofPlayer(Bukkit.getPlayer(arg))
            }

        commandManager.commandContexts.registerContext(PlayerExtension::class.java) { context ->
            @Suppress("UNCHECKED_CAST", "DEPRECATION")
            val extensionClass = context.param.type as Class<out PlayerExtension>
            val arg = context.popFirstArg()
            manager.ofPlayer(Bukkit.getPlayer(arg)).getExtension(extensionClass)
        }
    }

    private fun setupCompletions() {
        val extensionArray = classFinder.findAllExtensionsFor(PPlayer::class)
            .toTypedArray()
        commandManager.commandCompletions.setDefaultCompletion("players", *extensionArray, PPlayer::class.java)
    }

    /**
     * Disable the aspect, unregistering all commands
     */
    override fun doDisable() {
        commandManager.unregisterCommands()
    }

    private fun load(clazz: Class<*>) {
        val command = instance(clazz) as BaseCommand
        commandManager.registerCommand(command)
        commands.add(command)
        logger.debug("Registered command {}", clazz)
    }
}
