package io.github.pancakeboiii.core.OrdinalAPI.DataManager;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import io.github.pancakeboiii.core.Main;

public class DataManager {
    private Main plugin;
    public FileConfiguration dataConfig = null;
    public File configFile = null;
    public DataManager(Main plugin) {
        this.plugin = plugin;
        saveDefaultConfig();
    }
    public void reloadConfig() {
        if (this.configFile == null)
            this.configFile = new File(this.plugin.getDataFolder(), "Ordinal.yml");
        this.dataConfig = YamlConfiguration.loadConfiguration(this.configFile);

        InputStream defaultStream = this.plugin.getResource("Ordinal.yml");

        if (defaultStream != null) {
            YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(defaultStream));
            this.dataConfig.setDefaults(defaultConfig);
        }
    }

    public FileConfiguration getConfig() {
        if (this.dataConfig == null) {
            reloadConfig();
        }
        return this.dataConfig;
    }
    
    public void saveConfig() {
        if (this.dataConfig == null || this.configFile == null) {
            return;
        }
    	try {
			this.getConfig().save(this.configFile);
		} catch (IOException e) {
			plugin.getLogger().log(Level.SEVERE, "Could not save config to " + this.configFile, e);
		}
    }
    public void saveDefaultConfig() {
        if (this.dataConfig == null) {
        	this.configFile = new File(this.plugin.getDataFolder(), "Ordinal.yml");
        }
        if (!this.configFile.exists()) {
        	this.plugin.saveResource("Ordinal.yml", false);
        }
    }
}