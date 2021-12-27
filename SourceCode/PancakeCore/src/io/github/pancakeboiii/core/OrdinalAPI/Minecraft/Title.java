package io.github.pancakeboiii.core.OrdinalAPI.Minecraft;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;


public class Title {
	@EventHandler
	public static void send(Player p, String title, String subtitle, int fadein, int stay, int fadeout) {
		p.sendTitle(title, subtitle, fadein, stay, fadeout);
	  }
}