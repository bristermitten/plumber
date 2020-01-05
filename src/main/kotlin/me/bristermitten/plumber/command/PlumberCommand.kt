package me.bristermitten.plumber.command

import co.aikar.commands.BaseCommand
import me.bristermitten.plumber.util.Chat

/**
 * Extension of [BaseCommand] that gives extra boilerplate handling
 * It's recommended to use this class
 */
class PlumberCommand : BaseCommand() {
    /**
     * Reply to a command, sending a message to the sender. The string will be colored.
     *
     * @param message the message to send
     */
    protected fun reply(message: String) {
        currentCommandIssuer.sendMessage(Chat.color(message))
    }
}
