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

        config.addDefault("Diamond Sword", false);
        config.addDefault("Diamond Axe", false);
        config.addDefault("Diamond Shovel", false);
        config.addDefault("Diamond Pickaxe", false);
        config.addDefault("Diamond Helmet", false);
        config.addDefault("Diamond Chestplate", false);
        config.addDefault("Diamond Leggings", false);
        config.addDefault("Diamond Boots", false);
        config.addDefault("Iron Sword", false);
        config.addDefault("Iron Axe", false);
        config.addDefault("Iron Shovel", false);
        config.addDefault("Iron Pickaxe", false);
        config.addDefault("Iron Helmet", false);
        config.addDefault("Iron Chestplate", false);
        config.addDefault("Iron Leggings", false);
        config.addDefault("Iron Boots", false);
        config.addDefault("Gold Sword", false);
        config.addDefault("Gold Axe", false);
        config.addDefault("Gold Shovel", false);
        config.addDefault("Gold Pickaxe", false);
        config.addDefault("Gold Helmet", false);
        config.addDefault("Gold Chestplate", false);
        config.addDefault("Gold Leggings", false);
        config.addDefault("Gold Boots", false);
        config.addDefault("Stone Sword", false);
        config.addDefault("Stone Axe", false);
        config.addDefault("Stone Shovel", false);
        config.addDefault("Stone Pickaxe", false);
        config.addDefault("Chainmail Helmet", false);
        config.addDefault("Chainmail Chestplate", false);
        config.addDefault("Chainmail Leggings", false);
        config.addDefault("Chainmail Boots", false);
        config.addDefault("Wooden Sword", false);
        config.addDefault("Wooden Axe", false);
        config.addDefault("Wooden Shovel", false);
        config.addDefault("Wooden Pickaxe", false);
        config.addDefault("Leather Helmet", false);
        config.addDefault("Leather Chestplate", false);
        config.addDefault("Leather Leggings", false);
        config.addDefault("Leather Boots", false);
         
        config.addDefault("Arrow Damage", true);
        config.addDefault("Knockback", true);
        config.addDefault("Sharpness", true);
         
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

        Boolean diamond_sword = getConfig().getBoolean("Diamond Sword");
        Boolean iron_sword = getConfig().getBoolean("Iron Sword");
        Boolean gold_sword = getConfig().getBoolean("Gold Sword");
        Boolean stone_sword = getConfig().getBoolean("Stone Sword");
        Boolean wooden_sword = getConfig().getBoolean("Wooden Sword");
        Boolean diamond_pickaxe = getConfig().getBoolean("Diamond Pickaxe");
        Boolean iron_pickaxe = getConfig().getBoolean("Iron Pickaxe");
        Boolean gold_pickaxe = getConfig().getBoolean("Gold Pickaxe");
        Boolean stone_pickaxe = getConfig().getBoolean("Stone Pickaxe");
        Boolean wooden_pickaxe = getConfig().getBoolean("Wooden Pickaxe");
        Boolean diamond_axe = getConfig().getBoolean("Diamond Axe");
        Boolean iron_axe = getConfig().getBoolean("Iron Axe");
        Boolean gold_axe = getConfig().getBoolean("Gold Axe");
        Boolean stone_axe = getConfig().getBoolean("Stone Axe");
        Boolean wooden_axe = getConfig().getBoolean("Wooden Axe");
        Boolean diamond_shovel = getConfig().getBoolean("Diamond Shovel");
        Boolean iron_shovel = getConfig().getBoolean("Iron Shovel");
        Boolean gold_shovel = getConfig().getBoolean("Gold Shovel");
        Boolean stone_shovel = getConfig().getBoolean("Stone Shovel");
        Boolean wooden_shovel = getConfig().getBoolean("Wooden Shovel");
        Boolean diamond_helmet = getConfig().getBoolean("Diamond Helmet");
        Boolean iron_helmet = getConfig().getBoolean("Iron Helmet");
        Boolean gold_helmet = getConfig().getBoolean("Gold Helmet");
        Boolean chainmail_helmet = getConfig().getBoolean("Chainmail Helmet");
        Boolean leather_helmet = getConfig().getBoolean("Leather Helmet");
        Boolean diamond_chestplate = getConfig().getBoolean("Diamond Chestplate");
        Boolean iron_chestplate = getConfig().getBoolean("Iron Chestplate");
        Boolean gold_chestplate = getConfig().getBoolean("Gold Chestplate");
        Boolean chainmail_chestplate = getConfig().getBoolean("Chainmail Chestplate");
        Boolean leather_chestplate = getConfig().getBoolean("Leather Chestplate");
        Boolean diamond_leggings = getConfig().getBoolean("Diamond Leggings");
        Boolean iron_leggings = getConfig().getBoolean("Iron Leggings");
        Boolean gold_leggings = getConfig().getBoolean("Gold Leggings");
        Boolean chainmail_leggings = getConfig().getBoolean("Chainmail Leggings");
        Boolean leather_leggings = getConfig().getBoolean("Leather Leggings");
        Boolean diamond_boots = getConfig().getBoolean("Diamond Boots");
        Boolean iron_boots = getConfig().getBoolean("Iron Boots");
        Boolean gold_boots = getConfig().getBoolean("Gold Boots");
        Boolean chainmail_boots = getConfig().getBoolean("Chainmail Boots");
        Boolean leather_boots = getConfig().getBoolean("Leather Boots");
         
        Boolean arrow_damage = getConfig().getBoolean("Arrow Damage");
        Boolean knockback = getConfig().getBoolean("Knockback");
 
      
        if(event.getItem().getType() == Material.DIAMOND_SWORD){
        if(diamond_sword == false){
        event.setCancelled(true);
            }
        } else {
        if(event.getItem().getType() == Material.IRON_SWORD){
        if(iron_sword == false){
        event.setCancelled(true);
            }
        } else {    
        if(event.getItem().getType() == Material.STONE_SWORD){
        if(stone_sword == false){
        event.setCancelled(true);
            }
        } else {
        if(event.getItem().getType() == Material.WOOD_SWORD){
        if(wooden_sword == false){
        event.setCancelled(true);
            }
        } else {
        if(event.getItem().getType() == Material.DIAMOND_AXE){
        if(diamond_axe == false){
        event.setCancelled(true);
            }
        } else {
        if(event.getItem().getType() == Material.IRON_AXE){
        if(iron_axe == false){
        event.setCancelled(true);
            }
        } else {
        if(event.getItem().getType() == Material.STONE_AXE){
        if(stone_axe == false){
        event.setCancelled(true);
            }
        } else {
        if(event.getItem().getType() == Material.WOOD_AXE){
        if(wooden_axe == false){
        event.setCancelled(true);
            }
        } else {
        if(event.getItem().getType() == Material.DIAMOND_SPADE){
        if(diamond_shovel == false){
        event.setCancelled(true);
            }
        } else {
        if(event.getItem().getType() == Material.IRON_SPADE){
        if(iron_shovel == false){
        event.setCancelled(true);
            }
        } else {
        if(event.getItem().getType() == Material.STONE_SPADE){
        if(stone_shovel == false){
        event.setCancelled(true);
            }
        } else {
        if(event.getItem().getType() == Material.WOOD_SPADE){
        if(wooden_shovel == false){
        event.setCancelled(true);
            }
        } else {
        if(event.getItem().getType() == Material.DIAMOND_PICKAXE){
        if(diamond_pickaxe == false){
        event.setCancelled(true);
            }
        } else {
        if(event.getItem().getType() == Material.IRON_PICKAXE){
        if(iron_pickaxe == false){
        event.setCancelled(true);
            }
        } else {
        if(event.getItem().getType() == Material.STONE_PICKAXE){
        if(stone_pickaxe == false){
        event.setCancelled(true);
            }
        } else {
        if(event.getItem().getType() == Material.WOOD_PICKAXE){
        if(wooden_pickaxe == false){
        event.setCancelled(true);
            }
        } else {
        if(event.getItem().getType() == Material.DIAMOND_HELMET){
        if(diamond_helmet == false){
        event.setCancelled(true);
            }
        } else {
        if(event.getItem().getType() == Material.IRON_HELMET){
        if(iron_helmet == false){
        event.setCancelled(true);
            }
        } else {
        if(event.getItem().getType() == Material.CHAINMAIL_HELMET){
        if(chainmail_helmet == false){
        event.setCancelled(true);
            }
        } else {
        if(event.getItem().getType() == Material.LEATHER_HELMET){
        if(leather_helmet == false){
        event.setCancelled(true);
            }
        } else {
        if(event.getItem().getType() == Material.DIAMOND_CHESTPLATE){
        if(diamond_chestplate == false){
        event.setCancelled(true);
            }
        } else {
        if(event.getItem().getType() == Material.IRON_CHESTPLATE){
        if(iron_chestplate == false){
        event.setCancelled(true);
            }
        } else {
        if(event.getItem().getType() == Material.CHAINMAIL_CHESTPLATE){
        if(chainmail_chestplate == false){
        event.setCancelled(true);
            }
        } else {
        if(event.getItem().getType() == Material.LEATHER_CHESTPLATE){
        if(diamond_chestplate == false){
        event.setCancelled(true);
            }
        } else {
        if(event.getItem().getType() == Material.DIAMOND_LEGGINGS){
        if(diamond_leggings == false){
        event.setCancelled(true);
            }
        } else {
        if(event.getItem().getType() == Material.IRON_LEGGINGS){
        if(iron_leggings == false){
        event.setCancelled(true);
            }
        } else {
        if(event.getItem().getType() == Material.CHAINMAIL_LEGGINGS){
        if(chainmail_leggings == false){
        event.setCancelled(true);
            }
        } else {
        if(event.getItem().getType() == Material.LEATHER_LEGGINGS){
        if(leather_leggings == false){
        event.setCancelled(true);
            }
        } else {
        if(event.getItem().getType() == Material.DIAMOND_BOOTS){
        if(diamond_boots == false){
        event.setCancelled(true);
            }
        } else {
        if(event.getItem().getType() == Material.IRON_BOOTS){
        if(iron_boots == false){
        event.setCancelled(true);
            }
        } else {
        if(event.getItem().getType() == Material.CHAINMAIL_BOOTS){
        if(chainmail_boots == false){
        event.setCancelled(true);
            }
        } else {
        if(event.getItem().getType() == Material.LEATHER_BOOTS){
        if(leather_boots == false){
        event.setCancelled(true);
            }
        } else {
        if(event.getItem().getType() == Material.GOLD_SWORD){
        if(gold_sword == false){
        event.setCancelled(true);
            }
        } else {
        if(event.getItem().getType() == Material.GOLD_AXE){
        if(gold_axe == false){
        event.setCancelled(true);
            }
        } else {
        if(event.getItem().getType() == Material.GOLD_PICKAXE){
        if(chainmail_boots == false){
        event.setCancelled(true);
            }
        } else {
        if(event.getItem().getType() == Material.GOLD_SPADE){
        if(chainmail_boots == false){
        event.setCancelled(true);
            }
        } else {
        if(event.getItem().getType() == Material.GOLD_HELMET){
        if(gold_helmet == false){
        event.setCancelled(true);
            }
        } else {
        if(event.getItem().getType() == Material.GOLD_CHESTPLATE){
        if(gold_chestplate == false){
        event.setCancelled(true);
            }   
        } else {
        if(event.getItem().getType() == Material.GOLD_LEGGINGS){
        if(chainmail_boots == false){
        event.setCancelled(true);
        }
        } else {
        if(event.getItem().getType() == Material.GOLD_BOOTS){
        if(gold_boots == false){
        event.setCancelled(true);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
         
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }   
                            }
                        }
                    }
                }
            }
        }
    }   
 
     
     
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
         
    if(cmd.getName().equalsIgnoreCase("ae_reload")){
        if(player.hasPermission("bue.admin") || player.isOp()){
          Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("bue.nchant");
          plugin.reloadConfig();
          player.sendMessage("bue.nchant successfully reloaded!");
            }
        }else{
        if(cmd.getName().equalsIgnoreCase("ae_unenchant")){
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
         
    
