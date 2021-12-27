package io.Github.PancakeBoiii.InTheWild.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.data.Lightable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import io.Github.PancakeBoiii.InTheWild.Main;

public class SoulCampfireListener implements Listener {

    @SuppressWarnings("unused")
	@EventHandler
    public void onPlace(BlockPlaceEvent e) {
        if (e.getBlock().getType() == Material.SOUL_CAMPFIRE) {


            Location location = e.getBlock().getLocation();
            Main.plugin.getConfig().set("CampfireLocations." + location.getBlockX() + location.getBlockY() + location.getBlockZ(), location.getBlockX() + "/" + location.getBlockY() + "/" + location.getBlockZ() + "/" + location.getWorld().getName());
            Main.plugin.saveConfig();

            String[] CampLocParts = Main.plugin.getConfig().getString("CampfireLocations." + location.getBlockX() + location.getBlockY() + location.getBlockZ()).split("/");
            Location CampLoc = new Location(Bukkit.getServer().getWorld(CampLocParts[3]), Integer.parseInt(CampLocParts[0]),
                Integer.parseInt(CampLocParts[1]), Integer.parseInt(CampLocParts[2]));
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
                @Override
                public void run() {
                	if (Main.plugin.getConfig().getString("CampfireLocations." + location.getBlockX() + location.getBlockY() + location.getBlockZ()) != null) {
                        if (e.getBlock().getType() == Material.SOUL_CAMPFIRE) {
                        	
                        	Main.plugin.getConfig().set("CampfireLocations." + location.getBlockX() + location.getBlockY() + location.getBlockZ(), null);
                            Main.plugin.saveConfig();
                            Lightable data = (Lightable) e.getBlock().getBlockData();
                            data.setLit(false);
                            e.getBlock().setBlockData(data);
                        }
                	}
                }
            }, Main.plugin.getConfig().getInt("Soul-Campfire-Burnout-Time") * 20L);
        }
    }
    @SuppressWarnings("unused")
	@EventHandler
    public void onBreak(BlockBreakEvent e) {
        if (e.getBlock().getType() == Material.SOUL_CAMPFIRE) {


            Location location = e.getBlock().getLocation();

            String[] CampLocParts = Main.plugin.getConfig().getString("CampfireLocations." + location.getBlockX() + location.getBlockY() + location.getBlockZ()).split("/");
            Location CampLoc = new Location(Bukkit.getServer().getWorld(CampLocParts[3]), Integer.parseInt(CampLocParts[0]),
                Integer.parseInt(CampLocParts[1]), Integer.parseInt(CampLocParts[2]));
                    	Main.plugin.getConfig().set("CampfireLocations." + location.getBlockX() + location.getBlockY() + location.getBlockZ(), null);
                        Main.plugin.saveConfig();
        }
    }
}