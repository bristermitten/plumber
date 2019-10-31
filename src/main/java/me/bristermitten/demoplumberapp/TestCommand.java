package me.bristermitten.demoplumberapp;

import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import me.bristermitten.plumber.command.PlumberCommand;
import me.bristermitten.plumber.struct.key.DataKey;
import me.bristermitten.plumber.struct.player.PPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerMoveEvent;

import static org.bukkit.ChatColor.RED;


public class TestCommand extends PlumberCommand {
    private DataKey<Boolean> frozen = new DataKey<>("frozen", false);

    @CommandAlias("freeze")
    public class Freeze extends TestCommand {

        @Default
        public void freeze(Player sender, PPlayer target) {

            if (target.getData(frozen)) {
                reply(RED + "Player already frozen");
                return;
            }
            target.blockEvent(PlayerMoveEvent.class)
                    .until()
                    .playerLogout()
                    .keyChange(frozen).toValue(false)
                    .or()
                    .undoAfter(30).seconds()
                    .withMessageOnComplete(RED + "You have been freed!")
                    .setKeyOnComplete(frozen, false);


            target.setData(frozen, true);
            target.message(RED + "You have been frozen");
        }
    }

    @CommandAlias("unfreeze")
    public class UnFreeze extends TestCommand {
        @Default
        public void unFreeze(Player sender, PPlayer target) {
            Boolean value = target.getData(frozen);
            if (!value) {
                reply(RED + "Player is not frozen");
                return;
            }
            target.setData(frozen, false);
        }
    }
}

