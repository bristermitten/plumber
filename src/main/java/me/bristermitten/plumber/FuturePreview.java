package me.bristermitten.plumber;


/**
 * This is how projects using plumber will look in the future
 */
public class FuturePreview {

//    @Command("freeze")
//    public class FreezeCommand {
//        private DataKey<Boolean> frozen = new DataKey<>("frozen", false);
//
//        @DefaultCommand
//        public void freeze(@Sender Player sender, PPlayer target, MinuteTime length) {
//            target.blockEvent(PlayerMoveEvent.class)
//                    .indefinitely()
//                    .until()
//                    .playerLogout().or()
//                    .after(length).or()
//                    .onKeyChange(frozen).toValue(false);
//
//            target.giveData(frozen, true);
//
//            //todo some form of chat templating
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
