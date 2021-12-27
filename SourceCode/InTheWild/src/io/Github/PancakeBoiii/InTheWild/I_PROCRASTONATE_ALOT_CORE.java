package io.Github.PancakeBoiii.InTheWild;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import eu.endercentral.crazy_advancements.Advancement;
import eu.endercentral.crazy_advancements.AdvancementDisplay;
import eu.endercentral.crazy_advancements.AdvancementDisplay.AdvancementFrame;
import eu.endercentral.crazy_advancements.AdvancementVisibility;
import eu.endercentral.crazy_advancements.NameKey;
import eu.endercentral.crazy_advancements.manager.AdvancementManager;
import io.Github.PancakeBoiii.InTheWild.Listeners.TemperatureCheck;
import io.Github.PancakeBoiii.InTheWild.events.TemperatureSystem;
import io.github.pancakeboiii.core.OrdinalAPI.DataManager.FileMan;
import io.github.pancakeboiii.core.OrdinalAPI.Minecraft.ActionBar;
import io.github.pancakeboiii.core.OrdinalAPI.Minecraft.MCP;
import io.github.pancakeboiii.core.OrdinalAPI.Minecraft.Print;
public class I_PROCRASTONATE_ALOT_CORE {
  public static void Main() throws IOException {

    for (Player p: Bukkit.getOnlinePlayers()) {
    	AdvancementManager manager = new AdvancementManager(p);
    	AdvancementDisplay rootDisplay = new AdvancementDisplay(Material.OAK_SAPLING, "§2InTheWild", "", AdvancementFrame.TASK, false, false, AdvancementVisibility.ALWAYS);
    	rootDisplay.setBackgroundTexture("textures/block/dirt.png");
    	Advancement root = new Advancement(null, new NameKey("custom", "root"), rootDisplay);
      if (MCP.GetGamemode(p).equals("SURVIVAL")) {
        if (Main.plugin.getConfig().getBoolean("Thirst") == true) {
          if (Main.plugin.getConfig().getBoolean("Temperature") == false) {
            Location loc = p.getLocation();
            World world = p.getWorld();
            Biome biome = world.getBiome(loc.getBlockX(), loc.getBlockZ());
            String Bt = p.getLocation().getBlock().getBiome().toString();
            Main.plugin.getConfig().getString("TestMessage");
            // Display Thirst
            File f = new File("plugins/InTheWild/UserData/" + p.getUniqueId().toString() + "/Thirst.yml");
            FileConfiguration UserData = YamlConfiguration.loadConfiguration(f);
            if (UserData.getInt("Thirst") <= 100) {
              ActionBar.send(p, "                          ⅎⅎⅎⅎⅎⅎⅎⅎⅎⅎ");
            }
            if (UserData.getInt("Thirst") <= 95) {
              ActionBar.send(p, "                          ↄⅎⅎⅎⅎⅎⅎⅎⅎⅎ");
            }
            if (UserData.getInt("Thirst") <= 90) {
              ActionBar.send(p, "                          Ɐⅎⅎⅎⅎⅎⅎⅎⅎⅎ");
            }
            if (UserData.getInt("Thirst") <= 85) {
              ActionBar.send(p, "                          Ɐↄⅎⅎⅎⅎⅎⅎⅎⅎ");
            }
            if (UserData.getInt("Thirst") <= 80) {
              ActionBar.send(p, "                          ⱯⱯⅎⅎⅎⅎⅎⅎⅎⅎ");
            }
            if (UserData.getInt("Thirst") <= 75) {
              ActionBar.send(p, "                          ⱯⱯↄⅎⅎⅎⅎⅎⅎⅎ");
            }
            if (UserData.getInt("Thirst") <= 70) {
              ActionBar.send(p, "                          ⱯⱯⱯⅎⅎⅎⅎⅎⅎⅎ");
            }
            if (UserData.getInt("Thirst") <= 65) {
              ActionBar.send(p, "                          ⱯⱯⱯↄⅎⅎⅎⅎⅎⅎ");
            }
            if (UserData.getInt("Thirst") <= 60) {
              ActionBar.send(p, "                          ⱯⱯⱯⱯⅎⅎⅎⅎⅎⅎ");
            }
            if (UserData.getInt("Thirst") <= 55) {
              ActionBar.send(p, "                          ⱯⱯⱯⱯↄⅎⅎⅎⅎⅎ");
            }
            if (UserData.getInt("Thirst") <= 50) {
              ActionBar.send(p, "                          ⱯⱯⱯⱯⱯⅎⅎⅎⅎⅎ");
            }
            if (UserData.getInt("Thirst") <= 45) {
              ActionBar.send(p, "                          ⱯⱯⱯⱯⱯↄⅎⅎⅎⅎ");
            }
            if (UserData.getInt("Thirst") <= 40) {
              ActionBar.send(p, "                          ⱯⱯⱯⱯⱯⱯⅎⅎⅎⅎ");
            }
            if (UserData.getInt("Thirst") <= 35) {
              ActionBar.send(p, "                          ⱯⱯⱯⱯⱯⱯↄⅎⅎⅎ");
            }
            if (UserData.getInt("Thirst") <= 30) {
              ActionBar.send(p, "                          ⱯⱯⱯⱯⱯⱯⱯⅎⅎⅎ");
            }
            if (UserData.getInt("Thirst") <= 25) {
              ActionBar.send(p, "                          ⱯⱯⱯⱯⱯⱯⱯↄⅎⅎ");
            }
            if (UserData.getInt("Thirst") <= 20) {
              ActionBar.send(p, "                          ⱯⱯⱯⱯⱯⱯⱯⱯⅎⅎ");
            }
            if (UserData.getInt("Thirst") <= 15) {
              ActionBar.send(p, "                          ⱯⱯⱯⱯⱯⱯⱯⱯↄⅎ");
            }
            if (UserData.getInt("Thirst") <= 10) {
              ActionBar.send(p, "                          ⱯⱯⱯⱯⱯⱯⱯⱯⱯⅎ");
            }
            if (UserData.getInt("Thirst") <= 5) {
              ActionBar.send(p, "                          ⱯⱯⱯⱯⱯⱯⱯⱯⱯↄ");
            }
            if (UserData.getInt("Thirst") <= 0) {
              ActionBar.send(p, "                          ⱯⱯⱯⱯⱯⱯⱯⱯⱯⱯ");
            }
            //Effects
            if (UserData.getInt("Thirst") <= 3) {
              MCP.AddPotionEffect(p, "SLOW", 5, 1, false, false, false);
            }
            if (UserData.getInt("Thirst") <= 1) {
              MCP.AddPotionEffect(p, "CONFUSION", 5, 1, false, false, false);
            }
            if (UserData.getInt("Thirst") <= 0) {
              MCP.AddPotionEffect(p, "WITHER", 2, 0, false, false, false);
            }
            PotionEffect effect = p.getPlayer().getPotionEffect(PotionEffectType.HUNGER);
            if (effect != null) {
              File PreUserData = new File("plugins/InTheWild/UserData/" + p.getUniqueId().toString() + "/Thirst.yml");
              if (UserData.getInt("Thirst") <= 100) {
                ActionBar.send(p, "                          ɬɬɬɬɬɬɬɬɬɬ");
              }
              if (UserData.getInt("Thirst") <= 95) {
                ActionBar.send(p, "                          ɷɬɬɬɬɬɬɬɬɬ");
              }
              if (UserData.getInt("Thirst") <= 90) {
                ActionBar.send(p, "                          ȸɬɬɬɬɬɬɬɬɬ");
              }
              if (UserData.getInt("Thirst") <= 85) {
                ActionBar.send(p, "                          ȸɷɬɬɬɬɬɬɬɬ");
              }
              if (UserData.getInt("Thirst") <= 80) {
                ActionBar.send(p, "                          ȸȸɬɬɬɬɬɬɬɬ");
              }
              if (UserData.getInt("Thirst") <= 75) {
                ActionBar.send(p, "                          ȸȸɷɬɬɬɬɬɬɬ");
              }
              if (UserData.getInt("Thirst") <= 70) {
                ActionBar.send(p, "                          ȸȸȸɬɬɬɬɬɬɬ");
              }
              if (UserData.getInt("Thirst") <= 65) {
                ActionBar.send(p, "                          ȸȸȸɷɬɬɬɬɬɬ");
              }
              if (UserData.getInt("Thirst") <= 60) {
                ActionBar.send(p, "                          ȸȸȸȸɬɬɬɬɬɬ");
              }
              if (UserData.getInt("Thirst") <= 55) {
                ActionBar.send(p, "                          ȸȸȸȸɷɬɬɬɬɬ");
              }
              if (UserData.getInt("Thirst") <= 50) {
                ActionBar.send(p, "                          ȸȸȸȸȸɬɬɬɬɬ");
              }
              if (UserData.getInt("Thirst") <= 45) {
                ActionBar.send(p, "                          ȸȸȸȸȸɷɬɬɬɬ");
              }
              if (UserData.getInt("Thirst") <= 40) {
                ActionBar.send(p, "                          ȸȸȸȸȸȸɬɬɬɬ");
              }
              if (UserData.getInt("Thirst") <= 35) {
                ActionBar.send(p, "                          ȸȸȸȸȸȸɷɬɬɬ");
              }
              if (UserData.getInt("Thirst") <= 30) {
                ActionBar.send(p, "                          ȸȸȸȸȸȸȸɬɬɬ");
              }
              if (UserData.getInt("Thirst") <= 25) {
                ActionBar.send(p, "                          ȸȸȸȸȸȸȸɷɬɬ");
              }
              if (UserData.getInt("Thirst") <= 20) {
                ActionBar.send(p, "                          ȸȸȸȸȸȸȸȸɬɬ");
              }
              if (UserData.getInt("Thirst") <= 15) {
                ActionBar.send(p, "                          ȸȸȸȸȸȸȸȸɷɬ");
              }
              if (UserData.getInt("Thirst") <= 10) {
                ActionBar.send(p, "                          ȸȸȸȸȸȸȸȸȸɬ");
              }
              if (UserData.getInt("Thirst") <= 5) {
                ActionBar.send(p, "                          ȸȸȸȸȸȸȸȸȸɷ");
              }
              if (UserData.getInt("Thirst") <= 0) {
                ActionBar.send(p, "                          ȸȸȸȸȸȸȸȸȸȸ");
              }
              Random r = new Random();
              int low = 0;
              int high = 200;
              int result = r.nextInt(high - low) + low;
              if (UserData.getInt("Thirst") >= 0) {
                if (result >= 50) {
                  int NewThirst = UserData.getInt("Thirst") - 1;
                  FileMan.WriteToFile(PreUserData.toString(), "Thirst: " + NewThirst);
                }
              }
            }
            PotionEffect effectSat = p.getPlayer().getPotionEffect(PotionEffectType.SATURATION);
            if (effectSat != null) {
              File PreUserData = new File("plugins/InTheWild/UserData/" + p.getUniqueId().toString() + "/Thirst.yml");
              int NewThirst = UserData.getInt("Thirst") + 5;
              FileMan.WriteToFile(PreUserData.toString(), "Thirst: " + NewThirst);
            }
            File PreUserData = new File("plugins/InTheWild/UserData/" + p.getUniqueId().toString() + "/Thirst.yml");
            int NewThirst = UserData.getInt("Thirst");
            if (NewThirst > 100) {
              NewThirst = 100;
            }
            FileMan.WriteToFile(PreUserData.toString(), "Thirst: " + NewThirst);
          }
        }

      }
      // Both Enables
      if (MCP.GetGamemode(p).equals("SURVIVAL")) {
        if (Main.plugin.getConfig().getBoolean("Thirst") == true) {
          if (Main.plugin.getConfig().getBoolean("Temperature") == true) {
            Location loc = p.getLocation();
            World world = p.getWorld();
            Biome biome = world.getBiome(loc.getBlockX(), loc.getBlockZ());
            String Bt = p.getLocation().getBlock().getBiome().toString();
            Main.plugin.getConfig().getString("TestMessage");
            // Display Thirst & Temperature
            File f = new File("plugins/InTheWild/UserData/" + p.getUniqueId().toString() + "/Thirst.yml");
            FileConfiguration UserData = YamlConfiguration.loadConfiguration(f);
            TemperatureSystem.Main(p);
            String TemperatureIcon = TemperatureCheck.GetTemp(p);
            if (UserData.getInt("Thirst") <= 100) {
              ActionBar.send(p, "                      " + TemperatureIcon + "  ⅎⅎⅎⅎⅎⅎⅎⅎⅎⅎ");
            }
            if (UserData.getInt("Thirst") <= 95) {
              ActionBar.send(p, "                      " + TemperatureIcon + "  ↄⅎⅎⅎⅎⅎⅎⅎⅎⅎ");
            }
            if (UserData.getInt("Thirst") <= 90) {
              ActionBar.send(p, "                      " + TemperatureIcon + "  Ɐⅎⅎⅎⅎⅎⅎⅎⅎⅎ");
            }
            if (UserData.getInt("Thirst") <= 85) {
              ActionBar.send(p, "                      " + TemperatureIcon + "  Ɐↄⅎⅎⅎⅎⅎⅎⅎⅎ");
            }
            if (UserData.getInt("Thirst") <= 80) {
              ActionBar.send(p, "                      " + TemperatureIcon + "  ⱯⱯⅎⅎⅎⅎⅎⅎⅎⅎ");
            }
            if (UserData.getInt("Thirst") <= 75) {
              ActionBar.send(p, "                      " + TemperatureIcon + "  ⱯⱯↄⅎⅎⅎⅎⅎⅎⅎ");
            }
            if (UserData.getInt("Thirst") <= 70) {
              ActionBar.send(p, "                      " + TemperatureIcon + "  ⱯⱯⱯⅎⅎⅎⅎⅎⅎⅎ");
            }
            if (UserData.getInt("Thirst") <= 65) {
              ActionBar.send(p, "                      " + TemperatureIcon + "  ⱯⱯⱯↄⅎⅎⅎⅎⅎⅎ");
            }
            if (UserData.getInt("Thirst") <= 60) {
              ActionBar.send(p, "                      " + TemperatureIcon + "  ⱯⱯⱯⱯⅎⅎⅎⅎⅎⅎ");
            }
            if (UserData.getInt("Thirst") <= 55) {
              ActionBar.send(p, "                      " + TemperatureIcon + "  ⱯⱯⱯⱯↄⅎⅎⅎⅎⅎ");
            }
            if (UserData.getInt("Thirst") <= 50) {
              ActionBar.send(p, "                      " + TemperatureIcon + "  ⱯⱯⱯⱯⱯⅎⅎⅎⅎⅎ");
            }
            if (UserData.getInt("Thirst") <= 45) {
              ActionBar.send(p, "                      " + TemperatureIcon + "  ⱯⱯⱯⱯⱯↄⅎⅎⅎⅎ");
            }
            if (UserData.getInt("Thirst") <= 40) {
              ActionBar.send(p, "                      " + TemperatureIcon + "  ⱯⱯⱯⱯⱯⱯⅎⅎⅎⅎ");
            }
            if (UserData.getInt("Thirst") <= 35) {
              ActionBar.send(p, "                      " + TemperatureIcon + "  ⱯⱯⱯⱯⱯⱯↄⅎⅎⅎ");
            }
            if (UserData.getInt("Thirst") <= 30) {
              ActionBar.send(p, "                      " + TemperatureIcon + "  ⱯⱯⱯⱯⱯⱯⱯⅎⅎⅎ");
            }
            if (UserData.getInt("Thirst") <= 25) {
              ActionBar.send(p, "                      " + TemperatureIcon + "  ⱯⱯⱯⱯⱯⱯⱯↄⅎⅎ");
            }
            if (UserData.getInt("Thirst") <= 20) {
              ActionBar.send(p, "                      " + TemperatureIcon + "  ⱯⱯⱯⱯⱯⱯⱯⱯⅎⅎ");
            }
            if (UserData.getInt("Thirst") <= 15) {
              ActionBar.send(p, "                      " + TemperatureIcon + "  ⱯⱯⱯⱯⱯⱯⱯⱯↄⅎ");
            }
            if (UserData.getInt("Thirst") <= 10) {
              ActionBar.send(p, "                      " + TemperatureIcon + "  ⱯⱯⱯⱯⱯⱯⱯⱯⱯⅎ");
            }
            if (UserData.getInt("Thirst") <= 5) {
              ActionBar.send(p, "                      " + TemperatureIcon + "  ⱯⱯⱯⱯⱯⱯⱯⱯⱯↄ");
            }
            if (UserData.getInt("Thirst") <= 0) {
              ActionBar.send(p, "                      " + TemperatureIcon + "  ⱯⱯⱯⱯⱯⱯⱯⱯⱯⱯ");
            }
            //Effects
            File fT = new File("plugins/InTheWild/UserData/" + p.getUniqueId().toString() + "/Temperature.yml");
            FileConfiguration UserDataT = YamlConfiguration.loadConfiguration(fT);
            if (UserData.getInt("Thirst") <= 3) {
              MCP.AddPotionEffect(p, "SLOW", 5, 1, false, false, false);
            }
            if (UserData.getInt("Thirst") <= 1) {
              MCP.AddPotionEffect(p, "CONFUSION", 5, 1, false, false, false);
            }
            if (UserData.getInt("Thirst") <= 0) {
              MCP.AddPotionEffect(p, "WITHER", 2, 0, false, false, false);
            }
            if (UserDataT.getInt("Temperature") <= -91) {
                MCP.AddPotionEffect(p, "SLOW", 5, 1, false, false, false);
              }
              if (UserDataT.getInt("Temperature") <= -91) {
                MCP.AddPotionEffect(p, "BLINDNESS", 5, 1, false, false, false);
              }
              if (UserDataT.getInt("Temperature") <= -91) {
                MCP.AddPotionEffect(p, "WITHER", 2, 0, false, false, false);
              }
              if (UserDataT.getInt("Temperature") >= 91) {
                  MCP.AddPotionEffect(p, "SLOW", 5, 1, false, false, false);
                }
                if (UserDataT.getInt("Temperature") >= 91) {
                  MCP.AddPotionEffect(p, "CONFUSION", 5, 1, false, false, false);
                }
                if (UserDataT.getInt("Temperature") >= 91) {
                  MCP.AddPotionEffect(p, "WITHER", 2, 0, false, false, false);
                }
            PotionEffect effect = p.getPlayer().getPotionEffect(PotionEffectType.HUNGER);
            if (effect != null) {
            	
              File PreUserData = new File("plugins/InTheWild/UserData/" + p.getUniqueId().toString() + "/Thirst.yml");
              if (UserData.getInt("Thirst") <= 100) {
                ActionBar.send(p, "                      " + TemperatureIcon + "  ɬɬɬɬɬɬɬɬɬɬ");
              }
              if (UserData.getInt("Thirst") <= 95) {
                ActionBar.send(p, "                      " + TemperatureIcon + "  ɷɬɬɬɬɬɬɬɬɬ");
              }
              if (UserData.getInt("Thirst") <= 90) {
                ActionBar.send(p, "                      " + TemperatureIcon + "  ȸɬɬɬɬɬɬɬɬɬ");
              }
              if (UserData.getInt("Thirst") <= 85) {
                ActionBar.send(p, "                      " + TemperatureIcon + "  ȸɷɬɬɬɬɬɬɬɬ");
              }
              if (UserData.getInt("Thirst") <= 80) {
                ActionBar.send(p, "                      " + TemperatureIcon + "  ȸȸɬɬɬɬɬɬɬɬ");
              }
              if (UserData.getInt("Thirst") <= 75) {
                ActionBar.send(p, "                      " + TemperatureIcon + "  ȸȸɷɬɬɬɬɬɬɬ");
              }
              if (UserData.getInt("Thirst") <= 70) {
                ActionBar.send(p, "                      " + TemperatureIcon + "  ȸȸȸɬɬɬɬɬɬɬ");
              }
              if (UserData.getInt("Thirst") <= 65) {
                ActionBar.send(p, "                      " + TemperatureIcon + "  ȸȸȸɷɬɬɬɬɬɬ");
              }
              if (UserData.getInt("Thirst") <= 60) {
                ActionBar.send(p, "                      " + TemperatureIcon + "  ȸȸȸȸɬɬɬɬɬɬ");
              }
              if (UserData.getInt("Thirst") <= 55) {
                ActionBar.send(p, "                      " + TemperatureIcon + "  ȸȸȸȸɷɬɬɬɬɬ");
              }
              if (UserData.getInt("Thirst") <= 50) {
                ActionBar.send(p, "                      " + TemperatureIcon + "  ȸȸȸȸȸɬɬɬɬɬ");
              }
              if (UserData.getInt("Thirst") <= 45) {
                ActionBar.send(p, "                      " + TemperatureIcon + "  ȸȸȸȸȸɷɬɬɬɬ");
              }
              if (UserData.getInt("Thirst") <= 40) {
                ActionBar.send(p, "                      " + TemperatureIcon + "  ȸȸȸȸȸȸɬɬɬɬ");
              }
              if (UserData.getInt("Thirst") <= 35) {
                ActionBar.send(p, "                      " + TemperatureIcon + "  ȸȸȸȸȸȸɷɬɬɬ");
              }
              if (UserData.getInt("Thirst") <= 30) {
                ActionBar.send(p, "                      " + TemperatureIcon + "  ȸȸȸȸȸȸȸɬɬɬ");
              }
              if (UserData.getInt("Thirst") <= 25) {
                ActionBar.send(p, "                      " + TemperatureIcon + "  ȸȸȸȸȸȸȸɷɬɬ");
              }
              if (UserData.getInt("Thirst") <= 20) {
                ActionBar.send(p, "                      " + TemperatureIcon + "  ȸȸȸȸȸȸȸȸɬɬ");
              }
              if (UserData.getInt("Thirst") <= 15) {
                ActionBar.send(p, "                      " + TemperatureIcon + "  ȸȸȸȸȸȸȸȸɷɬ");
              }
              if (UserData.getInt("Thirst") <= 10) {
                ActionBar.send(p, "                      " + TemperatureIcon + "  ȸȸȸȸȸȸȸȸȸɬ");
              }
              if (UserData.getInt("Thirst") <= 5) {
                ActionBar.send(p, "                      " + TemperatureIcon + "  ȸȸȸȸȸȸȸȸȸɷ");
              }
              if (UserData.getInt("Thirst") <= 0) {
                ActionBar.send(p, "                      " + TemperatureIcon + "  ȸȸȸȸȸȸȸȸȸȸ");
              }
              Random r = new Random();
              int low = 0;
              int high = 200;
              int result = r.nextInt(high - low) + low;
              if (UserData.getInt("Thirst") >= 0) {
                if (result >= 50) {
                  int NewThirst = UserData.getInt("Thirst") - 1;
                  FileMan.WriteToFile(PreUserData.toString(), "Thirst: " + NewThirst);
                }
              }
            }
            PotionEffect effectSat = p.getPlayer().getPotionEffect(PotionEffectType.SATURATION);
            if (effectSat != null) {
              File PreUserData = new File("plugins/InTheWild/UserData/" + p.getUniqueId().toString() + "/Thirst.yml");
              int NewThirst = UserData.getInt("Thirst") + 5;
              FileMan.WriteToFile(PreUserData.toString(), "Thirst: " + NewThirst);
            }
            File PreUserData = new File("plugins/InTheWild/UserData/" + p.getUniqueId().toString() + "/Thirst.yml");
            int NewThirst = UserData.getInt("Thirst");
            if (NewThirst > 100) {
              NewThirst = 100;
            }
            FileMan.WriteToFile(PreUserData.toString(), "Thirst: " + NewThirst);
          }
        }

      }
      if (MCP.GetGamemode(p).equals("SURVIVAL")) {
        if (Main.plugin.getConfig().getBoolean("Thirst") == false) {
          if (Main.plugin.getConfig().getBoolean("Temperature") == true) {
            Location loc = p.getLocation();
            World world = p.getWorld();
            Biome biome = world.getBiome(loc.getBlockX(), loc.getBlockZ());
            String Bt = p.getLocation().getBlock().getBiome().toString();
            Main.plugin.getConfig().getString("TestMessage");
            // Display Thirst
            File f = new File("plugins/InTheWild/UserData/" + p.getUniqueId().toString() + "/Temperature.yml");
            FileConfiguration UserData = YamlConfiguration.loadConfiguration(f);
            TemperatureSystem.Main(p);
            String TemperatureIcon = TemperatureCheck.GetTemp(p); {
              ActionBar.send(p, TemperatureIcon);
            }
            if (UserData.getInt("Temperature") <= -91) {
              MCP.AddPotionEffect(p, "SLOW", 5, 1, false, false, false);
            }
            if (UserData.getInt("Temperature") <= -91) {
              MCP.AddPotionEffect(p, "BLINDNESS", 5, 1, false, false, false);
            }
            if (UserData.getInt("Temperature") <= -91) {
              MCP.AddPotionEffect(p, "WITHER", 2, 0, false, false, false);
            }
            if (UserData.getInt("Temperature") >= 91) {
                MCP.AddPotionEffect(p, "SLOW", 5, 1, false, false, false);
              }
              if (UserData.getInt("Temperature") >= 91) {
                MCP.AddPotionEffect(p, "CONFUSION", 5, 1, false, false, false);
              }
              if (UserData.getInt("Temperature") >= 91) {
                MCP.AddPotionEffect(p, "WITHER", 2, 0, false, false, false);
              }
          }
        }

      }
    }
  }

}