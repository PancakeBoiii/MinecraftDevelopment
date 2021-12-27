package io.github.pancakeboiii.core.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import io.github.pancakeboiii.core.OrdinalAPI.Minecraft.GameData;
public class DevCommand3 implements CommandExecutor {
  public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
    if (sender instanceof Player) {
      Player player = (Player)sender;
      Location Ploc = player.getLocation();
      GameData.SetBlockString(Ploc, "test ye", "Gren");
    } else {
    	sender.sendMessage("You must be a player!");
        return false;
      } 
    return false;
  }
}
