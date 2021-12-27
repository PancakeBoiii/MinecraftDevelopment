package io.Github.PancakeBoiii.InTheWild.events;

import java.io.File;
import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import io.github.pancakeboiii.core.OrdinalAPI.DataManager.FileMan;

public class OwO_He_Kicked_The_Bucket_Listener implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onDeath(PlayerDeathEvent e) {
        Player p = e.getEntity().getPlayer();
        File f = new File("plugins/InTheWild/UserData/" + p.getUniqueId().toString() + "/Thirst.yml");
        FileConfiguration UserData = YamlConfiguration.loadConfiguration(f);
        File fT = new File("plugins/InTheWild/UserData/" + p.getUniqueId().toString() + "/Temperature.yml");
        FileConfiguration UserDataT = YamlConfiguration.loadConfiguration(fT);
        if (e.getDeathMessage().contains("withered away")) {
            if (UserData.getInt("Thirst") <= 0) {
                if (e.getDeathMessage().contains("withered")) {
                    Random r = new Random();
                    int low = 1;
                    int high = 4;
                    int result = r.nextInt(high - low) + low;
                    if (result <= 3) {
                        e.setDeathMessage(e.getEntity().getName() + (ChatColor.translateAlternateColorCodes('&', " died from dehydration")));
                    }
                    if (result >= 2) {
                        e.setDeathMessage(e.getEntity().getName() + (ChatColor.translateAlternateColorCodes('&', " forgot to hydrate")));
                    }

                }
            }
            if (UserDataT.getInt("Temperature") >= 91) {
                if (e.getDeathMessage().contains("withered")) {
                    Random r = new Random();
                    int low = 1;
                    int high = 4;
                    int result = r.nextInt(high - low) + low;
                    if (result <= 3) {
                        e.setDeathMessage(e.getEntity().getName() + (ChatColor.translateAlternateColorCodes('&', " died from overheating")));
                    }
                    if (result >= 2) {
                        e.setDeathMessage(e.getEntity().getName() + (ChatColor.translateAlternateColorCodes('&', " forgot to cool off")));
                    }

                }
            }
            if (UserDataT.getInt("Temperature") <= -91) {
                if (e.getDeathMessage().contains("withered")) {
                    Random r = new Random();
                    int low = 1;
                    int high = 4;
                    int result = r.nextInt(high - low) + low;
                    if (result <= 3) {
                        e.setDeathMessage(e.getEntity().getName() + (ChatColor.translateAlternateColorCodes('&', " died from hypothermia")));
                    }
                    if (result >= 2) {
                        e.setDeathMessage(e.getEntity().getName() + (ChatColor.translateAlternateColorCodes('&', " froze to death")));
                    }

                }
            }
        }

    }
    
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onRespawn(PlayerRespawnEvent e) {
        Player p = e.getPlayer();
        if (p instanceof Player) {
            File PreUserData = new File("plugins/InTheWild/UserData/" + p.getUniqueId().toString() + "/Thirst.yml");
            FileMan.WriteToFile(PreUserData.toString(), "Thirst: " + 100);
            File PreUserData2 = new File("plugins/InTheWild/UserData/" + p.getUniqueId().toString() + "/Temperature.yml");
            FileMan.WriteToFile(PreUserData2.toString(), "Temperature: " + 0);
        }
    }
}