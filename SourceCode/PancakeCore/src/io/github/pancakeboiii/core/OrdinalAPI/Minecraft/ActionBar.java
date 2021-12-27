package io.github.pancakeboiii.core.OrdinalAPI.Minecraft;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;


public class ActionBar {
	@EventHandler
	public static void send(Player p, String message) {
		  p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("" + message));
	  }
}