package org.doesntexist.limitx.event;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.doesntexist.limitx.Messages;

/**
 * @author mreilaender
 */
public class PlayerDeathListener implements Listener {
    /**
     * Sends a message to the just died player with the death coords
     * @param e
     */
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        Player player = e.getEntity();
        Location loc = player.getLocation();
        player.sendMessage(String.format(Messages.playerDiedAt, player.getWorld().getName(), (int)loc.getX(), (int)loc.getY(), (int)loc.getZ()));
    }
}
