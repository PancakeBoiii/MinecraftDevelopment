package io.github.pancakeboiii.core.OrdinalAPI.Minecraft;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class PluginMessage {
    public static void StartupMessage(JavaPlugin Plugin) {
    	Plugin.getLogger().info(ChatColor.LIGHT_PURPLE + Plugin.getDescription().getName() + " V" + Plugin.getDescription().getVersion() + " By " + Plugin.getDescription().getAuthors() + " is Loading!");
        }
    public static void LoadedMessage(JavaPlugin Plugin) {
    	Plugin.getLogger().info(ChatColor.LIGHT_PURPLE + Plugin.getDescription().getName() + " V" + Plugin.getDescription().getVersion() + " has Completed Loading!");
        }
    
    public static void DisableMessage(JavaPlugin Plugin) {
    	Plugin.getServer().getConsoleSender().sendMessage(ChatColor.LIGHT_PURPLE + "Disabling " + Plugin.getDescription().getName() + " V" + Plugin.getDescription().getVersion() + " By " + Plugin.getDescription().getAuthors());
        }
    }

