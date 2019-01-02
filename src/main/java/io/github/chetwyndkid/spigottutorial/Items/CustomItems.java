package io.github.chetwyndkid.spigottutorial.Items;

import io.github.chetwyndkid.spigottutorial.SpigotTutorial;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

public class CustomItems implements Listener {
  private Plugin plugin = SpigotTutorial.getPlugin(SpigotTutorial.class);

  public void customAxe(){
    ItemStack item = new ItemStack(Material.DIAMOND_AXE);
    ItemMeta meta = item.getItemMeta();

    meta.setDisplayName(ChatColor.AQUA + "Its a fucking axe."); //Sets item name
    ArrayList<String> lore = new ArrayList<String>();
    lore.add(ChatColor.WHITE + "I dont know what you expected this to be."); //Set what you would like the lore meta to be
    meta.setLore(lore); //Actually set the lore
    meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
    item.setItemMeta(meta); //Actually set the name.

    ShapedRecipe customAxe = new ShapedRecipe(item);
    customAxe.shape("DI ","DI "," S ");
    customAxe.setIngredient('D', Material.DIAMOND);
    customAxe.setIngredient('I', Material.IRON_INGOT);
    customAxe.setIngredient('S', Material.STICK);

    plugin.getServer().addRecipe(customAxe);
  }
}
