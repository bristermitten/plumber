package me.bristermitten.plumber.command;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.BukkitCommandManager;
import co.aikar.commands.CommandManager;
import co.aikar.commands.PaperCommandManager;
import co.aikar.commands.annotation.CommandAlias;
import com.google.inject.Inject;
import me.bristermitten.plumber.PlumberPlugin;
import me.bristermitten.plumber.aspect.AbstractAspect;
import me.bristermitten.plumber.aspect.AspectManager;
import me.bristermitten.plumber.aspect.RequiredAspect;
import me.bristermitten.plumber.aspect.ThirdPartyAspectBinding;
import me.bristermitten.plumber.struct.player.PPlayer;
import me.bristermitten.plumber.struct.player.PPlayerManager;
import org.bukkit.Bukkit;

import java.util.HashSet;
import java.util.Set;

/**
 * Internal aspect that handles the scanning of command classes, and the registration of such classes
 */
@RequiredAspect
//Unnecessary but defines a mapping
@ThirdPartyAspectBinding(targets = CommandAlias.class)
public class CommandAspect extends AbstractAspect {

    public BukkitCommandManager commandManager;
    @Inject
    private PlumberPlugin plumberPlugin;
    @Inject
    private PPlayerManager manager;
    @Inject
    private AspectManager reflectionManager;

    /**
     * Enable the aspect, causing the creation of a {@link CommandManager},
     * and the registration of all required commands.
     */
    @Override
    protected void doEnable() {
        commandManager = new PaperCommandManager(plumberPlugin);
        commandManager.getCommandContexts()
                .registerContext(PPlayer.class, context -> {
                    String arg = context.popFirstArg();
                    return manager.ofPlayer(Bukkit.getPlayer(arg));
                });


        Set<Class<?>> loaded = new HashSet<>();
        for (Class<?> commandClass : reflectionManager.classesForAspect(this)) {
            if (commandClass.isMemberClass() || commandClass.isLocalClass()) {
                commandClass = commandClass.getSuperclass();
                if (loaded.contains(commandClass))
                    continue;
            }
            load(commandClass);
            loaded.add(commandClass);
        }
    }

    private void setupCompletions(PaperCommandManager manager) {
        commandManager.getCommandCompletions()
                .setDefaultCompletion("players", PPlayer.class);
    }

    /**
     * Disable the aspect, unregistering all commands
     */
    @Override
    protected void doDisable() {
        commandManager.unregisterCommands();
        commandManager = null;
    }

    private void load(Class<?> clazz) {
        commandManager.registerCommand((BaseCommand) instance(clazz));
        getLogger().debug("Registered command {}", clazz);
    }
}
