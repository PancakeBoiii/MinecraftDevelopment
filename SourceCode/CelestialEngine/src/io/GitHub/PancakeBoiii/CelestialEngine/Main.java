package io.GitHub.PancakeBoiii.CelestialEngine;



import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.json.simple.parser.ParseException;

import io.github.pancakeboiii.core.OrdinalAPI.Minecraft.PluginMessage;
import io.github.pancakeboiii.core.OrdinalAPI.Minecraft.Print;
import io.github.pancakeboiii.core.OrdinalAPI.UpdateChecker.UpdateManager;


public class Main extends JavaPlugin {
    public static Main plugin;
    // This code sucks, you know it and I know it.
    // If you are reading this, that means you are either snooping or have decided to take over and maintain this project.
    // let the number below act as a warning for the next person, and add hours to it accordingly.
    int Total_Hours_Wasted_On_This_God_Forsaken_Project = 56;
    @Override
    public void onEnable() {
    	plugin = this;
        PluginMessage.StartupMessage(this);
        UpdateManager.checkupdate(this, 94855, "https://www.spigotmc.org/resources/celestialengine.94855/");
        if (Bukkit.getServer().getPluginManager().getPlugin("Terra") == null) {
        	getLogger().warning("ALERT TERRA IS NOT INSTALLED");
        }
        if (Bukkit.getServer().getPluginManager().getPlugin("Terra") != null) {
        	Print.Console(ChatColor.GREEN + "Terra is installed");
        	try {
        		Print.Console(ChatColor.GREEN + "Getting Latest planet packs...");
				PlanetPacks.Main();
				Print.Console(ChatColor.GREEN + "DONE");
			} catch (ParseException | IOException e) {
				Print.Console(ChatColor.RED + "Getting Latest planet packs FAILED");
				e.printStackTrace();
			}
        }
        this.saveDefaultConfig();
        PluginMessage.LoadedMessage(this);
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            public void run() {
                PlanetCore.Main();
            }
        }, 20L, 20L);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("You can't run this command from the Console. Please use it in-game. Usage: /Reload");
            return true;
        }
        Player p = (Player) sender;
        if (p.hasPermission("celestialengine.reload")) {
            this.saveDefaultConfig();
            this.reloadConfig();
            Print.Player(p, ChatColor.translateAlternateColorCodes('&',
                this.getConfig().getString("plugin-prefix") + " : " + this.getConfig().getString("reload-message")));
            return true;
        }
        Print.Player(p, ChatColor.RED + "You do not have permission to run this command!");
        return false;
    }
    public void onDisable() {
        PluginMessage.DisableMessage(this);
    	
    }

}