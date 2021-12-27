package io.github.pancakeboiii.core.OrdinalAPI.UpdateChecker;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
public class UpdateManager {
	
	
	
	public static void checkupdate(JavaPlugin Plugin, int PluginID, String PluginURL) {
            UpdateChecker updater = new UpdateChecker(Plugin, PluginID);
            try {
                if (updater.checkForUpdates()) {
                	String latestupdateversion = UpdateChecker.getLatestVersion().toString();
                	Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                	Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "You are using an older version of " + Plugin.getDescription().getName());
                	Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "Author(s) : "  + ChatColor.WHITE + Plugin.getDescription().getAuthors());
                	Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "Latest Version : " + ChatColor.WHITE + latestupdateversion + ChatColor.RED + " | " + "Current Version : "  + ChatColor.WHITE + Plugin.getDescription().getVersion());                	
                	Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "Download the newest version here:");
                	Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.LIGHT_PURPLE + PluginURL);
                	Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                } else {
                    Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + Plugin.getDescription().getName() + " is up to date! - "
                                    + Plugin.getDescription().getVersion());
                }
            } catch (Exception e) {
                Bukkit.getLogger().info("Could not check for updates! Stacktrace:");
                e.printStackTrace();
                
            }
		
		
	}

}
