package org.doesntexist.limitx.command;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.doesntexist.limitx.Generic;
import org.doesntexist.limitx.Messages;
import org.doesntexist.limitx.utils.GenericFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author mreilaender
 * @version 12.12.2015
 */
public class CommandManager implements CommandExecutor {
    private Map<String, Command> commandHandlers;

    public CommandManager() {
        this.commandHandlers = new HashMap<String, Command>();
    }

    public boolean onCommand(CommandSender commandSender, org.bukkit.command.Command command, String cmdLabel, String[] args) {
        if(cmdLabel.equalsIgnoreCase(GenericFactory.getPrefix()) || cmdLabel.equalsIgnoreCase(Character.toString(GenericFactory.getPrefix().charAt(0)))) {
            if(commandSender instanceof Player) {
                Player player = (Player) commandSender;

                if(args.length == 0) {
                    player.sendMessage(GenericFactory.getPluginDescription());
                } else {
                    String subCmd = args[0];
                    Command subCmdAbs = this.commandHandlers.get(subCmd);
                    if(subCmdAbs != null) {
                        String[] subCmdArgs = Arrays.copyOfRange(args, 1, args.length);
                        boolean succeed = subCmdAbs.onCommand(subCmd, subCmdArgs, player);
                        if(!succeed)
                            player.sendMessage(GenericFactory.getChatPrefix() + Messages.errPerfCommand);
                    } else
                        player.sendMessage(GenericFactory.getChatPrefix() + String.format(Messages.noSuchCommand, ChatColor.RED + subCmd));
                }
            }
            return true;
        }
        return false;
    }

    public void addCommandHandler(String label, Command command) {
        if(!this.commandHandlers.containsKey(label)) {
            if(!this.commandHandlers.containsValue(command)) {
                this.commandHandlers.put(label, command);
            }
        }
    }


}
