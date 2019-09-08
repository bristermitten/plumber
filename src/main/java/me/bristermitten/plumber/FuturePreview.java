package me.bristermitten.plumber;


import co.aikar.commands.BaseCommand;
import me.bristermitten.plumber.struct.DataKey;
import me.bristermitten.plumber.struct.player.PPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerMoveEvent;

/**
 * This is how projects using plumber will look in the future
 */
public class FuturePreview extends BaseCommand {

    //    @CommandAlias("freeze")
//    public class FreezeCommand extends BaseCommand {
    private DataKey<Boolean> frozen = new DataKey<>("frozen", false);

    //
    public void freeze(Player sender, PPlayer target) {
        target.blockEvent(PlayerMoveEvent.class)
                .until()
                .playerLogout().or()
                .after(30).seconds().or()
                .onKeyChange(frozen).toValue(false);
            target.setData(frozen, true);

        //todo some form of chat templating
//            target.message(RED + "You have been frozen for " + length);
    }
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
