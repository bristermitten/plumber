package me.bristermitten.plumber.command;

import co.aikar.commands.BaseCommand;

public class PlumberCommand extends BaseCommand {


    protected void reply(String message) {
        getCurrentCommandIssuer().sendMessage(message);
    }
}
