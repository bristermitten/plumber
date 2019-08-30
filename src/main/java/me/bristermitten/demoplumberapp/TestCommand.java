package me.bristermitten.demoplumberapp;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Subcommand;
import org.bukkit.command.CommandSender;

@CommandAlias("test")
public class TestCommand extends BaseCommand {

    @Default
    public void process(CommandSender sender) {
        System.out.println("Ran");
    }

    @Subcommand("subcommand")
    public static class Test2 {

        @Default
        public void run() {
            System.out.println("subcommand ran!");
        }
    }
}
