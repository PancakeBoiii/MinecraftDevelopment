package io.github.pancakeboiii.core.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import io.github.pancakeboiii.core.OrdinalAPI.Minecraft.GameData;
public class DevCommand4 implements CommandExecutor {
  public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
    if (sender instanceof Player) {
      Player player = (Player)sender;
      Location location = player.getLocation();
      String ID = location.getBlockX() + "/" + location.getBlockY() + "/" + location.getBlockZ() + "/" + location.getWorld().getName();
      GameData.RemoveBlockData("Gren", ID);
    } else {
    	sender.sendMessage("You must be a player!");
        return false;
      } 
    return false;
  }
}
