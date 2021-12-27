package io.github.pancakeboiii.core.OrdinalAPI;

import java.io.IOException;
import java.net.MalformedURLException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.json.simple.parser.ParseException;

import io.github.pancakeboiii.core.Main;
import io.github.pancakeboiii.core.OrdinalAPI.DataManager.FileMan;
import io.github.pancakeboiii.core.OrdinalAPI.DataManager.JSON;
import io.github.pancakeboiii.core.OrdinalAPI.Minecraft.MCP;
import io.github.pancakeboiii.core.OrdinalAPI.Minecraft.Print;
import io.github.pancakeboiii.core.OrdinalAPI.UpdateChecker.UpdateManager;

@SuppressWarnings("unused")
public class Examples {
	public void OrdinalDownloads() throws ParseException, IOException {
		FileMan.Download("https://media.discordapp.net/attachments/800856358370934855/871477090476752946/Item.png", "Plugins/Stuff/");
		FileMan.DownloadCustomName("https://www.spigotmc.org/data/avatars/m/198/198507.jpg", "Plugins/Stuff/", "test");
		FileMan.DownloadCustomNameExtension("https://media.tenor.com/images/2271a02c8f22064b5228a44d8f1b1e09/tenor.gif", "Plugins/Stuff/", "Jim", ".bob");
		UpdateManager.checkupdate(Main.plugin, 94821, "https://www.spigotmc.org/resources/pancakecore.94821/");
		Print.Console(ChatColor.RED + JSON.GetFromURL("https://api.mcsrvstat.us/2/mc.hypixel.net", "ip"));
		Print.Console(ChatColor.RED + JSON.GetFromURL("https://api.mcsrvstat.us/2/mc.hypixel.net", "online"));
    	for (Player p: Bukkit.getOnlinePlayers()) {
    		if (MCP.CheckTag(p, "true").equals("true")) {
    			Print.Console(ChatColor.RED + "YESSSS");
    		}
    		if (MCP.CheckTag(p, "Jerry").equals("false")) {
    			Print.Console(ChatColor.RED + "NOOOOOOOOOOOOOOO");
    		}
    			}
	}
}