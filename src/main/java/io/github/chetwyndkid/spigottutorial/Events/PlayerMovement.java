package io.github.chetwyndkid.spigottutorial.Events;

import javafx.scene.paint.Color;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class PlayerMovement implements Listener {
  @EventHandler
  public void onMove (PlayerMoveEvent event){ //Detects Player Movement

    Player player = event.getPlayer();

    Inventory playerInv = player.getInventory(); //Detects inventory
    ItemStack wool = new ItemStack(Material.WHITE_WOOL, 1); // Prepares item for giving?
    Location playerLoc = player.getLocation();


    if (player.isSneaking()) {
      player.sendMessage(ChatColor.GOLD + "Your sneaking at: ");
      player.sendMessage(ChatColor.GOLD + "World: " + ChatColor.AQUA + playerLoc.getWorld());
      player.sendMessage(ChatColor.GOLD + "X: " + ChatColor.AQUA + playerLoc.getBlockX());
      player.sendMessage(ChatColor.GOLD + "Y: " + ChatColor.AQUA + playerLoc.getBlockY());
      player.sendMessage(ChatColor.GOLD + "Z: " + ChatColor.AQUA + playerLoc.getBlockZ());
    }
    else if (player.isOnGround()) {
      player.sendMessage(ChatColor.RED + "Your walking at: "); //Messages player
      player.sendMessage(ChatColor.GOLD + "World: " + ChatColor.AQUA + playerLoc.getWorld());
      player.sendMessage(ChatColor.GOLD + "X: " + ChatColor.AQUA + playerLoc.getBlockX());
      player.sendMessage(ChatColor.GOLD + "Y: " + ChatColor.AQUA + playerLoc.getBlockY());
      player.sendMessage(ChatColor.GOLD + "Z: " + ChatColor.AQUA + playerLoc.getBlockZ());
      playerInv.addItem(wool); //Actually gives the item
    }
    else {
      player.sendMessage(ChatColor.DARK_PURPLE + "Your flying at: ");
      player.sendMessage(ChatColor.GOLD + "World: " + ChatColor.AQUA + playerLoc.getWorld());
      player.sendMessage(ChatColor.GOLD + "X: " + ChatColor.AQUA + playerLoc.getBlockX());
      player.sendMessage(ChatColor.GOLD + "Y: " + ChatColor.AQUA + playerLoc.getBlockY());
      player.sendMessage(ChatColor.GOLD + "Z: " + ChatColor.AQUA + playerLoc.getBlockZ());
    }
  }
}
