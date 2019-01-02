package io.github.chetwyndkid.spigottutorial.Events;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.ArrayList;

public class StartingStuff implements Listener {


  public String prefix = (ChatColor.BLUE + "TUTORIAL>> "); //Creates the prefix to be used.
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
      Player player = event.getPlayer();

      event.setJoinMessage(""); //Removes the vanilla join message

      player.sendMessage(prefix + ChatColor.GOLD + "Welcome back, " + player.getName());

      ItemStack item = new ItemStack(Material.DIAMOND_AXE);
      ItemMeta meta = item.getItemMeta();
      meta.setDisplayName(ChatColor.AQUA + "Its a fucking starting axe!"); //Sets item name
      ArrayList<String> lore = new ArrayList<String>();
      lore.add(ChatColor.WHITE + "Can be crafted using 2 diamonds, 2 Iron and 2 sticks"); //Set what you would like the lore meta to be
      meta.setLore(lore); //Actually set the lore
      item.setItemMeta(meta); //Actually set the name.

      player.getInventory().setItem(8, item); //Sets item to last slot on tool bar
      Location spawn = new Location(player.getWorld(), 1, 64, 1); //Creates location spawn and sets coords.
      player.teleport(spawn); //Actually teleports
    }
}
