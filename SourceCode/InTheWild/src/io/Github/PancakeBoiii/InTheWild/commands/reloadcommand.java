package io.Github.PancakeBoiii.InTheWild.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import io.Github.PancakeBoiii.InTheWild.Main;
import io.github.pancakeboiii.core.OrdinalAPI.Minecraft.Print;

public class reloadcommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player){
		    Player p = (Player)sender;
		    if (p.hasPermission("InTheWild.reload")) {
		      Main.plugin.saveDefaultConfig();
		      Main.plugin.reloadConfig();
		      Print.Player(p, ChatColor.translateAlternateColorCodes('&', 
		            String.valueOf(Main.plugin.getConfig().getString("plugin-prefix")) + " : " + Main.plugin.getConfig().getString("reload-message")));
		    } else {
		    	Print.Player(p, ChatColor.RED + "You do not have permission to run this command!");
		    }
        }
        if (sender instanceof ConsoleCommandSender){
  	      Main.plugin.saveDefaultConfig();
  	      Main.plugin.reloadConfig();
  	      Print.Console(ChatColor.translateAlternateColorCodes('&', 
  	            String.valueOf(Main.plugin.getConfig().getString("plugin-prefix")) + " : " + Main.plugin.getConfig().getString("reload-message")));
  }
		return false;
}
    
}