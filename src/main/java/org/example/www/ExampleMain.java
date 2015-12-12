package org.example.www;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author mreilaender
 */
public class ExampleMain extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage("Hello World");
    }

    @Override
    public void onDisable() {

    }
}
