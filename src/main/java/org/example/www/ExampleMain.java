package org.example.www;

import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.example.www.command.CommandManager;
import org.example.www.command.handler.ExampleCommand;

/**
 * @author mreilaender
 */
public class ExampleMain extends JavaPlugin {
    private String name;
    private String prefix;
    private PluginDescriptionFile pluginDescriptionFile;
    private CommandManager commandManager;


    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage("Hello World");

        this.pluginDescriptionFile = this.getDescription();
        this.name = this.pluginDescriptionFile.getName();
        this.prefix = this.pluginDescriptionFile.getPrefix();
        this.commandManager = new CommandManager(this);
        this.registerCommandExecuter();

        this.commandManager.addCommandHandler("test", new ExampleCommand());
    }

    private void registerCommandExecuter() {
        getCommand(this.prefix).setExecutor(this.commandManager);
        //getCommand(Character.toString(this.prefix.charAt(0))).setExecutor(this.commandManager);
    }

    @Override
    public void onDisable() {

    }

    public String getPluginName() {
        return this.name;
    }

    public String getPluginDescription() {
        if(!(this.pluginDescriptionFile.getDescription() == null))
            return this.pluginDescriptionFile.getDescription();
        else
            return ErrorMessages.noPluginDescription;
    }

    public String getPrefix() {
        return prefix;
    }

    /**
     * Formats with colors and returns the plugins prefix, so it can be used for printing to console.
     * Example: [prefix]
     * @return String
     */
    public String getChatPrefix() {
        return ChatColor.BLUE + "[" + prefix + "] " + ChatColor.RESET;
    }
}
