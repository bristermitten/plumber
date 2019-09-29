package me.bristermitten.plumber.command;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.BukkitCommandManager;
import co.aikar.commands.PaperCommandManager;
import com.google.inject.Inject;
import me.bristermitten.plumber.PlumberPlugin;
import me.bristermitten.plumber.newaspect.AbstractAspect;
import me.bristermitten.plumber.newaspect.AspectReflectionManager;
import me.bristermitten.plumber.newaspect.RequiredAspect;
import me.bristermitten.plumber.object.player.PPlayer;
import me.bristermitten.plumber.object.player.PPlayerManager;
import org.bukkit.Bukkit;

import java.util.HashSet;
import java.util.Set;

@RequiredAspect
public class CommandAspect extends AbstractAspect {

    @Inject
    private PlumberPlugin plumberPlugin;

    @Inject
    private PPlayerManager manager;

    @Inject
    private AspectReflectionManager reflectionManager;

    private BukkitCommandManager commandManager;

    @Override
    protected void doEnable() {
        commandManager = new PaperCommandManager(plumberPlugin);
        commandManager.getCommandContexts()
                .registerContext(PPlayer.class, context -> {
                    String arg = context.popFirstArg();
                    return manager.of(Bukkit.getPlayer(arg));
                });
        commandManager.getCommandCompletions()
                .setDefaultCompletion("players", PPlayer.class);

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

    @Override
    protected void doDisable() {
        commandManager.unregisterCommands();
        commandManager = null;
    }

    private void load(Class<?> clazz) {
        commandManager.registerCommand((BaseCommand) instance(clazz));
        System.out.println("Loaded and registered command " + clazz);
    }
}
