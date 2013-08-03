package com.github.blockedup.buenchant;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class buListener implements Listener {
	
	Boolean books = Bukkit.getPluginManager().getPlugin("buenchant").getConfig().getBoolean("Enable Books");
	
	@EventHandler
    public void onMove(PlayerMoveEvent event){
    	if(!event.getPlayer().isOp() || !event.getPlayer().hasPermission("bue.admin") || books == false){
    		if(event.getPlayer().getInventory().contains(Material.ENCHANTED_BOOK)){
    			event.getPlayer().getInventory().remove(Material.ENCHANTED_BOOK);
    			event.getPlayer().sendMessage(ChatColor.RED + "Removed Enchanted Book! These are no longer allowed. Do NOT ask for an xp refund.");
            	}
        }else{}
            }
	
    @EventHandler
    public void onMove(PlayerPickupItemEvent event){
    	if(!event.getPlayer().isOp() || !event.getPlayer().hasPermission("bue.admin") || books == false){
    		if(event.getPlayer().getInventory().contains(Material.ENCHANTED_BOOK)){
    			event.getPlayer().getInventory().remove(Material.ENCHANTED_BOOK);
    			event.getPlayer().sendMessage(ChatColor.RED + "Removed Enchanted Book! These are no longer allowed. Do NOT ask for an xp refund.");
            	}
        }else {}
            }
    
    @EventHandler
    public void onInteract(InventoryClickEvent event){
    	if(!event.getWhoClicked().isOp() || !event.getWhoClicked().hasPermission("bue.admin") || books == false){
    		if(event.getWhoClicked().getInventory().contains(Material.ENCHANTED_BOOK)){
    			event.getWhoClicked().getInventory().remove(Material.ENCHANTED_BOOK);
    			((CommandSender) event.getWhoClicked()).sendMessage(ChatColor.RED + "Removed Enchanted Book! These are no longer allowed. Do NOT ask for an xp refund.");
            	}
        }else {}       
            }
}
