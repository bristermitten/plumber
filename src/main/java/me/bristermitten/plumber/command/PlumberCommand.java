package me.bristermitten.plumber.command;

import co.aikar.commands.BaseCommand;
import me.bristermitten.plumber.aspect.AspectLoader;

public class PlumberCommand extends BaseCommand {

    static {
        AspectLoader.getInstance().ensureLoaded(CommandAspect.class);
    }

    protected void reply(String message) {
        getCurrentCommandIssuer().sendMessage(message);
    }
}
