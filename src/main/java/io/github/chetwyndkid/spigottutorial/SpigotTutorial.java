package io.github.chetwyndkid.spigottutorial;

import io.github.chetwyndkid.spigottutorial.Events.BlockPlaceBreak;
import io.github.chetwyndkid.spigottutorial.Events.EventsClass;
import io.github.chetwyndkid.spigottutorial.Events.PlayerInteraction;
import io.github.chetwyndkid.spigottutorial.Events.PlayerMovement;
import io.github.chetwyndkid.spigottutorial.Items.CustomItems;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class SpigotTutorial extends JavaPlugin {

  @Override
  public void onEnable() { // What happens on plugin startup
    getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "\n\nSpigot Tutorial plugin has been enabled.\n\n"); // Sends message to console on plugin enable
   // getServer().getPluginManager().registerEvents(new PlayerMovement(), this); // Loads Player Movement part of the plugin
    getServer().getPluginManager().registerEvents(new PlayerInteraction(), this); // Loads Player Interaction part of the plugin
   // getServer().getPluginManager().registerEvents(new BlockPlaceBreak(), this); // Loads Player BlockPlaceBreak part of the plugin
    getServer().getPluginManager().registerEvents(new EventsClass(), this); //Loads EventsClass part of the plugin
    loadConfig();

    CustomItems items = new CustomItems();
    items.customRecipes();
  }

  @Override
  public void onDisable() { // What happens on plugin shutdown
    getServer().getConsoleSender().sendMessage(ChatColor.RED + "\n\nSpigot Tutorial plugin has been disabled.\n\n"); // Sends message to console on plugin disable
  }

  public void loadConfig(){
    getConfig().options().copyDefaults(true); //Loads config defaults
    saveConfig();
  }
}
