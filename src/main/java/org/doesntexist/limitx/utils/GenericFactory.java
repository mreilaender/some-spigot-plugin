package org.doesntexist.limitx.utils;

import org.bukkit.ChatColor;
import org.doesntexist.limitx.Generic;

/**
 * @author mreilaender
 */
public class GenericFactory {
    private static Generic generic;

    public static void initialize(Generic g) {
        if(generic==null)
            generic = g;
    }

    public static String getPrefix() {
        return generic.getPrefix();
    }

    /**
     * Formats with colors and returns the plugins prefix, so it can be used for printing to console.
     * Example: [prefix]
     * @return String
     */
    public static String getChatPrefix() { return ChatColor.BLUE + "[" + getPrefix()+ "] " + ChatColor.RESET; }

    public static String getPluginDescription() { return generic.getPluginDescription(); }
}
