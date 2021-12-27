package io.Github.PancakeBoiii.InTheWild.events;

import java.io.File;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

import com.google.common.collect.Sets;

import io.github.pancakeboiii.core.OrdinalAPI.DataManager.FileMan;
import io.github.pancakeboiii.core.OrdinalAPI.Minecraft.MCP;
import io.github.pancakeboiii.core.OrdinalAPI.Minecraft.Print;

public class ThirstSystem implements Listener {
    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        File PreUserData = new File("plugins/InTheWild/UserData/" + p.getUniqueId().toString() + "/Thirst.yml");
        FileConfiguration UserData = YamlConfiguration.loadConfiguration(PreUserData);
        if (e.getFrom().getZ() != e.getTo().getZ() && e.getFrom().getX() != e.getTo().getX()) {
            Random r = new Random();
            int low = 0;
            int high = 200;
            int result = r.nextInt(high - low) + low;
            if (UserData.getInt("Thirst") >= 0) {
                if (result >= 198) {
                    int NewThirst = UserData.getInt("Thirst") - 1;
                    FileMan.WriteToFile(PreUserData.toString(), "Thirst: " + NewThirst);
                }
            }
        }
    }
    private Set < UUID > prevPlayersOnGround = Sets.newHashSet();
    @SuppressWarnings("deprecation")
    @EventHandler
    public void Jump(PlayerMoveEvent e) {
        Player player = e.getPlayer();
        File PreUserData = new File("plugins/InTheWild/UserData/" + player.getUniqueId().toString() + "/Thirst.yml");
        FileConfiguration UserData = YamlConfiguration.loadConfiguration(PreUserData);
        if (player.getVelocity().getY() > 0) {
            double jumpVelocity = (double) 0.42F;
            if (player.hasPotionEffect(PotionEffectType.JUMP)) {
                jumpVelocity += (double)((float)(player.getPotionEffect(PotionEffectType.JUMP).getAmplifier() + 1) * 0.1F);
            }
            if (e.getPlayer().getLocation().getBlock().getType() != Material.LADDER && prevPlayersOnGround.contains(player.getUniqueId())) {
                if (!player.isOnGround() && Double.compare(player.getVelocity().getY(), jumpVelocity) == 0) {
                    Random r = new Random();
                    int low = 0;
                    int high = 160;
                    int result = r.nextInt(high - low) + low;
                    if (UserData.getInt("Thirst") >= 0) {
                        if (result >= 155) {
                            int NewThirst = UserData.getInt("Thirst") - 1;
                            FileMan.WriteToFile(PreUserData.toString(), "Thirst: " + NewThirst);
                        }
                    }
                }
            }
        }
        if (player.isOnGround()) {
            prevPlayersOnGround.add(player.getUniqueId());
        } else {
            prevPlayersOnGround.remove(player.getUniqueId());
        }
    }
    
   /* 
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onBlockClick(PlayerInteractEvent e){
    	Player player = e.getPlayer();
    	if(e.getAction() == Action.RIGHT_CLICK_BLOCK){
        	if (player.isSneaking() == true) {
            Block block = e.getClickedBlock();
            if(block.getType() == Material.DIRT){
                    
                    File PreUserData = new File("plugins/InTheWild/UserData/" + player.getUniqueId().toString() + "/Thirst.yml");
                    FileConfiguration UserData = YamlConfiguration.loadConfiguration(PreUserData);
                    int NewThirst = UserData.getInt("Thirst") + 5;
                    if (NewThirst >= 100) {
                        NewThirst = 100;
                    }
                    FileMan.WriteToFile(PreUserData.toString(), "Thirst: " + NewThirst);
                    Random r = new Random();
                    int low = 0;
                    int high = 2;
                    int result = r.nextInt(high - low) + low;
                    if (UserData.getInt("Thirst") >= 0) {
                        if (result >= 1) {
                        	MCP.AddPotionEffect(e.getPlayer(), "HUNGER", 20, 0, false, false, false);
                        }
                    }
            }
        }
    	}
    }
 */
    
    @EventHandler
    public void Dronk(PlayerItemConsumeEvent e) {
        Player player = e.getPlayer();
        File PreUserData = new File("plugins/InTheWild/UserData/" + player.getUniqueId().toString() + "/Thirst.yml");
        FileConfiguration UserData = YamlConfiguration.loadConfiguration(PreUserData);
        if (e.getItem().getType().equals(Material.MILK_BUCKET)) {
            int NewThirst = UserData.getInt("Thirst") + 30;
            if (NewThirst >= 100) {
                NewThirst = 100;
            }
            FileMan.WriteToFile(PreUserData.toString(), "Thirst: " + NewThirst);
        }
        
        if (e.getItem().getType().equals(Material.RABBIT_STEW)) {
            int NewThirst = UserData.getInt("Thirst") + 25;
            if (NewThirst >= 100) {
                NewThirst = 100;
            }
            FileMan.WriteToFile(PreUserData.toString(), "Thirst: " + NewThirst);
        }
        if (e.getItem().getType().equals(Material.MUSHROOM_STEW)) {
            int NewThirst = UserData.getInt("Thirst") + 20;
            if (NewThirst >= 100) {
                NewThirst = 100;
            }
            FileMan.WriteToFile(PreUserData.toString(), "Thirst: " + NewThirst);
        }
        if (e.getItem().getType().equals(Material.BEETROOT_SOUP)) {
            int NewThirst = UserData.getInt("Thirst") + 10;
            if (NewThirst >= 100) {
                NewThirst = 100;
            }
            FileMan.WriteToFile(PreUserData.toString(), "Thirst: " + NewThirst);
        }
        if (e.getItem().getType().equals(Material.SWEET_BERRIES)) {
            int NewThirst = UserData.getInt("Thirst") + 1;
            if (NewThirst >= 100) {
                NewThirst = 100;
            }
            FileMan.WriteToFile(PreUserData.toString(), "Thirst: " + NewThirst);
        }
        if (e.getItem().getType().equals(Material.APPLE)) {
            int NewThirst = UserData.getInt("Thirst") + 5;
            if (NewThirst >= 100) {
                NewThirst = 100;
            }
            FileMan.WriteToFile(PreUserData.toString(), "Thirst: " + NewThirst);
        }
        if (e.getItem().getType().equals(Material.GOLDEN_APPLE)) {
            int NewThirst = UserData.getInt("Thirst") + 20;
            if (NewThirst >= 100) {
                NewThirst = 100;
            }
            FileMan.WriteToFile(PreUserData.toString(), "Thirst: " + NewThirst);
        }
        if (e.getItem().getType().equals(Material.ENCHANTED_GOLDEN_APPLE)) {
            int NewThirst = UserData.getInt("Thirst") + 60;
            if (NewThirst >= 100) {
                NewThirst = 100;
            }
            FileMan.WriteToFile(PreUserData.toString(), "Thirst: " + NewThirst);
        }
        if (e.getItem() != null && e.getItem().hasItemMeta()) {
            if (e.getItem().getItemMeta() instanceof PotionMeta) {


                final PotionMeta meta = (PotionMeta) e.getItem().getItemMeta();
                final PotionData data = meta.getBasePotionData();
                if (data.getType() == PotionType.MUNDANE) {
                    int NewThirst = UserData.getInt("Thirst") + 20;
                    if (NewThirst >= 100) {
                        NewThirst = 100;
                    }
                    FileMan.WriteToFile(PreUserData.toString(), "Thirst: " + NewThirst);
                }
                if (data.getType() == PotionType.WATER) {
                    if (e.getItem().getItemMeta().getLore() != null) {
                        for (String s: e.getItem().getItemMeta().getLore()) {
                            FileMan.WriteToFile("plugins/Purified.txt", "" + e.getItem().getItemMeta().getLore().toString());
                            if (e.getItem().getItemMeta().getLore().toString().contains(s)) {
                                int NewThirst = UserData.getInt("Thirst") + 35;
                                if (NewThirst >= 100) {
                                    NewThirst = 100;
                                }
                                FileMan.WriteToFile(PreUserData.toString(), "Thirst: " + NewThirst);
                            }
                        }
                    }
                }
                if (e.getItem().getItemMeta().getLore() == null) {
                    if (data.getType() == PotionType.WATER) {
                        int NewThirst = UserData.getInt("Thirst") + 5;
                        if (NewThirst >= 100) {
                            NewThirst = 100;
                        }
                        FileMan.WriteToFile(PreUserData.toString(), "Thirst: " + NewThirst);
                        Random r = new Random();
                        int low = 0;
                        int high = 2;
                        int result = r.nextInt(high - low) + low;
                        if (UserData.getInt("Thirst") >= 0) {
                            if (result >= 1) {
                            	MCP.AddPotionEffect(e.getPlayer(), "HUNGER", 20, 0, false, false, false);
                            }
                        }
                    }
                }
            }
        }
    }

}