package io.Github.PancakeBoiii.InTheWild.Listeners;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import io.Github.PancakeBoiii.InTheWild.Main;
import io.github.pancakeboiii.core.OrdinalAPI.Minecraft.ActionBar;
import io.github.pancakeboiii.core.OrdinalAPI.Minecraft.MCP;

public class TemperatureCheck {
    public static String GetTemp(Player p) {
        	String TemperatureIcon = null;
    		File f = new File("plugins/InTheWild/UserData/" + p.getUniqueId().toString() + "/Temperature.yml");
    		FileConfiguration UserData = YamlConfiguration.loadConfiguration(f);
    		if (UserData.getInt("Temperature") >= 91) {TemperatureIcon = "";} 
    		if (UserData.getInt("Temperature") <= 90) {TemperatureIcon = "";} 
    		if (UserData.getInt("Temperature") <= 75) {TemperatureIcon = "";} 
    		if (UserData.getInt("Temperature") <= 60) {TemperatureIcon = "";} 
    		if (UserData.getInt("Temperature") <= 45) {TemperatureIcon = "";} 
    		if (UserData.getInt("Temperature") <= 30) {TemperatureIcon = "";} 
    		if (UserData.getInt("Temperature") <= 15) {TemperatureIcon = "";}  
    		if (UserData.getInt("Temperature") == 0) {TemperatureIcon = "";}  
    		if (UserData.getInt("Temperature") <= -15) {TemperatureIcon = "";}  
    		if (UserData.getInt("Temperature") <= -30) {TemperatureIcon = "";}  
    		if (UserData.getInt("Temperature") <= -45) {TemperatureIcon = "";}   	
    		if (UserData.getInt("Temperature") <= -60) {TemperatureIcon = "";}   	
    		if (UserData.getInt("Temperature") <= -75) {TemperatureIcon = "";}
    		if (UserData.getInt("Temperature") <= -90) {TemperatureIcon = "";}
    		if (UserData.getInt("Temperature") <= -91) {TemperatureIcon = "";}
    		return TemperatureIcon;
        }
    }