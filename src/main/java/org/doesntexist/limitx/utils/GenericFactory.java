package org.doesntexist.limitx.utils;

import org.bukkit.ChatColor;
import org.doesntexist.limitx.Generic;

/**
 * This class provides all Methods needed by other classes, without delivering the instance of the Main class.
 * @author mreilaender
 *
 */
public class GenericFactory {
    private static Generic generic;

    public static void initialize(Generic g) {
        if(generic==null)
            generic = g;
    }

    /**
     * Returns the plugin's prefix
     * @return
     */
    public static String getPrefix() {
        return generic.getPrefix();
    }

    /**
     * Formats with colors and returns the plugin's prefix, so it can be used for printing (e.g. to the console).
     * Example: [prefix]
     * @return String
     */
    public static String getChatPrefix() { return ChatColor.BLUE + "[" + getPrefix()+ "] " + ChatColor.RESET; }

    public static String getPluginDescription() { return generic.getPluginDescription(); }
}
