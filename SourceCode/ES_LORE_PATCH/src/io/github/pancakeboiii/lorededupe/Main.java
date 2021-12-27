package io.github.pancakeboiii.lorededupe;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

    private static final String NUMBER_LOOP = null;

	@Override
    public void onEnable() {
	    getServer().getConsoleSender().sendMessage(ChatColor.LIGHT_PURPLE + "Loading " + getDescription().getName() + " V" + getDescription().getVersion());
	    getLogger().info(ChatColor.LIGHT_PURPLE + getDescription().getName() + " V" + getDescription().getVersion() + " has Completed Loading!");
        int min = 0;
        int max = 0;
        int order66 = (int)(Math.random() * (max - min + 1)) + min;
        getServer().getPluginManager().registerEvents(this, (Plugin)this);
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask((Plugin)this, new Runnable() {
              public void run() {
                  // Iterate through all item slots in the player's inventory.
            	  outerloop:
            	  for(Player p : Bukkit.getOnlinePlayers()){
                      for (int size = 0; size<p.getInventory().getSize(); size++)
                      {
                          ItemStack item = p.getInventory().getItem(size);
                          if (!(item == null)) {
                          	 if (item.hasItemMeta()) {
                        		 ItemMeta meta = item.getItemMeta();
                                 if (meta.hasLore()) {
                                     int amount = item.getAmount();
                                     
                                     ItemMeta im = item.getItemMeta();
                                     List<String> lorelist = im.getLore();
                                     for (String lore : lorelist)  
                                     {
                                    	 try {
                                         
                                    	 for (int i = 0; i < lorelist.size(); i++) {
                                    		  for (int j = i+1; j < lorelist.size(); j++) {
                                    			  Set<String> set = new LinkedHashSet<>();
                                        			  for (String str : lorelist) {
                                        			      String value = str;
                                        			      for (int i1 = 1; !set.add(value); i1++) {
                                        			    	  int last = lorelist.size() - 1;
                                        			    	  meta.setLore(null);
                                        			    	  item.setItemMeta(meta);
                                        			    	  lorelist.remove(last);
                                        			    	  String laststr = Integer.toString(last);
                                        			          meta.setLore(lorelist);
                                        			    	  item.setItemMeta(meta);
                                        			          meta.setLore(lorelist);
                                        			    	  item.setItemMeta(meta);
                                        			    	  break outerloop;
                                        			      }
                                        			  } 
                                    		  }
                                    		}
                                    	 } catch (Exception e){}
                                    	 if(lore.equalsIgnoreCase("12")){
                                    		p.sendMessage(ChatColor.GREEN + "LORE DETECTED");
                                    		
                                    	}
                                    	 lorelist = im.getLore();
                                    	 if (lorelist == null) { break; };
                                     }
                                 }
                        	 }

                              
                             
                          }
                                             
                      }
            		}
            	  
              }
            },  order66, order66);
      }


}