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

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

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
        commandManager.getCommandCompletions().setDefaultCompletion("players", PPlayer.class);
    }

    @Override
    protected void doDisable() {
    }

    @Override
    public void loadParts(Set<Class> annotatedClasses) {
        for (Iterator<Class> iterator = annotatedClasses.iterator(); iterator.hasNext(); ) {
            Class<?> annotatedClass = iterator.next();
            if (annotatedClass.isMemberClass() || annotatedClass.isLocalClass()) {
                iterator.remove();
                annotatedClass=annotatedClass.getSuperclass();
            }
            load(annotatedClass);
        }
    }

    private void load(Class<?> clazz){
        commandManager.registerCommand((BaseCommand) instance(clazz));
        System.out.println("Loaded and registered command " + clazz);
    }
}
