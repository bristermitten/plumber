package me.bristermitten.plumber;


import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import me.bristermitten.plumber.struct.player.PPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerMoveEvent;

import static org.bukkit.ChatColor.RED;

/**
 * This is how projects using plumber will look in the future
 */
public class FuturePreview  extends BaseCommand {

//    @CommandAlias("freeze")
//    public class FreezeCommand extends BaseCommand {
//        private DataKey<Boolean> frozen = new DataKey<>("frozen", false);
//
//        @Default
//        public void freeze(Player sender, PPlayer target) {
//            target.blockEvent(PlayerMoveEvent.class)
//                    .until()
//                    .playerLogout().or()
//                    .after(length).or()
//                    .onKeyChange(frozen).toValue(false);
//
//            target.giveData(frozen, true);

            //todo some form of chat templating
//            target.message(RED + "You have been frozen for " + length);
//        }
//
//        @SubCommand("unfreeze")
//        public void unFreeze(@Sender Player sender, Player target){
//            if(!target.hasKey(frozen))
//                return returnMessage(RED + "Player is not frozen");
//
//            target.removeKey(frozen);
//        }
//    }
}
