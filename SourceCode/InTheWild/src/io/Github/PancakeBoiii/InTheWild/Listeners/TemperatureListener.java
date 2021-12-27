package io.Github.PancakeBoiii.InTheWild.Listeners;

import java.io.File;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import io.Github.PancakeBoiii.InTheWild.Main;
import io.github.pancakeboiii.core.OrdinalAPI.DataManager.FileMan;
import io.github.pancakeboiii.core.OrdinalAPI.Minecraft.ActionBar;
import io.github.pancakeboiii.core.OrdinalAPI.Minecraft.Print;

public class TemperatureListener implements Listener{
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player p = event.getPlayer();
    	File f = new File("plugins/InTheWild/UserData/" + p.getUniqueId().toString() + "/Temperature.yml");
    	File fo = new File("plugins/InTheWild/UserData/" + p.getUniqueId().toString());
    	
    	if(fo.exists() && fo.isDirectory()) {
    		String Prefix = Main.plugin.getConfig().getString("plugin-prefix");
    		String ConsolePrefix = ChatColor.translateAlternateColorCodes('&', Prefix);
    		Print.Console(ConsolePrefix + " : " + "Temperature data for player " + p.getUniqueId().toString() + " has been found!");
    	}
    	FileMan.CreateFolder("plugins/InTheWild/UserData/" + p.getUniqueId().toString());
    	if(!f.exists() && !f.isDirectory()) { 
    	    FileMan.CreateFile(f.toString());
    	    FileMan.WriteToFile(f.toString(), "Temperature: 0");
    	}
    	if(f.exists() && !f.isDirectory()) { 
    		String Prefix = Main.plugin.getConfig().getString("plugin-prefix");
    		String ConsolePrefix = ChatColor.translateAlternateColorCodes('&', Prefix);
    	    FileConfiguration UserData = YamlConfiguration.loadConfiguration(f);
    	    Print.Console(ConsolePrefix + " : " + "Loaded Temperature data for player " + p.getUniqueId().toString());
    	}
    	
    	
	    if(!event.getPlayer().hasPlayedBefore()) {
	}
        File PreUserData = new File("plugins/InTheWild/UserData/" + p.getUniqueId().toString() + "/Temperature.yml");
	    FileConfiguration UserData = YamlConfiguration.loadConfiguration(PreUserData);
        ActionBar.send(p, "" + UserData.getInt("Temperature"));
}
}
