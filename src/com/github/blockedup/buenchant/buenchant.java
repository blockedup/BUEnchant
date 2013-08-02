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
    public void onPlayerEnchant(PrepareItemEnchantEvent event){     

    if(event.getEnchanter().hasPermission("bue.admin") || event.getEnchanter().hasPermission("bue.enchant") || event.getEnchanter().isOp()) {
        event.setCancelled(false);
            }
    }
    
    @EventHandler
    public void onMove(PlayerMoveEvent event){  
            Boolean books = getConfig().getBoolean("Enable Books");
            if(!event.getPlayer().isOp() || !event.getPlayer().hasPermission("bue.admin") || books == false){
        if(event.getPlayer().getInventory().contains(Material.ENCHANTED_BOOK)){
            event.getPlayer().getInventory().remove(Material.ENCHANTED_BOOK);
            event.getPlayer().sendMessage(ChatColor.RED + "Removed Enchanted Book!");
            }
        }else {}
            }
    @EventHandler
    public void onMove(PlayerPickupItemEvent event){  
            Boolean books = getConfig().getBoolean("Enable Books");
            if(!event.getPlayer().isOp() || !event.getPlayer().hasPermission("bue.admin") || books == false){
        if(event.getPlayer().getInventory().contains(Material.ENCHANTED_BOOK)){
            event.getPlayer().getInventory().remove(Material.ENCHANTED_BOOK);
            event.getPlayer().sendMessage(ChatColor.RED + "Removed Enchanted Book!");
            }
        }else {}
            }
    @EventHandler
    public void onInteract(InventoryClickEvent event){  
            Boolean books = getConfig().getBoolean("Enable Books");
            if(!event.getWhoClicked().isOp() || !event.getWhoClicked().hasPermission("bue.admin") || books == false){
        if(event.getWhoClicked().getInventory().contains(Material.ENCHANTED_BOOK)){
            event.getWhoClicked().getInventory().remove(Material.ENCHANTED_BOOK);
            ((CommandSender) event.getWhoClicked()).sendMessage(ChatColor.RED + "Removed Enchanted Book!");
            }
        }else {}       
            }
     
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        Player player = (Player)sender;
         
    if(cmd.getName().equalsIgnoreCase("bue_reload")){
        if(player.hasPermission("bue.admin") || player.isOp()){
          Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("bue.enchant");
          plugin.reloadConfig();
          player.sendMessage("buenchant successfully reloaded!");
            }
        }else{
        if(cmd.getName().equalsIgnoreCase("bue_unenchant")){
        if(player.hasPermission("bue.admin") || player.isOp() || player.hasPermission("bue.unenchant")){
        ItemStack item = player.getItemInHand();
        Material itemtype = player.getItemInHand().getType();
        int durability = item.getDurability();
        Inventory inventory = player.getInventory();
        item.removeEnchantment(Enchantment.ARROW_DAMAGE);
        item.removeEnchantment(Enchantment.ARROW_FIRE);
        item.removeEnchantment(Enchantment.ARROW_INFINITE);
        item.removeEnchantment(Enchantment.ARROW_KNOCKBACK);
        item.removeEnchantment(Enchantment.DAMAGE_ALL);
        item.removeEnchantment(Enchantment.DAMAGE_ARTHROPODS);
        item.removeEnchantment(Enchantment.DAMAGE_UNDEAD);
        item.removeEnchantment(Enchantment.DIG_SPEED);
        item.removeEnchantment(Enchantment.DURABILITY);
        item.removeEnchantment(Enchantment.FIRE_ASPECT);
        item.removeEnchantment(Enchantment.KNOCKBACK);
        item.removeEnchantment(Enchantment.LOOT_BONUS_BLOCKS);
        item.removeEnchantment(Enchantment.LOOT_BONUS_MOBS);
        item.removeEnchantment(Enchantment.OXYGEN);
        item.removeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL);
        item.removeEnchantment(Enchantment.PROTECTION_EXPLOSIONS);
        item.removeEnchantment(Enchantment.PROTECTION_FALL);
        item.removeEnchantment(Enchantment.PROTECTION_FIRE);
        item.removeEnchantment(Enchantment.PROTECTION_PROJECTILE);
        item.removeEnchantment(Enchantment.SILK_TOUCH);
        item.removeEnchantment(Enchantment.THORNS);
        item.removeEnchantment(Enchantment.WATER_WORKER);
        player.sendMessage(ChatColor.GREEN + "Successfully unenchanted " + player.getItemInHand().getType());
                    }else{
        player.sendMessage(ChatColor.RED + "Unsuccessfully unenchanted " + player.getItemInHand().getType() + " because it's number of usage is higher than 0 (" + player.getItemInHand().getDurability() + ").");
                    }
                }
            }
    return true;
    }
}
         
    
