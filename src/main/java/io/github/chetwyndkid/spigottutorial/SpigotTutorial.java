package io.github.chetwyndkid.spigottutorial;

import io.github.chetwyndkid.spigottutorial.Events.*;
import io.github.chetwyndkid.spigottutorial.Items.CustomItems;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class SpigotTutorial extends JavaPlugin {

  private Commands commands = new Commands();
  public void onEnable() { // What happens on plugin startup
    getCommand(commands.gcmd).setExecutor(commands);
    getCommand(commands.inv).setExecutor(commands);
    getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "\n\nSpigot Tutorial plugin has been enabled.\n\n"); // Sends message to console on plugin enable
   // getServer().getPluginManager().registerEvents(new PlayerMovement(), this); // Loads Player Movement part of the plugin
    getServer().getPluginManager().registerEvents(new PlayerInteraction(), this); // Loads Player Interaction part of the plugin
   // getServer().getPluginManager().registerEvents(new BlockPlaceBreak(), this); // Loads Player BlockPlaceBreak part of the plugin
    getServer().getPluginManager().registerEvents(new StartingStuff(), this); //Loads EventsClass part of the plugin
    getServer().getPluginManager().registerEvents(new CraftingRewards(), this); //Loads Crafting Rewards
    getServer().getPluginManager().registerEvents(new InventoryInteraction(), this); //Loads InventoryInteraction Rewards
    loadConfig();

    CustomItems items = new CustomItems();
    items.customAxe();
    items.scAxe();
  }

  public void onDisable() { // What happens on plugin shutdown
    getServer().getConsoleSender().sendMessage(ChatColor.RED + "\n\nSpigot Tutorial plugin has been disabled.\n\n"); // Sends message to console on plugin disable
  }

  public void loadConfig(){
    getConfig().options().copyDefaults(true); //Loads config defaults
    saveConfig();
  }
}
