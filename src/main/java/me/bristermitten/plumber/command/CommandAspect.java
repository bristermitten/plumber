package me.bristermitten.plumber.command;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.BukkitCommandManager;
import co.aikar.commands.PaperCommandManager;
import com.google.inject.Inject;
import me.bristermitten.plumber.PlumberPlugin;
import me.bristermitten.plumber.aspect.AbstractAspect;
import me.bristermitten.plumber.object.player.PPlayer;
import me.bristermitten.plumber.object.player.PPlayerManager;
import org.bukkit.Bukkit;

import java.util.HashSet;
import java.util.Set;

public class CommandAspect extends AbstractAspect {

    @Inject
    private PlumberPlugin plumberPlugin;

    @Inject
    private PPlayerManager manager;
    private BukkitCommandManager commandManager;

    @Override
    protected void doEnable() {
        commandManager = new PaperCommandManager(plumberPlugin);
        commandManager.getCommandContexts()
                .registerContext(PPlayer.class, context -> {
                    String arg = context.popFirstArg();
                    return manager.of(Bukkit.getPlayer(arg));
                });
        commandManager.getCommandCompletions().setDefaultCompletion("players", PPlayer.class);
    }

    @Override
    protected void doDisable() {
        commandManager.unregisterCommands();
        commandManager = null;
    }

    @Override
    public void loadParts(Set<Class<?>> annotatedClasses) {
        Set<Class<?>> loaded = new HashSet<>();
        for (Class<?> annotatedClass : annotatedClasses) {
            if (annotatedClass.isMemberClass() || annotatedClass.isLocalClass()) {
                annotatedClass = annotatedClass.getSuperclass();
                if (loaded.contains(annotatedClass))
                    continue;
            }
            load(annotatedClass);
            loaded.add(annotatedClass);
        }
    }

    private void load(Class<?> clazz) {
        commandManager.registerCommand((BaseCommand) instance(clazz));
        System.out.println("Loaded and registered command " + clazz);
    }
}
