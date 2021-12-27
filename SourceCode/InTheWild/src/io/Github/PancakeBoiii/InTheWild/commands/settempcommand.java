package io.Github.PancakeBoiii.InTheWild.commands;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import io.github.pancakeboiii.core.Main;
import io.github.pancakeboiii.core.OrdinalAPI.DataManager.FileMan;
import io.github.pancakeboiii.core.OrdinalAPI.Minecraft.Print;

public class settempcommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("InTheWild.setTemp")) {
                if (args.length == 0) {
                    Print.Player(player, ChatColor.RED + "Usage : /SetTemp <Player> <Amount -100 - 100>");
                } else {
                    //Player typed something more
                    Player target = Bukkit.getPlayerExact(args[0]);
                    if (args[0] != null && args[1] == null) {
                        Print.Player(player, ChatColor.RED + "Usage : /SetTemp <Player> <Amount -100 - 100>");
                    }
                    if (target == null) {
                        //Target is not online
                        player.sendMessage("Your target " + args[0] + " is not online!");
                    } else {
                        if (args.length == 1) {
                            if (args[0] != null && args[1] == null) {
                                Print.Player(player, ChatColor.RED + "Usage : /SetTemp <Player> <Amount -100 - 100>");
                            }
                        } else {
                            //Targets online
                            if (args[0] != null && args[1] != null) {
                                if (args[1] == null) {
                                    args[1] = "0";
                                }
                                File PreUserData = new File("plugins/InTheWild/UserData/" + target.getUniqueId().toString() + "/Temperature.yml");
                                FileConfiguration UserData = YamlConfiguration.loadConfiguration(PreUserData);
                                FileMan.WriteToFile(PreUserData.toString(), "Temperature: " + Integer.valueOf(args[1]));
                            }
                        }

                    }
                }
            } else {
                Print.Player(player, ChatColor.RED + "You do not have permission to run this command!");
            }
        }
        if (sender instanceof ConsoleCommandSender){
                if (args.length == 0) {
                    Print.Console(ChatColor.RED + "Usage : /SetTemp <Player> <Amount -100 - 100>");
                } else {
                    //Player typed something more
                    Player target = Bukkit.getPlayerExact(args[0]);
                    if (args[0] != null && args[1] == null) {
                        Print.Console(ChatColor.RED + "Usage : /SetTemp <Player> <Amount -100 - 100>");
                    }
                    if (target == null) {
                        //Target is not online
                        Print.Console("Your target " + args[0] + " is not online!");
                    } else {
                        if (args.length == 1) {
                            if (args[0] != null && args[1] == null) {
                                Print.Console(ChatColor.RED + "Usage : /SetTemp <Player> <Amount -100 - 100>");
                            }
                        } else {
                            //Targets online
                            if (args[0] != null && args[1] != null) {
                                if (args[1] == null) {
                                    args[1] = "0";
                                }
                                File PreUserData = new File("plugins/InTheWild/UserData/" + target.getUniqueId().toString() + "/Temperature.yml");
                                FileConfiguration UserData = YamlConfiguration.loadConfiguration(PreUserData);
                                FileMan.WriteToFile(PreUserData.toString(), "Temperature: " + Integer.valueOf(args[1]));
                            }
                        }

                    }
                }
        }
        return false;
    }
}