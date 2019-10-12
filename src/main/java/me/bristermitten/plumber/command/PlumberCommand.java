package me.bristermitten.plumber.command;

import co.aikar.commands.BaseCommand;
import me.bristermitten.plumber.util.ChatUtil;

/**
 * Extension of {@link BaseCommand} that gives extra boilerplate handling
 * It's recommended to use this class
 */
public class PlumberCommand extends BaseCommand {

    /**
     * Reply to a command, sending a message to the sender. The string will be colored.
     *
     * @param message the message to send
     */
    protected void reply(String message) {
        getCurrentCommandIssuer().sendMessage(ChatUtil.color(message));
    }
}
