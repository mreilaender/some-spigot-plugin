package org.example.www.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.example.www.Messages;

/**
 * @author mreilaender
 */
public class PlayerJoinListener implements Listener {
    /**
     * Sends "Welcome message" to player just joined
     * @param e: PlayerJoinEvent
     */
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        if(player.hasPermission("permissions.build"))
            player.sendMessage(String.format(Messages.welcomeBackMessage, ChatColor.DARK_AQUA + player.getName()));
        else
            player.sendMessage(String.format(Messages.welcomeNewMessage, ChatColor.DARK_AQUA + player.getName()));
    }
}
