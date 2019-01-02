package io.github.chetwyndkid.spigottutorial.Events;

import io.github.chetwyndkid.spigottutorial.SpigotTutorial;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class CraftingRewards implements Listener {
  public String prefix = (ChatColor.BLUE + "TUTORIAL>> ");
  private Plugin plugin = SpigotTutorial.getPlugin(SpigotTutorial.class);
  @EventHandler
  public void craftingReward(CraftItemEvent event) {
    Player player = (Player) event.getWhoClicked(); //Gets player who clicked the recipe
    ItemStack item = event.getCurrentItem(); //Get the item that's made
    if (item.getType().equals(Material.DIAMOND_SWORD)) { //Checks if it is the said item.
      player.sendMessage(prefix + ChatColor.LIGHT_PURPLE + "You have crafted " + ChatColor.GREEN + item.getType().toString() + ChatColor.LIGHT_PURPLE + " Which has granted you 1-Exp!");
      player.giveExp(1); //Gives xp.
      plugin.getServer().broadcastMessage(prefix + ChatColor.YELLOW + player.getName() + ChatColor.LIGHT_PURPLE + " has crafted" + ChatColor.AQUA + " Axe of Zeus"); //Broadcasts message to server.

      for( Player online : plugin.getServer().getOnlinePlayers()) {
        online.getWorld().playSound(online.getLocation(),Sound.BLOCK_ANVIL_BREAK, 1, 1); //Plays sound.
      }
    }
  }
}
