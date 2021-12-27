package io.Github.PancakeBoiii.InTheWild.events;

import java.io.File;
import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.data.Lightable;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Boat;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import io.github.pancakeboiii.core.OrdinalAPI.Minecraft.GetBiome;
import io.github.pancakeboiii.core.OrdinalAPI.DataManager.FileMan;
import io.github.pancakeboiii.core.OrdinalAPI.Minecraft.Print;
import net.md_5.bungee.api.ChatColor;
import net.minecraft.resources.MinecraftKey;
import net.minecraft.world.level.biome.BiomeBase;

public class TemperatureSystem {
	
    static int sneakaction = 0;
    @SuppressWarnings({
        "unused",
        "deprecation"
    })
    public static void Main(Player p) {
    	int CampfireSkip=0;
    	int FireSkip=0;
    	int SoulFireSkip=0;
    	int SoulCampfireSkip=0;
    	int LavaSkip=0;
    	int MagmaSkip=0;
    	int WaterSkip=0;
        String Bt = p.getLocation().getBlock().getBiome().toString();
        File PreUserData = new File("plugins/InTheWild/UserData/" + p.getUniqueId().toString() + "/Temperature.yml");
        FileConfiguration UserData = YamlConfiguration.loadConfiguration(PreUserData);
        File ConfData = new File("plugins/InTheWild/config.yml");
        FileConfiguration Config = YamlConfiguration.loadConfiguration(ConfData);
        //Print.Player(p, Bt);
        if (p.getItemInHand().toString().contains("ItemStack{COMPASS x") && p.isSneaking()) {
            int Temperature = UserData.getInt("Temperature");
            String TempOutput = null;
            if (Temperature > 14 && Temperature < 61) {
                TempOutput = ChatColor.GOLD + "WARM";
            }
            if (Temperature > 60 && Temperature < 90) {
                TempOutput = ChatColor.RED + "HOT";
            }
            if (Temperature > 89 && Temperature < 104) {
                TempOutput = ChatColor.DARK_RED + "BURNING";
            }
            if (Temperature < 15 && Temperature > -15) {
                TempOutput = ChatColor.GRAY + "NORMAL";
            }
            if (Temperature < -14 && Temperature > -61) {
                TempOutput = ChatColor.AQUA + "COLD";
            }
            if (Temperature < -60 && Temperature > -90) {
                TempOutput = ChatColor.AQUA + "FREEZING";
            }
            if (Temperature < -89 && Temperature > -104) {
                TempOutput = ChatColor.BLUE + "HYPOTHERMIA";
            }

            Print.Player(p, "Temperature : " + Temperature + "  Status : " + TempOutput);
        }
        int StartTemp = UserData.getInt("Temperature");
        if (Config.getBoolean("Temperature-Neutral-Campfires") == false) {
        	campfireskip:
            if (CampfireSkip==0) {
            for (int x = -4; x <= 4; x++) {
                for (int z = -4; z <= 4; z++) {
                    for (int y = -3; y <= 3; y++) {
                        final Material material = p.getLocation().add(x, y, z).getBlock().getType();
                        if (material == Material.CAMPFIRE) {
                            final Block block = p.getLocation().add(x, y, z).getBlock();
                            Lightable data = (Lightable) block.getBlockData();
                            if (data.isLit()) {
                                //Print.Player(p, "current type: " + material);
                                AddTemp(p, 1, 5, 2);
                                CampfireSkip = 1;
                                break campfireskip;
                            }
                        }
                    }
                }
            }
        }
        }
        if (Config.getBoolean("Temperature-Neutral-Campfires") == true) {
            for (int x = -4; x <= 4; x++) {
                for (int z = -4; z <= 4; z++) {
                    for (int y = -3; y <= 3; y++) {
                        final Material material = p.getLocation().add(x, y, z).getBlock().getType();
                        if (material == Material.CAMPFIRE) {
                            final Block block = p.getLocation().add(x, y, z).getBlock();
                            Lightable data = (Lightable) block.getBlockData();
                            if (data.isLit()) {
                                if (UserData.getInt("Temperature") < 0) {
                                    AddTemp(p, 1, 5, 2);
                                }

                            }
                        }
                    }
                }
            }
        }
        fireskip:
        if (CampfireSkip==0) {
        for (int x = -4; x <= 4; x++) {
            for (int z = -4; z <= 4; z++) {
                for (int y = -3; y <= 3; y++) {
                    final Material material = p.getLocation().add(x, y, z).getBlock().getType();
                    if (material == Material.FIRE) {
                        final Block block = p.getLocation().add(x, y, z).getBlock();
                        AddTemp(p, 1, 5, 2);
                        FireSkip = 1;
                        break fireskip;
                    }
                }
            }
        }
        lavaskip:
        	if (LavaSkip==0) {
        for (int x = -4; x <= 4; x++) {
            for (int z = -4; z <= 4; z++) {
                for (int y = -3; y <= 3; y++) {
                    final Material material = p.getLocation().add(x, y, z).getBlock().getType();
                    if (material == Material.LAVA) {
                        final Block block = p.getLocation().add(x, y, z).getBlock();
                        AddTemp(p, 1, 10, 1);
                        LavaSkip = 1;
                        break lavaskip;
                    }
                }
            }
        }
        }
        for (int x = -4; x <= 4; x++) {
            for (int z = -4; z <= 4; z++) {
                for (int y = -3; y <= 3; y++) {
                    final Material material = p.getLocation().add(x, y, z).getBlock().getType();
                    if (material == Material.MAGMA_BLOCK) {
                        final Block block = p.getLocation().add(x, y, z).getBlock();
                        AddTemp(p, 1, 10, 2);
                    }
                }
            }
        }
        for (int x = -0; x <= 0; x++) {
            for (int z = -0; z <= 0; z++) {
                for (int y = 0; y <= 1; y++) {
                    final Material material = p.getLocation().add(x, y, z).getBlock().getType();
                    if (material == Material.WATER) {
                        if (!p.isInsideVehicle()) {
                            if (!(p.getVehicle() instanceof Boat)) {
                                final Block block = p.getLocation().add(x, y, z).getBlock();
                                String B = p.getLocation().getBlock().getBiome().toString();
                                if (B.equalsIgnoreCase("desert") || B.equalsIgnoreCase("Desert_hills")) {
                                    if (UserData.getInt("Temperature") > 15) {
                                        RemoveTemp(p, 1, 4, 1);
                                    }
                                } else {
                                    RemoveTemp(p, 1, 5, 2);
                                }
                            }
                        }
                    }
                }
            }
        }

        for (int x = -4; x <= 4; x++) {
            for (int z = -4; z <= 4; z++) {
                for (int y = -3; y <= 3; y++) {
                    final Material material = p.getLocation().add(x, y, z).getBlock().getType();
                    if (material == Material.PACKED_ICE) {
                        RemoveTemp(p, 1, 10, 2);
                    }
                }
            }
        }

        if (UserData.getInt("Temperature") > 100) {
            int NewTemp = 100;
            FileMan.WriteToFile(PreUserData.toString(), "Temperature: " + NewTemp);

        }
        if (UserData.getInt("Temperature") < -100) {
            int NewTemp = -100;
            FileMan.WriteToFile(PreUserData.toString(), "Temperature: " + NewTemp);

        }


        TemperatureSystem.RegisterBiomeTemperature(p, "badlands_plateau", 75, 80, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "bamboo_jungle", 10, 15, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "bamboo_jungle_hills", 10, 15, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "basalt_deltas", 85, 89, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "BEACH", 16, 20, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "BIRCH_FOREST", 0, 5, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "BIRCH_FOREST_HILLS", 0, 5, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "Cold_Ocean", -80, -75, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "crimson_forest", 75, 80, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "DARK_FOREST", 0, 5, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "DARK_FOREST_HILLS", 0, 5, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "Deep_Cold_Ocean", -80, -75, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "Deep_Frozen_Ocean", -100, -95, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "deep_lukewarm_ocean", 5, 10, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "Deep_Ocean", -20, -15, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "deep_warm_ocean", 10, 15, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "Desert", 75, 80, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "desert_hills", 65, 70, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "Desert_Lakes", 65, 70, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "dripstone_caves", -20, -15, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "end_barrens", 0, 0, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "end_highlands", 0, 0, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "end_midlands", 0, 0, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "eroded_badlands", 75, 80, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "flower_forest", 0, 5, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "FOREST", 0, 5, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "Frozen_Ocean", -100, -95, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "frozen_river", -100, -95, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "giant_spruce_taiga", 0, 5, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "giant_spruce_taiga_hills", 0, 5, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "giant_tree_taiga", 0, 5, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "giant_tree_taiga_hills", 0, 5, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "gravelly_mountains", -40, -35, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "ICE_SPIKES", -95, -90, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "jungle", 15, 20, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "jungle_edge", 15, 20, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "jungle_hills", 15, 20, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "lukewarm_ocean", 5, 10, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "lush_caves", -5, 5, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "modified_badlands_plateau", 75, 80, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "modified_gravelly_mountains", -40, -35, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "modified_jungle", 15, 20, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "modified_jungle_edge", 15, 20, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "modified_wooded_badlands_plateau", 65, 70, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "mountain_edge", -40, -35, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "mountains", -40, -35, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "mushroom_field_shore", -5, 5, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "mushroom_fields", -5, 5, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "nether_wastes", 85, 89, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "Ocean", -20, -15, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "river", 0, 0, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "savanna", 45, 50, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "savanna_plateau", 45, 50, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "shattered_savanna", 45, 50, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "shattered_savanna_plateau", 45, 50, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "small_end_islands", 0, 0, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "Snowy_BEACH", -50, -55, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "snowy_mountains", -80, -75, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "snowy_taiga", -80, -75, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "snowy_taiga_hills", -80, -75, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "snowy_taiga_mountains", -80, -75, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "snowy_tundra", -80, -75, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "soul_sand_valley", 75, 89, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "stone_shore", -15, 15, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "sunflower_plains", 0, 0, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "SWAMP", -5, 5, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "SWAMP_Hills", -5, 5, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "taiga_hills", 0, 5, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "taiga_mountains", -40, -35, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "tall_birch_forest", 0, 5, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "tall_birch_hills", 0, 5, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "the_end", 0, 0, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "the_void", 0, 0, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "warm_ocean", 10, 15, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "warped_forest", 75, 80, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "wooded_badlands_plateau", 65, 70, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "wooded_hills", 0, 5, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "wooded_hills", 15, 20, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "wooded_mountains", -40, -35, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "Plains", 0, 0, 5, 3);
        TemperatureSystem.RegisterBiomeTemperature(p, "badlands", 75, 80, 5, 3);

        int FinalTemp = UserData.getInt("Temperature");
        ItemStack C_ThermalHelmet = p.getInventory().getItem(39);
        ItemStack C_ThermalChestplate = p.getInventory().getItem(38);
        ItemStack C_ThermalLeggings = p.getInventory().getItem(37);
        ItemStack C_ThermalBoots = p.getInventory().getItem(36);
        String C_ThermalHelmetString = "" + C_ThermalHelmet;
        String C_ThermalChestplateString = "" + C_ThermalChestplate;
        String C_ThermalLeggingsString = "" + C_ThermalLeggings;
        String C_ThermalBootsString = "" + C_ThermalBoots;
        int TempDifference = StartTemp - FinalTemp;
        if (C_ThermalHelmetString.startsWith("ItemStack{" + "LEATHER_HELMET" + " x")) {
            if (C_ThermalChestplateString.startsWith("ItemStack{" + "LEATHER_CHESTPLATE" + " x")) {
                if (C_ThermalLeggingsString.startsWith("ItemStack{" + "LEATHER_LEGGINGS" + " x")) {
                    if (C_ThermalBootsString.startsWith("ItemStack{" + "LEATHER_BOOTS" + " x")) {
                        if (StartTemp >= FinalTemp) {
                        	if (UserData.getInt("Temperature") < 100) {
                            AddTemp(p, 1, 7, 2);
                        	}
                        }
                    }
                }
            }
        }
        }
    }



    public static void RegisterBiomeTemperature(Player p, String Biome, int MinTemp, int MaxTemp, int TempChance, int TempChanceRain) {
        String Bt = p.getLocation().getBlock().getBiome().toString();
        File PreUserData = new File("plugins/InTheWild/UserData/" + p.getUniqueId().toString() + "/Temperature.yml");
        FileConfiguration UserData = YamlConfiguration.loadConfiguration(PreUserData);
        if (Bt.equalsIgnoreCase(Biome)) {
            World w = p.getWorld();
            long time = w.getTime();
            if (w.hasStorm() == true) {
                Location Eloc = p.getLocation();
                int EntityPositionY = Eloc.getBlockY();
                int EhighestBlock = Eloc.getWorld().getHighestBlockAt(Eloc).getY();
                if (EntityPositionY < EhighestBlock) {} else {
                    RemoveTemp(p, 1, TempChanceRain, 1);
                }

            }
            /*if (time < 12300 || time > 23850) {
                	AddTemp(p, 1, TempChance, 2);
            }*/
            if (UserData.getInt("Temperature") > MaxTemp) {
                RemoveTemp(p, 1, TempChance, 1);
                //Print.Player(p, "" + Biome);
            }
            if (UserData.getInt("Temperature") < MinTemp) {
                AddTemp(p, 1, TempChance, 1);
            }
        }
    }
    public static void RegisterBiomeFile(Player p, String Biome, int MinTemp, int MaxTemp, int TempChance, int TempChanceRain) {
        File PreUserData = new File("plugins/InTheWild" + "/Biomes.yml");
        FileConfiguration UserData = YamlConfiguration.loadConfiguration(PreUserData);
        FileMan.AppendToFile(PreUserData.toString(), "Biomes:");
        FileMan.AppendToFile(PreUserData.toString(), "  " + Biome +":");
        FileMan.AppendToFile(PreUserData.toString(), "    MinTemp: " + MinTemp);
        FileMan.AppendToFile(PreUserData.toString(), "    MaxTemp: " + MaxTemp);
        FileMan.AppendToFile(PreUserData.toString(), "    TempChance: " + TempChance);
        FileMan.AppendToFile(PreUserData.toString(), "    TempChanceRain: " + TempChanceRain);
        
    }

    public static void RemoveTemp(Player p, int Min, int Max, int RemoveAmount) {
        File PreUserData = new File("plugins/InTheWild/UserData/" + p.getUniqueId().toString() + "/Temperature.yml");
        FileConfiguration UserData = YamlConfiguration.loadConfiguration(PreUserData);
        Random r = new Random();
        int low = Min;
        int high = Max;
        int result = r.nextInt(high - low) + low;
        if (result >= Max - 2) {
            int NewTemp = UserData.getInt("Temperature") - RemoveAmount;
            FileMan.WriteToFile(PreUserData.toString(), "Temperature: " + NewTemp);
        }
    }
    public static void AddTemp(Player p, int Min, int Max, int AddAmount) {
        File PreUserData = new File("plugins/InTheWild/UserData/" + p.getUniqueId().toString() + "/Temperature.yml");
        FileConfiguration UserData = YamlConfiguration.loadConfiguration(PreUserData);
        Random r = new Random();
        int low = Min;
        int high = Max;
        int result = r.nextInt(high - low) + low;
        if (result >= Max - 2) {
            int NewTemp = UserData.getInt("Temperature") + AddAmount;
            FileMan.WriteToFile(PreUserData.toString(), "Temperature: " + NewTemp);
        }
    }
    public static void SetTemp(Player p, int AddAmount) {
        File PreUserData = new File("plugins/InTheWild/UserData/" + p.getUniqueId().toString() + "/Temperature.yml");
        FileConfiguration UserData = YamlConfiguration.loadConfiguration(PreUserData);
        int NewTemp = AddAmount;
        FileMan.WriteToFile(PreUserData.toString(), "Temperature: " + NewTemp);
    }
}