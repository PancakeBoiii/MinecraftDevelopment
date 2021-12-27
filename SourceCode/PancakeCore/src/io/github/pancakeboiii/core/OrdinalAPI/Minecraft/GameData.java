package io.github.pancakeboiii.core.OrdinalAPI.Minecraft;

import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import io.github.pancakeboiii.core.Main;

public class GameData {
    //STRING SET NBT
    public static void SetItemStackString(Player Player, ItemStack item, String StoredData, String DataTitle) {
        ItemMeta meta = item.getItemMeta();
        PersistentDataContainer data = meta.getPersistentDataContainer();
        NamespacedKey namespacedKey = new NamespacedKey(Main.plugin, DataTitle);
        data.set(namespacedKey, PersistentDataType.STRING, StoredData);
        item.setItemMeta(meta);
    }
    //STRING GET NBT
    public static String GetItemStackString(Player Player, ItemStack item, String DataTitle) {
        ItemMeta meta = item.getItemMeta();
        PersistentDataContainer data = meta.getPersistentDataContainer();
        NamespacedKey namespacedKey = new NamespacedKey(Main.plugin, DataTitle);
        if (data.has(namespacedKey, PersistentDataType.STRING)) {
            String Output = data.get(namespacedKey, PersistentDataType.STRING);
            return Output;
        }
        return null;
    }



    //INTEGER SET NBT
    public static void SetItemStackInt(Player Player, ItemStack item, int Int, String DataTitle) {
        ItemMeta meta = item.getItemMeta();
        PersistentDataContainer data = meta.getPersistentDataContainer();
        NamespacedKey namespacedKey = new NamespacedKey(Main.plugin, DataTitle);
        data.set(namespacedKey, PersistentDataType.INTEGER, Int);
        item.setItemMeta(meta);
    }
    //INTEGER GET NBT
    public static int GetItemStackInt(Player Player, ItemStack item, String DataTitle) {
        ItemMeta meta = item.getItemMeta();
        PersistentDataContainer data = meta.getPersistentDataContainer();
        NamespacedKey namespacedKey = new NamespacedKey(Main.plugin, DataTitle);
        if (data.has(namespacedKey, PersistentDataType.INTEGER)) {
            int Output = data.get(namespacedKey, PersistentDataType.INTEGER);
            return Output;
        }
        return (Integer) null;
    }









    //STRING SET NBT
    public static void SetBlockString(Location BlokLoc, String StoredData, String DataTitle) {
        Location location = BlokLoc.getBlock().getLocation();
        Main.plugin.DM.getConfig().set(DataTitle + "." + location.getBlockX() + "/" + location.getBlockY() + "/" + location.getBlockZ() + "/" + location.getWorld().getName() + "." + "Type", BlokLoc.getBlock().getType().toString());
        Main.plugin.DM.getConfig().set(DataTitle + "." + location.getBlockX() + "/" + location.getBlockY() + "/" + location.getBlockZ() + "/" + location.getWorld().getName() + "." + "StoredData", StoredData);
        Main.plugin.DM.saveConfig();
    }
    //INT SET  NBT
    public static void SetBlockInt(Location BlokLoc, int StoredData, String DataTitle) {
        Location location = BlokLoc.getBlock().getLocation();
        Main.plugin.DM.getConfig().set(DataTitle + "." + location.getBlockX() + "/" + location.getBlockY() + "/" + location.getBlockZ() + "/" + location.getWorld().getName() + "." + "Type", BlokLoc.getBlock().getType().toString());
        Main.plugin.DM.getConfig().set(DataTitle + "." + location.getBlockX() + "/" + location.getBlockY() + "/" + location.getBlockZ() + "/" + location.getWorld().getName() + "." + "StoredData", StoredData);
        Main.plugin.DM.saveConfig();
    }

    //REMOVE NBT
    public static void RemoveBlockData(String DataTitle, String BlokLoc) {
        String[] COORDS = BlokLoc.split("/");
        String x = COORDS[0];
        String y = COORDS[1];
        String z = COORDS[2];
        String DIM = COORDS[3];
        Main.plugin.DM.getConfig().set(DataTitle + "." + x + "/" + y + "/" + z + "/" + DIM, null);
        Main.plugin.DM.saveConfig();
        if (Main.plugin.DM.getConfig().getConfigurationSection(DataTitle) == null) {
            Main.plugin.DM.getConfig().set(DataTitle, null);
        }
    }






    public static String GetBlockData(String DataTitle, String BlokLoc, String StoredDataorType) {
        String[] COORDS = BlokLoc.split("/");
        String x = COORDS[0];
        String y = COORDS[1];
        String z = COORDS[2];
        String DIM = COORDS[3];
        String Output = Main.plugin.DM.getConfig().getString(DataTitle + "." + x + "/" + y + "/" + z + "/" + DIM + "." + StoredDataorType);
        return Output;
    }
}