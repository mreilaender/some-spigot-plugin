package org.doesntexist.limitx.command;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.doesntexist.limitx.Generic;
import org.doesntexist.limitx.Messages;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author mreilaender
 * @version 12.12.2015
 */
public class CommandManager implements CommandExecutor {
    private Map<String, Command> commandHandlers;
    private Generic main;

    public CommandManager(Generic main) {
        this.commandHandlers = new HashMap<String, Command>();
        this.main = main;
    }

    public boolean onCommand(CommandSender commandSender, org.bukkit.command.Command command, String cmdLabel, String[] args) {
        if(cmdLabel.equalsIgnoreCase(this.main.getPrefix()) || cmdLabel.equalsIgnoreCase(Character.toString(this.main.getPrefix().charAt(0)))) {
            if(commandSender instanceof Player) {
                Player player = (Player) commandSender;

                if(args.length == 0) {
                    player.sendMessage(this.main.getPluginDescription());
                } else {
                    String subCmd = args[0];
                    Command subCmdAbs = this.commandHandlers.get(subCmd);
                    if(subCmdAbs != null) {
                        String[] subCmdArgs = Arrays.copyOfRange(args, 1, args.length);
                        boolean succeed = subCmdAbs.onCommand(subCmd, subCmdArgs, player);
                        if(!succeed)
                            player.sendMessage(this.main.getChatPrefix() + Messages.errPerfCommand);
                    } else
                        player.sendMessage(this.main.getChatPrefix() + Messages.noSuchCommand + subCmd);
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
