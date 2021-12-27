package io.github.pancakeboiii.core;


import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.pancakeboiii.core.OrdinalAPI.Minecraft.PluginMessage;
import io.github.pancakeboiii.core.OrdinalAPI.Minecraft.Print;
import io.github.pancakeboiii.core.OrdinalAPI.PluginChecker.CheckPlugin;
import io.github.pancakeboiii.core.OrdinalAPI.UpdateChecker.UpdateManager;
import io.github.pancakeboiii.core.commands.InfoCommand;

/*import io.github.pancakeboiii.core.commands.DevCommand;
import io.github.pancakeboiii.core.commands.DevCommand2;
import io.github.pancakeboiii.core.commands.DevCommand3;
import io.github.pancakeboiii.core.commands.DevCommand4;
import io.github.pancakeboiii.core.commands.DevCommand5;*/
public class Main extends JavaPlugin {
    public static Main plugin;
    // This code sucks, you know it and I know it.
    // If you are reading this, that means you are either snooping or have decided to take over and maintain this project.
    // let the number below act as a warning for the next person, and add hours to it accordingly.
    int Total_Hours_Wasted_On_This_God_Forsaken_Project = 25;
    public io.github.pancakeboiii.core.OrdinalAPI.DataManager.DataManager DM;
    public void onEnable() {
        plugin = this;
        plugin.DM = new io.github.pancakeboiii.core.OrdinalAPI.DataManager.DataManager(this);
        if (plugin.DM.dataConfig == null) {
            plugin.DM.configFile = new File(Main.plugin.getDataFolder(), "Ordinal.yml");
        }
        PluginMessage.StartupMessage(this);
        UpdateManager.checkupdate(this, 94821, "https://www.spigotmc.org/resources/pancakecore.94821/");
        Print.Console("Checking for Pancake plugins...");
        CheckPlugin.IsInstalled("CelestialEngine");
        CheckPlugin.IsInstalled("InTheWild");
        getCommand("PancakeCore").setExecutor((CommandExecutor) new InfoCommand());

        /*
         * getCommand("DevCommand").setExecutor((CommandExecutor) new DevCommand());
         * getCommand("DevCommand2").setExecutor((CommandExecutor) new DevCommand2());
         * getCommand("DevCommand3").setExecutor((CommandExecutor) new DevCommand3());
         * getCommand("DevCommand4").setExecutor((CommandExecutor) new DevCommand4());
         * getCommand("DevCommand5").setExecutor((CommandExecutor) new DevCommand5());
         */

        PluginMessage.LoadedMessage(this);
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            public void run() {
                for (@SuppressWarnings("unused") Player p: Bukkit.getOnlinePlayers()) {}
            }
        }, 20L, 20L);
    }

    public void onDisable() {
        PluginMessage.DisableMessage(this);
    }
}