package io.github.pancakeboiii.core.OrdinalAPI.PluginChecker;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.pancakeboiii.core.OrdinalAPI.Minecraft.Print;
import net.md_5.bungee.api.ChatColor;

@SuppressWarnings("unused")
public class CheckPlugin {
	static PluginManager pm = Bukkit.getServer().getPluginManager();
    public static void IsInstalled(String PluginName) {
        if (pm.getPlugin(PluginName) == null ) {
        	Print.Console("" + ChatColor.GRAY + "[" + ChatColor.RED + "X" + ChatColor.GRAY + "] " + ChatColor.WHITE + PluginName + " is not Installed!");
        } else {
            if (pm.getPlugin(PluginName) != null ) {
            	Print.Console("" + ChatColor.GRAY + "[" + ChatColor.GREEN + "O" + ChatColor.GRAY + "] " + ChatColor.WHITE + PluginName + " is Installed!");
            }
        }
    }
    public static void IsInstalledDepends(String PluginName, JavaPlugin Plugin) {
        if (pm.getPlugin(PluginName) == null ) {
        	Print.Console("" + ChatColor.GRAY + "[" + ChatColor.RED + "X" + ChatColor.GRAY + "] " + ChatColor.WHITE + PluginName + " is not Installed!");
        	Print.Console(ChatColor.RED + PluginName + " is a required!");
        	pm.disablePlugin(Plugin);
        } else {
            if (pm.getPlugin(PluginName) != null ) {
            	Print.Console("" + ChatColor.GRAY + "[" + ChatColor.GREEN + "O" + ChatColor.GRAY + "] " + ChatColor.WHITE + PluginName + " is Installed!");
            }
        }
    }
   
}
