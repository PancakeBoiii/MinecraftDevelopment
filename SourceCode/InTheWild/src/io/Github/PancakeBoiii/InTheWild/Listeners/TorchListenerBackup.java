package io.Github.PancakeBoiii.InTheWild.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

import io.Github.PancakeBoiii.InTheWild.Main;
import io.github.pancakeboiii.core.OrdinalAPI.Minecraft.Print;

public class TorchListenerBackup implements Listener {

    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        if (e.getBlock().getType() == Material.TORCH || e.getBlock().getType() == Material.WALL_TORCH) {
            java.util.List < String > TorchLocations = Main.plugin.getConfig().getStringList("TorchLocations");
            TorchLocations.add(e.getBlock().getLocation().toString());
            Main.plugin.getConfig().set("TorchLocations", TorchLocations);
            Main.plugin.saveConfig();
            Print.Player(e.getPlayer(), "" + e.getBlock().getLocation());
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
                @Override
                public void run() {
                    if (e.getBlock().getType() == Material.TORCH || e.getBlock().getType() == Material.WALL_TORCH) {
                        for (String TLCLocation: Main.plugin.getConfig().getStringList("TorchLocations")) {
                            if (TLCLocation.contains(e.getBlock().getLocation().toString())) {


                                java.util.List < String > TorchLocations = Main.plugin.getConfig().getStringList("TorchLocations");
                                String LocToFind = TLCLocation;
                                boolean LocExists = TorchLocations.stream().anyMatch(user -> LocToFind.equals(e.getBlock().getLocation().toString()));

                                if (LocExists == true) {
                                    TorchLocations.remove(TLCLocation);
                                    Print.Player(e.getPlayer(), TLCLocation);
                                    Main.plugin.getConfig().set("TorchLocations", TorchLocations);
                                    Main.plugin.saveConfig();
                                    Bukkit.broadcastMessage("This message is shown after one second");
                                    e.getBlock().setType(Material.AIR);
                                    e.getPlayer().getWorld().dropItemNaturally(e.getBlock().getLocation(), new ItemStack(Material.STICK));
                                } else {
                                }
                            } else {}
                        }
                    } else {
                    }
                }
            }, 10 * 20L);
        }
    }
}

//Bukkit.broadcastMessage("This message is shown after one second");
//e.getBlock().setType(Material.REDSTONE_TORCH);
//Lightable data = (Lightable) e.getBlock().getBlockData();
//data.setLit(false);
//e.getBlock().setBlockData(data);
//e.getPlayer().getWorld().dropItemNaturally(e.getBlock().getLocation(), new ItemStack(Material.STICK));