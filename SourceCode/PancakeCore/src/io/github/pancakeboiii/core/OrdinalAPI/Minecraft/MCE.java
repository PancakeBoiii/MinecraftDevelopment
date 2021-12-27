package io.github.pancakeboiii.core.OrdinalAPI.Minecraft;

import org.bukkit.entity.LivingEntity;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class MCE {
    public static void Damage(LivingEntity Entity, int Amount) {
        Entity.damage(Amount);
    }
    public static void SetHealth(LivingEntity Entity, int Amount) {
        Entity.setHealth(Amount);
    }
    public static void AddTag(LivingEntity Entity, String Tag) {
        Entity.addScoreboardTag(Tag);
    }
    public static void AddPotionEffect(LivingEntity Entity, String Effect, int TimeInSeconds, int Amplifier, boolean Ambient, boolean Particles, boolean IconInCorner) {
        PotionEffectType PE = PotionEffectType.getByName(Effect.toUpperCase());
        Entity.addPotionEffect(new PotionEffect(PE, TimeInSeconds * 20, Amplifier, Ambient, Particles, IconInCorner));
    }
    public static void RemovePotionEffect(LivingEntity Entity, String Effect) {
        PotionEffectType PE = PotionEffectType.getByName(Effect.toUpperCase());
        Entity.removePotionEffect(PE);
    }
    public static void RemoveTag(LivingEntity Entity, String Tag) {
        Entity.removeScoreboardTag(Tag);
    }
    public static String CheckTag(LivingEntity Entity, String Tag) {
        String OutputTag = null;
        int TagBreak = 0;
        for (String TagList: Entity.getScoreboardTags()) {
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