package org.doesntexist.limitx.command.handler;

import org.bukkit.entity.Player;
import org.doesntexist.limitx.command.Command;

/**
 * @author mreilaender
 */
public class ExampleCommand implements Command {

    public boolean onCommand(String label, String[] args, Player player) {
        player.sendMessage("This is an example command.");
        return true;
    }
}
