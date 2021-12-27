package io.github.pancakeboiii.core.OrdinalAPI.Minecraft;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command {
	public static void AsPlayer(Player Player, String Command) {
		Bukkit.dispatchCommand((CommandSender) Player, Command);
	  }
	public static void AsConsole(String Command) {
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), Command);
	  }
}
