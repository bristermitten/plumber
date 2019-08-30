package me.bristermitten.plumber.command;

import be.seeseemelk.mockbukkit.ServerMock;
import co.aikar.commands.BaseCommand;
import co.aikar.commands.CommandManager;
import co.aikar.commands.PaperCommandManager;
import com.google.inject.Inject;
import com.google.inject.Injector;
import me.bristermitten.plumber.PlumberPlugin;
import me.bristermitten.plumber.aspect.AbstractAspect;

import java.util.Set;

public class CommandAspect extends AbstractAspect {

    @Inject
    private PlumberPlugin plumberPlugin;

    private CommandManager commandManager;
    @Inject
    private Injector injector;

    @Override
    protected void doEnable() {
        commandManager = new PaperCommandManager(plumberPlugin);
    }

    @Override
    protected void doDisable() {
    }

    @Override
    public void loadParts(Set<Class> annotatedClasses) {
        for (Class annotatedClass : annotatedClasses) {
            commandManager.registerCommand((BaseCommand) injector.getInstance(annotatedClass));
            System.out.println("Loaded "+ annotatedClass);
        }
    }
}
