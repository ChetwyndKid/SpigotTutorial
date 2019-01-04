package io.github.chetwyndkid.spigottutorial.Events;

import io.github.chetwyndkid.spigottutorial.SpigotTutorial;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class InventoryInteraction implements Listener {
  private Plugin plugin = SpigotTutorial.getPlugin(SpigotTutorial.class);
  public String prefix = (ChatColor.BLUE + "TUTORIAL>> ");

  @EventHandler
  public void InvenClick(InventoryClickEvent event){
    Player player = (Player) event.getWhoClicked();

    Inventory open = event.getClickedInventory(); //Gets inventory that was clicked
    ItemStack item = event.getCurrentItem(); //Gets item that was clicked
    if(open == null) { //Prevents errors if you click none of the above two options.
      return;
    }
    if(open.getName().equals(ChatColor.DARK_GREEN + "Tutorial Inventory")){ //If the current open inventory is = to
      event.setCancelled(true); //Dont allow taking items
      if(item.equals(null) || !item.hasItemMeta()){ //If there is no item return
        return;
      }
      if(item.getItemMeta().getDisplayName().equals(ChatColor.RED + "HEALTH")) { //If clicked item is Health
        player.setHealth(20); //Set health to 20 on click
      }
        else if(item.getItemMeta().getDisplayName().equals(ChatColor.DARK_PURPLE + "FOOD")) { //If clicked item if Food
          player.setFoodLevel(20); //Set food to 20
      }
    }
  }
}
