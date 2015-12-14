package org.doesntexist.limitx;

import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.doesntexist.limitx.command.handler.ExampleCommand;
import org.doesntexist.limitx.command.CommandManager;
import org.doesntexist.limitx.event.PlayerDeathListener;
import org.doesntexist.limitx.event.PlayerJoinListener;
import org.doesntexist.limitx.utils.GenericFactory;

/**
 * @author mreilaender
 */
public class Generic extends JavaPlugin {
    private String name;
    private String prefix;
    private PluginDescriptionFile pluginDescriptionFile;
    private CommandManager commandManager;
    private PluginManager pluginManager;

    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage("Hello World");

        GenericFactory.initialize(this);
        this.pluginDescriptionFile = this.getDescription();
        this.name = this.pluginDescriptionFile.getName();
        this.prefix = this.pluginDescriptionFile.getPrefix();
        this.commandManager = new CommandManager();
        this.pluginManager = this.getServer().getPluginManager();

        this.registerCommandExecuter();
        this.registerListener();
        this.registerCommands();

    }

    /**
     * Registers all Listener in PluginManager
     */
    private void registerListener() {
        this.pluginManager.registerEvents(new PlayerJoinListener(), this);
        this.pluginManager.registerEvents(new PlayerDeathListener(), this);
    }

    /**
     *
     */
    private void registerCommands() {
        this.commandManager.addCommandHandler("test", new ExampleCommand());
    }
    /**
     * Registers command executer
     */
    private void registerCommandExecuter() {
        getCommand(this.prefix).setExecutor(this.commandManager);
        //getCommand(Character.toString(this.prefix.charAt(0))).setExecutor(this.commandManager);
    }

    @Override
    public void onDisable() {

    }

    public String getPluginDescription() {
        if(!(this.pluginDescriptionFile.getDescription() == null))
            return this.pluginDescriptionFile.getDescription();
        else
            return Messages.noPluginDescription;
    }

    public String getPrefix() { return prefix; }

    /**
     * Formats with colors and returns the plugins prefix, so it can be used for printing to console.
     * Example: [prefix]
     * @return String
     */
    public String getChatPrefix() { return ChatColor.BLUE + "[" + prefix + "] " + ChatColor.RESET; }

    public String getPluginName() {
        return this.name;
    }
}
