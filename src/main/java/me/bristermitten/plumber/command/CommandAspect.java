package me.bristermitten.plumber.command;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.CommandManager;
import co.aikar.commands.PaperCommandManager;
import com.google.inject.Inject;
import me.bristermitten.plumber.PlumberPlugin;
import me.bristermitten.plumber.aspect.AbstractAspect;
import me.bristermitten.plumber.struct.player.PPlayer;
import me.bristermitten.plumber.struct.player.PPlayerManager;
import org.bukkit.Bukkit;

import java.util.Set;

public class CommandAspect extends AbstractAspect {

    @Inject
    private PlumberPlugin plumberPlugin;

    @Inject
    private PPlayerManager manager;
    private CommandManager commandManager;

    @Override
    protected void doEnable() {
        commandManager = new PaperCommandManager(plumberPlugin);
        commandManager.getCommandContexts()
                .registerContext(PPlayer.class, context -> {
                    String arg = context.popFirstArg();
                    return manager.of(Bukkit.getPlayer(arg));
                });
    }

    @Override
    protected void doDisable() {
    }

    @Override
    public void loadParts(Set<Class> annotatedClasses) {
        for (Class<?> annotatedClass : annotatedClasses) {
            commandManager.registerCommand((BaseCommand) instance(annotatedClass));
            System.out.println("Loaded " + annotatedClass);
        }
    }
}
