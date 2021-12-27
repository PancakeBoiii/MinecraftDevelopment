package io.github.pancakeboiii.core.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import io.github.pancakeboiii.core.Main;
import io.github.pancakeboiii.core.OrdinalAPI.Minecraft.GameData;
import io.github.pancakeboiii.core.OrdinalAPI.Minecraft.Print;
public class DevCommand2 implements CommandExecutor {
  public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
    if (sender instanceof Player) {
      Player player = (Player)sender;
      ItemStack item = player.getInventory().getItemInMainHand();
      Print.Player(player, item.toString());
      Print.Player(player, "Stored Data : " + GameData.GetItemStackString(player, item, "Message4U"));
    } else {
    	sender.sendMessage("You must be a player!");
        return false;
      } 
    return false;
  }
}
