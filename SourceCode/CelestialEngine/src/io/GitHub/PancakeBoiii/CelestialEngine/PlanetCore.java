package io.GitHub.PancakeBoiii.CelestialEngine;

import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.entity.Item;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Painting;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import io.github.pancakeboiii.core.OrdinalAPI.Minecraft.ActionBar;
import io.github.pancakeboiii.core.OrdinalAPI.Minecraft.MCP;
import io.github.pancakeboiii.core.OrdinalAPI.Minecraft.Title;

public class PlanetCore {
    public static void Main() {
        boolean debug = Main.plugin.getConfig().getBoolean("debug");
        String WarningTitle = Main.plugin.getConfig().getString("WarningTitle");
        String WarningSubtitleOxygen = Main.plugin.getConfig().getString("WarningSubtitleOxygen");
        String WarningSubtitleCold = Main.plugin.getConfig().getString("WarningSubtitleCold");
        String WarningSubtitleHot = Main.plugin.getConfig().getString("WarningSubtitleHot");

        for (String Planets: Main.plugin.getConfig().getConfigurationSection("Planets").getKeys(false)) {
            //EXPERIMENTAL
            boolean MobsUseOxygenEmitters = Main.plugin.getConfig().getBoolean("MobsUseOxygenEmitters");
            boolean MobsAffectedByTemperature = Main.plugin.getConfig().getBoolean("MobsAffectedByTemperature");
            //EXPERIMENTAL

            // CONFIG AND VARIABLES
            int oxygen = 0;
            int H_ThermalSafe = 0;
            UUID SaveEnt = null;
            int C_ThermalSafe = 0;
            String Thermal = Main.plugin.getConfig().getString("Planets." + Planets + ".Thermal");
            boolean isHabitable = Main.plugin.getConfig().getBoolean("Planets." + Planets + ".isHabitable");
            boolean CustomGravity = Main.plugin.getConfig().getBoolean("Planets." + Planets + ".CustomGravity");
            boolean SafeUnderground = Main.plugin.getConfig().getBoolean("Planets." + Planets + ".SafeUnderground");
            String HelmetType = Main.plugin.getConfig().getString("helmet-type");

            String H_ThermalChestplateType = Main.plugin.getConfig().getString("HOT_ThermalChestplateType");
            String H_ThermalLeggingsType = Main.plugin.getConfig().getString("HOT_ThermalLeggingsType");
            String H_ThermalBootsType = Main.plugin.getConfig().getString("HOT_ThermalBootsType");
            String C_ThermalChestplateType = Main.plugin.getConfig().getString("COLD_ThermalChestplateType");
            String C_ThermalLeggingsType = Main.plugin.getConfig().getString("COLD_ThermalLeggingsType");
            String C_ThermalBootsType = Main.plugin.getConfig().getString("COLD_ThermalBootsType");


            String WorldName = Planets;
            int WorldGravity = Main.plugin.getConfig().getInt("Planets." + Planets + ".WorldGravity");
            int Gravity = WorldGravity - 1;
            boolean StaticGravity = Main.plugin.getConfig().getBoolean("Planets." + Planets + ".StaticGravity");
            int StaticJump = Main.plugin.getConfig().getInt("Planets." + Planets + ".StaticJump");
            int StaticFall = Main.plugin.getConfig().getInt("Planets." + Planets + ".StaticFall");
            int OxygenRadius = Main.plugin.getConfig().getInt("Planets." + Planets + ".OxygenRadius");
            //Code
            for (Player p: Bukkit.getOnlinePlayers()) {
                if (p.getWorld().getName().equalsIgnoreCase(WorldName)) {
                    World PlanetWorld = Bukkit.getServer().getWorld(WorldName);
                    if (CustomGravity == true) {
                        if (StaticGravity == true) {
                            p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 21, StaticJump, false, false, false));
                            p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 21, StaticFall, false, false, false));
                        }
                        if (StaticGravity == false) {
                            p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 21, Gravity + 2, false, false, false));
                            p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 21, Gravity, false, false, false));

                        }

                    }
                    if (isHabitable == false) {
                        List < String > list = Main.plugin.getConfig().getStringList("OxygenEmitters");
                        for (String OxygenEmitters: list) {
                            for (int x = -OxygenRadius; x <= OxygenRadius; x++) {
                                for (int z = -OxygenRadius; z <= OxygenRadius; z++) {
                                    for (int y = -OxygenRadius / 2; y <= OxygenRadius / 2; y++) {
                                        final Material material = p.getLocation().add(x, y, z).getBlock().getType();
                                        if (OxygenEmitters.contentEquals(material.toString())) {
                                            oxygen = 1;
                                        }
                                    }
                                }
                            }
                        }
                        if (MobsUseOxygenEmitters == true) {
                            for (Entity e: PlanetWorld.getEntities()) {
                                if (!(e instanceof Player)) {
                                    if (!(e instanceof Item)) {
                                        if (!(e instanceof ExperienceOrb)) {
                                            if (!(e instanceof ArmorStand)) {
                                                if (!(e instanceof ItemFrame)) {
                                                    if (!(e instanceof Painting)) {
                                                        List < String > ImmuneEntityList = Main.plugin.getConfig().getStringList("Planets." + Planets + ".environment-immunity-list");
                                                        for (String ImmuneEntity: ImmuneEntityList) {
                                                        	if (!ImmuneEntity.isEmpty()) {
                                                        		
                                                            if (e.getType().toString().contains(ImmuneEntity)) {
                                                        List < String > Elist = Main.plugin.getConfig().getStringList("OxygenEmitters");
                                                        for (String OxygenEmitters: Elist) {
                                                            for (int x = -OxygenRadius; x <= OxygenRadius; x++) {
                                                                for (int z = -OxygenRadius; z <= OxygenRadius; z++) {
                                                                    for (int y = -OxygenRadius / 2; y <= OxygenRadius / 2; y++) {
                                                                        final Material material = e.getLocation().add(x, y, z).getBlock().getType();
                                                                        if (OxygenEmitters.contentEquals(material.toString())) {
                                                                            List < String > NonHabitableEffects = Main.plugin.getConfig().getStringList("Planets." + Planets + ".NonHabitableEffects");
                                                                            for (String NHPE: NonHabitableEffects) {
                                                                                
                                                                                PotionEffectType NonHabitableEffect = PotionEffectType.getByName(NHPE.toUpperCase());
                                                                                ((LivingEntity) e).removePotionEffect(NonHabitableEffect);
                                                                                SaveEnt = e.getUniqueId();
                                                                            }
                                                                        }
                                                                        if (!OxygenEmitters.contentEquals(material.toString())) {
                                                                            if (!e.getUniqueId().equals(SaveEnt)) {
                                                                                List < String > NonHabitableEffects = Main.plugin.getConfig().getStringList("Planets." + Planets + ".NonHabitableEffects");
                                                                                for (String NHPE: NonHabitableEffects) {
                                                                                    PotionEffectType NonHabitableEffect = PotionEffectType.getByName(NHPE.toUpperCase());
                                                                                    ((LivingEntity) e).addPotionEffect(new PotionEffect(NonHabitableEffect, 255, 2, false, false, false));
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }

                                                    }
                                                        	}
                                                        	
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (MobsUseOxygenEmitters == false) {
                            for (Entity e: PlanetWorld.getEntities())
                                if (!(e instanceof Player)) {
                                    if (!(e instanceof Item)) {
                                        if (!(e instanceof ExperienceOrb)) {
                                            if (!(e instanceof ArmorStand)) {
                                                if (!(e instanceof ItemFrame)) {
                                                    if (!(e instanceof Painting)) {
                                                        List < String > ImmuneEntityList = Main.plugin.getConfig().getStringList("Planets." + Planets + ".environment-immunity-list");
                                                        for (String ImmuneEntity: ImmuneEntityList) {
                                                        	if (!ImmuneEntity.isEmpty()) {
                                                        		
                                                            if (e.getType().toString().contains(ImmuneEntity)) {
                                                            	
                                                                List < String > NonHabitableEffects = Main.plugin.getConfig().getStringList("Planets." + Planets + ".NonHabitableEffects");
                                                                if (NonHabitableEffects != null) {
                                                                for (String NHPE: NonHabitableEffects) {
                                                                    PotionEffectType NonHabitableEffect = PotionEffectType.getByName(NHPE.toUpperCase());
                                                                    ((LivingEntity) e).removePotionEffect(NonHabitableEffect);
                                                                }

                                                            }
                                                            }
                                                        	}
                                                            if (!e.getType().toString().contains(ImmuneEntity)) {
                                                                if (MobsAffectedByTemperature == true) {
                                                                    List < String > NonHabitableEffects = Main.plugin.getConfig().getStringList("Planets." + Planets + ".NonHabitableEffects");
                                                                    for (String NHPE: NonHabitableEffects) {
                                                                        PotionEffectType NonHabitableEffect = PotionEffectType.getByName(NHPE.toUpperCase());
                                                                        ((LivingEntity) e).addPotionEffect(new PotionEffect(NonHabitableEffect, 255, 2, false, false, false));
                                                                    }
                                                                }

                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }


                        }

                        ItemStack Helmet = p.getInventory().getItem(39);
                        String HelmetString = "" + Helmet;
                        if (HelmetString.startsWith("ItemStack{" + HelmetType + " x")) {
                            oxygen = 1;
                        }
                        if (MCP.GetGamemode(p).contains("CREATIVE")) {oxygen = 1;}
                        if (MCP.GetGamemode(p).contains("SPECTATOR")) {oxygen = 1;}
                        if (oxygen == 1) {
                            List < String > NonHabitableEffects = Main.plugin.getConfig().getStringList("Planets." + Planets + ".NonHabitableEffects");
                            for (String NHPE: NonHabitableEffects) {
                                PotionEffectType NonHabitableEffect = PotionEffectType.getByName(NHPE.toUpperCase());
                                p.removePotionEffect(NonHabitableEffect);
                            }
                        }
                        if (!HelmetString.startsWith("ItemStack{" + HelmetType + " x")) {
                            if (oxygen == 0) {
                                Title.send(p, WarningTitle, WarningSubtitleOxygen, 0, 25, 0);
                                List < String > NonHabitableEffects = Main.plugin.getConfig().getStringList("Planets." + Planets + ".NonHabitableEffects");
                                for (String NHPE: NonHabitableEffects) {
                                    PotionEffectType NonHabitableEffect = PotionEffectType.getByName(NHPE.toUpperCase());
                                    p.addPotionEffect(new PotionEffect(NonHabitableEffect, 255, 2, false, false, false));
                                }

                            }
                        }

                        if (Thermal.contains("COLD")) {
                            ItemStack C_ThermalChestplate = p.getInventory().getItem(38);
                            ItemStack C_ThermalLeggings = p.getInventory().getItem(37);
                            ItemStack C_ThermalBoots = p.getInventory().getItem(36);
                            String C_ThermalChestplateString = "" + C_ThermalChestplate;
                            String C_ThermalLeggingsString = "" + C_ThermalLeggings;
                            String C_ThermalBootsString = "" + C_ThermalBoots;
                            if (C_ThermalChestplateString.startsWith("ItemStack{" + C_ThermalChestplateType + " x")) {
                                if (C_ThermalLeggingsString.startsWith("ItemStack{" + C_ThermalLeggingsType + " x")) {
                                    if (C_ThermalBootsString.startsWith("ItemStack{" + C_ThermalBootsType + " x")) {
                                        C_ThermalSafe = 1;
                                    }
                                }
                            }
                            Location loc = p.getLocation();
                            int playerPositionY = loc.getBlockY();
                            int highestBlock = loc.getWorld().getHighestBlockAt(loc).getY();
                            if (SafeUnderground == true) {
                                if (playerPositionY < highestBlock) {
                                    C_ThermalSafe = 1;
                                }
                            }
                            for (Entity e: PlanetWorld.getEntities()) {
                                if (!(e instanceof Player)) {
                                    if (!(e instanceof Item)) {
                                        if (!(e instanceof ExperienceOrb)) {
                                            if (!(e instanceof ArmorStand)) {
                                                if (!(e instanceof ItemFrame)) {
                                                    if (!(e instanceof Painting)) {
                                                        List < String > ImmuneEntityList = Main.plugin.getConfig().getStringList("Planets." + Planets + ".environment-immunity-list");
                                                        for (String ImmuneEntity: ImmuneEntityList) {
                                                            if (e.getType().toString().equalsIgnoreCase(ImmuneEntity)) {
                                                                List < String > ColdThermalEffects = Main.plugin.getConfig().getStringList("ThermalColdEffects");
                                                                for (String CTE: ColdThermalEffects) {
                                                                    PotionEffectType ColdThermalEffect = PotionEffectType.getByName(CTE.toUpperCase());
                                                                    if (ColdThermalEffect.toString() != null) {
                                                                        ((LivingEntity) e).removePotionEffect(ColdThermalEffect);
                                                                    }
                                                                }

                                                            }
                                                            if (!e.getType().toString().equalsIgnoreCase(ImmuneEntity)) {
                                                                List < String > ColdThermalEffects = Main.plugin.getConfig().getStringList("ThermalColdEffects");
                                                                for (String CTE: ColdThermalEffects) {
                                                                    if (MobsAffectedByTemperature == true) {
                                                                        PotionEffectType ColdThermalEffect = PotionEffectType.getByName(CTE.toUpperCase());
                                                                        if (ColdThermalEffect.toString() != null) {
                                                                            ((LivingEntity) e).addPotionEffect(new PotionEffect(ColdThermalEffect, 40, 0, false, false, false));
                                                                        }
                                                                    }
                                                                }

                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }

                            }
                            if (MCP.GetGamemode(p).contains("CREATIVE")) {C_ThermalSafe = 1;}
                            if (MCP.GetGamemode(p).contains("SPECTATOR")) {C_ThermalSafe = 1;}
                            if (C_ThermalSafe == 0) {
                                Title.send(p, WarningTitle, WarningSubtitleCold, 0, 25, 0);
                                List < String > ColdThermalEffects = Main.plugin.getConfig().getStringList("ThermalColdEffects");
                                for (String CTE: ColdThermalEffects) {
                                    PotionEffectType ColdThermalEffect = PotionEffectType.getByName(CTE.toUpperCase());
                                    p.addPotionEffect(new PotionEffect(ColdThermalEffect, 40, 0, false, false, false));
                                }
                            }

                        }
                        if (Thermal.contains("HOT")) {
                            ItemStack H_ThermalChestplate = p.getInventory().getItem(38);
                            ItemStack H_ThermalLeggings = p.getInventory().getItem(37);
                            ItemStack H_ThermalBoots = p.getInventory().getItem(36);
                            String H_ThermalChestplateString = "" + H_ThermalChestplate;
                            String H_ThermalLeggingsString = "" + H_ThermalLeggings;
                            String H_ThermalBootsString = "" + H_ThermalBoots;
                            if (H_ThermalChestplateString.startsWith("ItemStack{" + H_ThermalChestplateType + " x")) {
                                if (H_ThermalLeggingsString.startsWith("ItemStack{" + H_ThermalLeggingsType + " x")) {
                                    if (H_ThermalBootsString.startsWith("ItemStack{" + H_ThermalBootsType + " x")) {
                                        H_ThermalSafe = 1;
                                    }
                                }
                            }
                            Location loc = p.getLocation();
                            int playerPositionY = loc.getBlockY();
                            int highestBlock = loc.getWorld().getHighestBlockAt(loc).getY();
                            if (SafeUnderground = true) {
                                if (playerPositionY < highestBlock) {
                                    H_ThermalSafe = 1;
                                }
                            }
                            for (Entity e: PlanetWorld.getEntities()) {
                                if (!(e instanceof Player)) {
                                    Location Eloc = e.getLocation();
                                    int EntityPositionY = Eloc.getBlockY();
                                    int EhighestBlock = Eloc.getWorld().getHighestBlockAt(Eloc).getY();
                                    if (SafeUnderground = true) {
                                        if (EntityPositionY < EhighestBlock) {
                                            e.setFireTicks(0);
                                        } else {
                                            e.setFireTicks(60);
                                        }
                                    }
                                    if (SafeUnderground = false) {
                                        e.setFireTicks(60);
                                    }
                                }

                            }
                            if (MCP.GetGamemode(p).contains("CREATIVE")) {H_ThermalSafe = 1;}
                            if (MCP.GetGamemode(p).contains("SPECTATOR")) {H_ThermalSafe = 1;}
                            if (H_ThermalSafe == 0) {
                                Title.send(p, WarningTitle, WarningSubtitleHot, 0, 25, 0);
                                List < String > HotThermalEffects = Main.plugin.getConfig().getStringList("ThermalHotEffects");
                                for (String HTE: HotThermalEffects) {
                                    if (HTE != null) {
                                        MCP.AddPotionEffect(p, HTE, 2, 1, false, false, false);
                                    }
                                }
                            }
                            for (Entity e: PlanetWorld.getEntities()) {
                                if (!(e instanceof Player)) {
                                    if (!(e instanceof Item)) {
                                        if (!(e instanceof ExperienceOrb)) {
                                            if (!(e instanceof ArmorStand)) {
                                                if (!(e instanceof ItemFrame)) {
                                                    if (!(e instanceof Painting)) {
                                                        List < String > ImmuneEntityList = Main.plugin.getConfig().getStringList("Planets." + Planets + ".environment-immunity-list");
                                                        for (String ImmuneEntity: ImmuneEntityList) {
                                                            if (e.getType().toString().contains(ImmuneEntity)) {
                                                                List < String > HotThermalEffects = Main.plugin.getConfig().getStringList("ThermalHotEffects");
                                                                for (String HTE: HotThermalEffects) {
                                                                    PotionEffectType HotThermalEffect = PotionEffectType.getByName(HTE.toUpperCase());
                                                                    if (HotThermalEffect.toString() != null) {
                                                                        ((LivingEntity) e).removePotionEffect(HotThermalEffect);
                                                                    }
                                                                }

                                                            }
                                                            if (!e.getType().toString().contains(ImmuneEntity)) {
                                                                List < String > HotThermalEffects = Main.plugin.getConfig().getStringList("ThermalHotEffects");
                                                                for (String HTE: HotThermalEffects) {
                                                                	if (MobsAffectedByTemperature == true) {
                                                                        PotionEffectType HotThermalEffect = PotionEffectType.getByName(HTE.toUpperCase());
                                                                        if (HotThermalEffect.toString() != null) {
                                                                            ((LivingEntity) e).addPotionEffect(new PotionEffect(HotThermalEffect, 40, 0, false, false, false));
                                                                        }
                                                                    } else {
                                                                    	//NO
                                                                    }
                                                                }

                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }

                            }
                            for (Entity e: PlanetWorld.getEntities()) {
                                List < String > ImmuneEntityList = Main.plugin.getConfig().getStringList("Planets." + Planets + ".environment-immunity-list");
                                for (String ImmuneEntity: ImmuneEntityList) {
                                    if (e.getName().equalsIgnoreCase(ImmuneEntity)) {
                                        e.setFireTicks(0);
                                    }
                                }
                            }
                        }
                        if (debug == true) {
                            ActionBar.send(p, "Planet : " + Planets + " | " + "Oxygen : " + oxygen + " | " + "Helm : " + HelmetString + " | " + "HelmetType : " + HelmetType);
                        }
                        oxygen = 0;
                        H_ThermalSafe = 0;
                        C_ThermalSafe = 0;
                    }
                }
            }
        }
    }

}