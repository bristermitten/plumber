package me.bristermitten.demoplumberapp;

import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import me.bristermitten.plumber.command.PlumberCommand;
import me.bristermitten.plumber.struct.DataKey;
import me.bristermitten.plumber.struct.player.PPlayer;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerMoveEvent;


/**
 * This is how projects using plumber will look in the future
 */
@CommandAlias("freeze")
public class TestCommand extends PlumberCommand {
    private DataKey<Boolean> frozen = new DataKey<>("frozen", false);

    @Default
    public void freeze(Player sender, PPlayer target) {
        target.blockEvent(PlayerMoveEvent.class)
                .until()
                .playerLogout()
                .keyChange(frozen).toValue(false)
                .or()
                .after(30).seconds();
        target.setData(frozen, true);


        //todo some form of chat templating
        //target.message(RED + "You have been frozen for " + length);
    }

    //
    @CommandAlias("unfreeze")
    public void unFreeze(Player sender, PPlayer target) {
        boolean value = target.getData(frozen);
        if (!value) {
            reply(ChatColor.RED + "Player is not frozen");
            return;
        }

        target.setData(frozen, false);
    }
}

