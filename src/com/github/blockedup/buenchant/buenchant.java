package com.github.blockedup.buenchant;
 
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.PrepareItemEnchantEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
 
 
public final class buenchant extends JavaPlugin implements Listener{
     
     
    public void onEnable(){
        getLogger().info("buenchant is now enabled.");
        FileConfiguration config = this.getConfig();
         
        config.addDefault("Enable Books", false);
     
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(this, this);
        config.options().copyDefaults(true);
        saveConfig();
        }
         
  
    public void onDisable() {
        getLogger().info("buenchant is now disabled.");
        getConfig().options().copyDefaults(true);
        saveConfig();
    }
    
    @EventHandler
    public void onMove(PlayerMoveEvent event){  
            Boolean books = getConfig().getBoolean("Enable Books");
            if(!event.getPlayer().isOp() || !event.getPlayer().hasPermission("bue.admin") || books == false){
        if(event.getPlayer().getInventory().contains(Material.ENCHANTED_BOOK)){
            event.getPlayer().getInventory().remove(Material.ENCHANTED_BOOK);
            event.getPlayer().sendMessage(ChatColor.RED + "Removed Enchanted Book! These are no longer allowed. Do NOT ask for an xp refund.");
            }
        }else {}
            }
    @EventHandler
    public void onMove(PlayerPickupItemEvent event){  
            Boolean books = getConfig().getBoolean("Enable Books");
            if(!event.getPlayer().isOp() || !event.getPlayer().hasPermission("bue.admin") || books == false){
        if(event.getPlayer().getInventory().contains(Material.ENCHANTED_BOOK)){
            event.getPlayer().getInventory().remove(Material.ENCHANTED_BOOK);
            event.getPlayer().sendMessage(ChatColor.RED + "Removed Enchanted Book! These are no longer allowed. Do NOT ask for an xp refund.");
            }
        }else {}
            }
    @EventHandler
    public void onInteract(InventoryClickEvent event){  
            Boolean books = getConfig().getBoolean("Enable Books");
            if(!event.getWhoClicked().isOp() || !event.getWhoClicked().hasPermission("bue.admin") || books == false){
        if(event.getWhoClicked().getInventory().contains(Material.ENCHANTED_BOOK)){
            event.getWhoClicked().getInventory().remove(Material.ENCHANTED_BOOK);
            ((CommandSender) event.getWhoClicked()).sendMessage(ChatColor.RED + "Removed Enchanted Book! These are no longer allowed. Do NOT ask for an xp refund.");
            }
        }else {}       
            }
     
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        Player player = (Player)sender;
         
    if(cmd.getName().equalsIgnoreCase("bue_reload")){
        if(player.hasPermission("bue.admin") || player.isOp()){
          Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("buenchant");
          plugin.reloadConfig();
          player.sendMessage("buenchant successfully reloaded!");
            }
        }
    return true;
    }
}
         
    
