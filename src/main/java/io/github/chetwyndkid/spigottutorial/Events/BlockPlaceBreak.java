package io.github.chetwyndkid.spigottutorial.Events;

import io.github.chetwyndkid.spigottutorial.SpigotTutorial;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.Plugin;

public class BlockPlaceBreak implements Listener {
  private Plugin plugin  = SpigotTutorial.getPlugin(SpigotTutorial.class);
  private int count;

  @EventHandler
  public void onBreak(BlockBreakEvent event) {
    Block block = event.getBlock(); //Gets Block Type
    Player player = event.getPlayer(); //Gets Player
    Location blockLoc = block.getLocation(); //Get Block Location
    player.sendMessage(ChatColor.GOLD + "You broke: " + ChatColor.AQUA + block.getType().toString()); //Print Block Name
    player.sendMessage(ChatColor.GOLD + "World: " + ChatColor.AQUA + blockLoc.getWorld().getName()); //Print World Name
    player.sendMessage(ChatColor.GOLD + "X: " + ChatColor.AQUA + blockLoc.getBlockX()); //Print X
    player.sendMessage(ChatColor.GOLD + "Y: " + ChatColor.AQUA + blockLoc.getBlockY()); //Print Y
    player.sendMessage(ChatColor.GOLD + "Z: " + ChatColor.AQUA + blockLoc.getBlockZ()); //Print Z
  }

  @EventHandler
  public void onPlace(BlockPlaceEvent event) {
    Block block = event.getBlock(); //Gets Block Type
    Player player = event.getPlayer(); //Gets Player
    Location blockLoc = block.getLocation(); //Get Block Location
    player.sendMessage(ChatColor.GOLD + "You placed: " + ChatColor.AQUA + block.getType().toString()); //Print Block Name
    player.sendMessage(ChatColor.GOLD + "World: " + ChatColor.AQUA + blockLoc.getWorld().getName()); //Print World Name
    player.sendMessage(ChatColor.GOLD + "X: " + ChatColor.AQUA + blockLoc.getBlockX()); //Print X
    player.sendMessage(ChatColor.GOLD + "Y: " + ChatColor.AQUA + blockLoc.getBlockY()); //Print Y
    player.sendMessage(ChatColor.GOLD + "Z: " + ChatColor.AQUA + blockLoc.getBlockZ()); //Print Z

    if(block.getType().equals(Material.TNT)) {
      plugin.getServer().broadcastMessage(ChatColor.RED + player.getName().toString() + " Placed TNT"); //Tells everyone on server that TNT has been placed
      plugin.getConfig().set("Users." + player.getUniqueId() + ".Block_" + count + ".World" , blockLoc.getWorld().getName());
      plugin.getConfig().set("Users." + player.getUniqueId() + ".Block_" + count + ".X" , blockLoc.getBlockX());
      plugin.getConfig().set("Users." + player.getUniqueId() + ".Block_" + count + ".Y" , blockLoc.getBlockY());
      plugin.getConfig().set("Users." + player.getUniqueId() + ".Block_" + count + ".Z" , blockLoc.getBlockZ());
      plugin.saveConfig();
      count++;
    }
  }
}
