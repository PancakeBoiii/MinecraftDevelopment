package io.github.pancakeboiii.core.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import io.github.pancakeboiii.core.Main;
public class InfoCommand implements CommandExecutor {
  public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
    if (sender instanceof Player) {
      Player player = (Player)sender;
      player.sendMessage(ChatColor.YELLOW + "                      _▄███▄_");
      player.sendMessage(ChatColor.GOLD + "╔═══════════════════════════╗");
      	player.sendMessage(ChatColor.LIGHT_PURPLE + "" + Main.plugin.getDescription().getName());
      	player.sendMessage(ChatColor.LIGHT_PURPLE + "Author(s) : "  + ChatColor.WHITE + Main.plugin.getDescription().getAuthors());
      	player.sendMessage(ChatColor.LIGHT_PURPLE + "Current Version : "  + ChatColor.WHITE + Main.plugin.getDescription().getVersion());                	
      	player.sendMessage(ChatColor.AQUA + "https://www.spigotmc.org/resources/pancakecore.94821/");
        player.sendMessage(ChatColor.GOLD + "╚═══════════════════════════╝");
    } else {
    	sender.sendMessage(ChatColor.YELLOW + "                       _▄███▄_");
    	sender.sendMessage(ChatColor.GOLD + "╔═════════════════════════════════════════════════════╗");
      	sender.sendMessage(ChatColor.LIGHT_PURPLE + "" + Main.plugin.getDescription().getName());
      	sender.sendMessage(ChatColor.LIGHT_PURPLE + "Author(s) : "  + ChatColor.WHITE + Main.plugin.getDescription().getAuthors());
      	sender.sendMessage(ChatColor.LIGHT_PURPLE + "Current Version : "  + ChatColor.WHITE + Main.plugin.getDescription().getVersion());                	
      	sender.sendMessage(ChatColor.AQUA + "https://www.spigotmc.org/resources/pancakecore.94821/");
        sender.sendMessage(ChatColor.GOLD + "╚═════════════════════════════════════════════════════╝");
        return false;
      } 
    return false;
  }
}
