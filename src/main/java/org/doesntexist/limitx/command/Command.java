package org.doesntexist.limitx.command;

import org.bukkit.entity.Player;

/**
 * @author mreilaender
 */
public interface Command {
    boolean onCommand(String label, String[] args, Player player);
}
