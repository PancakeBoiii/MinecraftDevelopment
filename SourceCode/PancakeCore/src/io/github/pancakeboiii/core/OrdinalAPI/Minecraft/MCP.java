package io.github.pancakeboiii.core.OrdinalAPI.Minecraft;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class MCP {
    public static void Damage(Player Player, int Amount) {
        Player.damage(Amount);
    }
    public static void SetHealth(Player Player, int Amount) {
        Player.setHealth(Amount);
    }
    public static void SetWalkSpeed(Player Player, int Speed) {
        Player.setWalkSpeed((float)(Speed * 0.1));
    }
    public static void SetFlySpeed(Player Player, int Speed) {
        Player.setFlySpeed((float)(Speed * 0.01));
    }
    public static void AddTag(Player Player, String Tag) {
        Player.addScoreboardTag(Tag);
    }
    public static void AddPotionEffect(Player Player, String Effect, int TimeInSeconds, int Amplifier, boolean Ambient, boolean Particles, boolean IconInCorner) {
        PotionEffectType PE = PotionEffectType.getByName(Effect.toUpperCase());
        Player.addPotionEffect(new PotionEffect(PE, TimeInSeconds * 20, Amplifier, Ambient, Particles, IconInCorner));
    }
    public static void RemovePotionEffect(Player Player, String Effect) {
        PotionEffectType PE = PotionEffectType.getByName(Effect.toUpperCase());
        Player.removePotionEffect(PE);
    }
    public static void RemoveTag(Player Player, String Tag) {
        Player.removeScoreboardTag(Tag);
    }
    public static void CloseInventory(Player Player) {
        Player.closeInventory();
    }
    public static void OpenInventory(Player Player, Inventory InventoryGUI) {
        Player.openInventory(InventoryGUI);
    }
    public static void SetFoodLevel(Player Player, int FoodLevel) {
        Player.setFoodLevel(FoodLevel);
    }
    public static int GetFoodLevel(Player Player) {
        int FoodLevel = Player.getFoodLevel();
        return FoodLevel;
    }
    public static void SetSneaking(Player Player, boolean SneakingTF) {
        Player.setSneaking(SneakingTF);
    }
    public static void SetGamemode(Player Player, String Gamemode) {
        String SetGamemode = "Gamemode." + Gamemode;
        Player.setGameMode(GameMode.valueOf(SetGamemode));
    }
    public static String GetGamemode(Player Player) {
    	String Gamemode = null;
    	Gamemode = Player.getGameMode().toString();
    	return Gamemode;
    }
    public static String CheckTag(Player Player, String Tag) {
        String OutputTag = null;
        int TagBreak = 0;
        for (String TagList: Player.getScoreboardTags()) {
            if (TagList.equals(Tag)) {
                OutputTag = "true";
                TagBreak = 1;
            }
            if (TagBreak == 1) {
                break;
            } else {
                OutputTag = "false";
            }
        }
        return OutputTag;

    }
}