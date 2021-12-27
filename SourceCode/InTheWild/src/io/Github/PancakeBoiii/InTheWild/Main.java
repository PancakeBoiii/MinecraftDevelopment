package io.Github.PancakeBoiii.InTheWild;



import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.CommandExecutor;
import org.bukkit.inventory.CampfireRecipe;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;
import io.Github.PancakeBoiii.InTheWild.Listeners.CampfireListener;
import io.Github.PancakeBoiii.InTheWild.Listeners.SoulCampfireListener;
import io.Github.PancakeBoiii.InTheWild.Listeners.SoulTorchListener;
import io.Github.PancakeBoiii.InTheWild.Listeners.TemperatureListener;
import io.Github.PancakeBoiii.InTheWild.Listeners.ThirstListener;
import io.Github.PancakeBoiii.InTheWild.Listeners.TorchListener;
import io.Github.PancakeBoiii.InTheWild.commands.reloadcommand;
import io.Github.PancakeBoiii.InTheWild.commands.settempcommand;
import io.Github.PancakeBoiii.InTheWild.commands.setthirstcommand;
import io.Github.PancakeBoiii.InTheWild.events.OwO_He_Kicked_The_Bucket_Listener;
import io.Github.PancakeBoiii.InTheWild.events.ThirstSystem;
import io.github.pancakeboiii.core.OrdinalAPI.Minecraft.PluginMessage;
import io.github.pancakeboiii.core.OrdinalAPI.UpdateChecker.UpdateManager;

public class Main extends JavaPlugin {
    public static Main plugin;
    // This code sucks, you know it and I know it.
    // If you are reading this, that means you are either snooping or have decided to take over and maintain this project.
    // let the number below act as a warning for the next person, and add hours to it accordingly.
    int Total_Hours_Wasted_On_This_God_Forsaken_Project = 45;
    @Override
    public void onEnable() {
        plugin = this;
        PluginManager pm = Bukkit.getPluginManager();
        plugin = this;
        PluginMessage.StartupMessage(this);
        UpdateManager.checkupdate(this, 95139, "https://www.spigotmc.org/resources/inthewild.95139/");
        this.saveDefaultConfig();
        getCommand("reload").setExecutor(new reloadcommand());
        getCommand("setthirst").setExecutor(new setthirstcommand());
        getCommand("settemp").setExecutor(new settempcommand());

        //Recipe Manager
        if (Main.plugin.getConfig().getBoolean("Thirst") == true) {
            PurifiedWaterRecipeFurnace();
            PurifiedWaterRecipeCampfire();
        }
        AcaciaSaplingStick();
        BirchSaplingStick();
        DarkOakSaplingStick();
        JungleSaplingStick();
        OakSaplingStick();
        SpruceSaplingStick();
        //Recipe Manager End



        PluginMessage.LoadedMessage(this);

        if (Main.plugin.getConfig().getBoolean("Thirst") == true) {
            pm.registerEvents(new ThirstListener(), this);
            pm.registerEvents(new ThirstSystem(), this);
        }
        if (Main.plugin.getConfig().getBoolean("Temperature") == true) {
            pm.registerEvents(new TemperatureListener(), this);
        }
        if (Main.plugin.getConfig().getBoolean("Torch-Burnout") == true) {
            pm.registerEvents(new TorchListener(), this);
        }
        if (Main.plugin.getConfig().getBoolean("Campfire-Burnout") == true) {
            pm.registerEvents(new SoulCampfireListener(), this);
        }
        if (Main.plugin.getConfig().getBoolean("Soul-Campfire-Burnout") == true) {
            pm.registerEvents(new CampfireListener(), this);
        }
        if (Main.plugin.getConfig().getBoolean("Soul-Torch-Burnout") == true) {
            pm.registerEvents(new SoulTorchListener(), this);
        }
        pm.registerEvents(new OwO_He_Kicked_The_Bucket_Listener(), this);
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            public void run() {
                //MAIN PLUGIN HERE
                try {
                    if (Main.plugin.getConfig().getBoolean("Thirst") == true || Main.plugin.getConfig().getBoolean("Temperature") == true) {
                        I_PROCRASTONATE_ALOT_CORE.Main();
                    }
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }, 20L, 20L);
    }

    @SuppressWarnings("deprecation")
    private void PurifiedWaterRecipeFurnace() {
        ItemStack result = new ItemStack(Material.POTION);
        Material Input = Material.POTION;
        List < String > l = new ArrayList < String > ();
        l.add("§r§bPurified");
        ItemMeta m = result.getItemMeta();
        m.setLore(l);
        result.setItemMeta(m);
        PotionMeta pm = (PotionMeta) result.getItemMeta();

        pm.setColor(Color.fromRGB(102, 255, 255));
        pm.setBasePotionData(new PotionData(PotionType.WATER));
        result.setItemMeta(pm);
        FurnaceRecipe PurifiedWaterRecipeFurnace = new FurnaceRecipe(result, Material.POTION);
        getServer().addRecipe(PurifiedWaterRecipeFurnace);
    }
    @SuppressWarnings("deprecation")
    private void PurifiedWaterRecipeCampfire() {
        ItemStack result = new ItemStack(Material.POTION);
        Material Input = Material.POTION;
        List < String > l = new ArrayList < String > ();
        l.add("§r§bPurified");
        ItemMeta m = result.getItemMeta();
        m.setLore(l);
        result.setItemMeta(m);
        PotionMeta pm = (PotionMeta) result.getItemMeta();

        pm.setColor(Color.fromRGB(102, 255, 255));
        pm.setBasePotionData(new PotionData(PotionType.WATER));
        result.setItemMeta(pm);
        NamespacedKey key = new NamespacedKey(plugin, "PurifiedWaterRecipe");
        CampfireRecipe PurifiedWaterRecipeCampfire = new CampfireRecipe(key, result, Material.POTION, 0, 140);
        getServer().addRecipe(PurifiedWaterRecipeCampfire);
    }
    private void AcaciaSaplingStick() {
        ItemStack is = new ItemStack(Material.STICK, 4);
        NamespacedKey key = new NamespacedKey(plugin, "AcaciaSaplingStick");
        ShapelessRecipe sr = new ShapelessRecipe(key, is);
        sr.addIngredient(1, Material.ACACIA_SAPLING);
        Bukkit.addRecipe(sr);
    }
    private void BirchSaplingStick() {
        ItemStack is = new ItemStack(Material.STICK, 4);
        NamespacedKey key = new NamespacedKey(plugin, "BirchSaplingStick");
        ShapelessRecipe sr = new ShapelessRecipe(key, is);
        sr.addIngredient(1, Material.BIRCH_SAPLING);
        Bukkit.addRecipe(sr);
    }
    private void DarkOakSaplingStick() {
        ItemStack is = new ItemStack(Material.STICK, 4);
        NamespacedKey key = new NamespacedKey(plugin, "DarkOakSaplingStick");
        ShapelessRecipe sr = new ShapelessRecipe(key, is);
        sr.addIngredient(1, Material.DARK_OAK_SAPLING);
        Bukkit.addRecipe(sr);
    }
    private void JungleSaplingStick() {
        ItemStack is = new ItemStack(Material.STICK, 4);
        NamespacedKey key = new NamespacedKey(plugin, "JungleSaplingStick");
        ShapelessRecipe sr = new ShapelessRecipe(key, is);
        sr.addIngredient(1, Material.JUNGLE_SAPLING);
        Bukkit.addRecipe(sr);
    }
    private void OakSaplingStick() {
        ItemStack is = new ItemStack(Material.STICK, 4);
        NamespacedKey key = new NamespacedKey(plugin, "OakSaplingStick");
        ShapelessRecipe sr = new ShapelessRecipe(key, is);
        sr.addIngredient(1, Material.OAK_SAPLING);
        Bukkit.addRecipe(sr);
    }
    private void SpruceSaplingStick() {
        ItemStack is = new ItemStack(Material.STICK, 4);
        NamespacedKey key = new NamespacedKey(plugin, "SpruceSaplingStick");
        ShapelessRecipe sr = new ShapelessRecipe(key, is);
        sr.addIngredient(1, Material.SPRUCE_SAPLING);
        Bukkit.addRecipe(sr);
    }
    public void onDisable() {
        NamespacedKey PurifiedWaterRecipe = new NamespacedKey(plugin, "PurifiedWaterRecipe");
        NamespacedKey AcaciaSaplingStick = new NamespacedKey(plugin, "AcaciaSaplingStick");
        NamespacedKey BirchSaplingStick = new NamespacedKey(plugin, "BirchSaplingStick");
        NamespacedKey DarkOakSaplingStick = new NamespacedKey(plugin, "DarkOakSaplingStick");
        NamespacedKey JungleSaplingStick = new NamespacedKey(plugin, "JungleSaplingStick");
        NamespacedKey OakSaplingStick = new NamespacedKey(plugin, "OakSaplingStick");
        NamespacedKey SpruceSaplingStick = new NamespacedKey(plugin, "SpruceSaplingStick");
        Bukkit.removeRecipe(PurifiedWaterRecipe);
        Bukkit.removeRecipe(AcaciaSaplingStick);
        Bukkit.removeRecipe(BirchSaplingStick);
        Bukkit.removeRecipe(DarkOakSaplingStick);
        Bukkit.removeRecipe(JungleSaplingStick);
        Bukkit.removeRecipe(OakSaplingStick);
        Bukkit.removeRecipe(SpruceSaplingStick);
        PluginMessage.DisableMessage(this);

    }

}