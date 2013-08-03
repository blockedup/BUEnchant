package com.github.blockedup.buenchant;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;

public class reloadCommand implements CommandExecutor {
	
	Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("buenchant");
	PluginDescriptionFile pdfFile = plugin.getDescription();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        Player player = (Player)sender;
         
    if(cmd.getName().equalsIgnoreCase("bue_reload")){
        if(player.hasPermission("bue.admin") || player.isOp()){
          plugin.reloadConfig();
          player.sendMessage(pdfFile.getName() + " successfully reloaded!");
            }
        }
    return true;
    }

}
