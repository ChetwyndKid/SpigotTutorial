package io.github.chetwyndkid.spigottutorial.Items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class CustomItems implements Listener {
  public void giveItems(Player player){
    ItemStack item = new ItemStack(Material.DIAMOND_AXE);
    ItemMeta meta = item.getItemMeta();

    meta.setDisplayName(ChatColor.AQUA + "Its a fucking axe.");
    ArrayList<String> lore = new ArrayList<String>();
    lore.add(ChatColor.WHITE + "I dont know what you expected this to be.");
    meta.setLore(lore);
    item.setItemMeta(meta);

    player.getInventory().addItem(item);
  }
}
