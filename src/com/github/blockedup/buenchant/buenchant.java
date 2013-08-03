package com.github.blockedup.buenchant;
 
import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
 
public final class buenchant extends JavaPlugin {
	
	File configFile;            
    FileConfiguration config;
    PluginManager pm = getServer().getPluginManager();
    public final buListener bul = new buListener();
    PluginDescriptionFile pdfFile = this.getDescription();
    
    @Override
    public void onEnable(){
        getLogger().info("[" + pdfFile.getName() + "] is now enabled.");
        FileConfiguration config = this.getConfig();
         
        config.addDefault("Enable Books", false);
     
        pm.registerEvents(this.bul, this);
        getCommand("bue_reload").setExecutor(new reloadCommand());
        config.options().copyDefaults(true);
        saveConfig();
        }   
  
    @Override
	public void onDisable() {
        getLogger().info("[" + pdfFile.getName() + "] is now disabled.");
        getConfig().options().copyDefaults(true);
        saveConfig();
    }
}
