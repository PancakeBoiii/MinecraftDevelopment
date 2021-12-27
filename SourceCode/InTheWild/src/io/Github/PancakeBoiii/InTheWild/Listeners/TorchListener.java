package io.Github.PancakeBoiii.InTheWild.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

import io.Github.PancakeBoiii.InTheWild.Main;
import io.github.pancakeboiii.core.OrdinalAPI.Minecraft.Print;

public class TorchListener implements Listener {

    @SuppressWarnings("unused")
	@EventHandler
    public void onPlace(BlockPlaceEvent e) {
        if (e.getBlock().getType() == Material.TORCH || e.getBlock().getType() == Material.WALL_TORCH) {


            Location location = e.getBlock().getLocation();
            Main.plugin.getConfig().set("TorchLocations." + location.getBlockX() + location.getBlockY() + location.getBlockZ(), location.getBlockX() + "/" + location.getBlockY() + "/" + location.getBlockZ() + "/" + location.getWorld().getName());
            Main.plugin.saveConfig();

            String[] TorchLocParts = Main.plugin.getConfig().getString("TorchLocations." + location.getBlockX() + location.getBlockY() + location.getBlockZ()).split("/");
            Location TorchLoc = new Location(Bukkit.getServer().getWorld(TorchLocParts[3]), Integer.parseInt(TorchLocParts[0]),
                Integer.parseInt(TorchLocParts[1]), Integer.parseInt(TorchLocParts[2]));
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
                @Override
                public void run() {
                	if (Main.plugin.getConfig().getString("TorchLocations." + location.getBlockX() + location.getBlockY() + location.getBlockZ()) != null) {
                        if (e.getBlock().getType() == Material.TORCH || e.getBlock().getType() == Material.WALL_TORCH) {
                        	
                        	Main.plugin.getConfig().set("TorchLocations." + location.getBlockX() + location.getBlockY() + location.getBlockZ(), null);
                            Main.plugin.saveConfig();
                            e.getBlock().setType(Material.AIR);
                            e.getPlayer().getWorld().dropItemNaturally(e.getBlock().getLocation(), new ItemStack(Material.STICK));
                        }
                	}
                }
            }, Main.plugin.getConfig().getInt("Torch-Burnout-Time") * 20L);
        }
    }
    @SuppressWarnings("unused")
	@EventHandler
    public void onBreak(BlockBreakEvent e) {
        if (e.getBlock().getType() == Material.TORCH || e.getBlock().getType() == Material.WALL_TORCH) {
            Location location = e.getBlock().getLocation();
            if (Main.plugin.getConfig().getString("TorchLocations." + location.getBlockX() + location.getBlockY() + location.getBlockZ()) != null) {
            String[] TorchLocParts = Main.plugin.getConfig().getString("TorchLocations." + location.getBlockX() + location.getBlockY() + location.getBlockZ()).split("/");
            Location TorchLoc = new Location(Bukkit.getServer().getWorld(TorchLocParts[3]), Integer.parseInt(TorchLocParts[0]),
                Integer.parseInt(TorchLocParts[1]), Integer.parseInt(TorchLocParts[2]));
                    	Main.plugin.getConfig().set("TorchLocations." + location.getBlockX() + location.getBlockY() + location.getBlockZ(), null);
                        Main.plugin.saveConfig();
        }
        }
    }
}


//Bukkit.broadcastMessage("This message is shown after one second");
//e.getBlock().setType(Material.REDSTONE_TORCH);
//Lightable data = (Lightable) e.getBlock().getBlockData();
//data.setLit(false);
//e.getBlock().setBlockData(data);
//e.getPlayer().getWorld().dropItemNaturally(e.getBlock().getLocation(), new ItemStack(Material.STICK));