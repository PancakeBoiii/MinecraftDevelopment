package io.github.pancakeboiii.core.OrdinalAPI.Minecraft;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

@SuppressWarnings("unused")
public class Print {
    public static void Console(String Message) {
    	Bukkit.getLogger().info(Message);
        }
    public static void Player(Player Player, String Message) {
    	Player.sendMessage(Message);
        }
}
