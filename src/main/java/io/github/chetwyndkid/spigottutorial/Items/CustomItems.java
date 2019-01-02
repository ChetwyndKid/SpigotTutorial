package io.github.chetwyndkid.spigottutorial.Items;

import io.github.chetwyndkid.spigottutorial.SpigotTutorial;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
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

    ShapedRecipe customAxe = new ShapedRecipe(item); //Start new recipe
    customAxe.shape("DI ","DI "," S "); //Set the pattern for the recipe
    customAxe.setIngredient('D', Material.DIAMOND); //set the Letters for the items.
    customAxe.setIngredient('I', Material.IRON_INGOT);
    customAxe.setIngredient('S', Material.STICK);

    plugin.getServer().addRecipe(customAxe); //Adds the recipe
  }
  public void scAxe () {
    ItemStack item = new ItemStack(Material.DIAMOND_AXE);
    ItemMeta meta = item.getItemMeta();

    meta.setDisplayName(ChatColor.AQUA + "Its a fucking axe."); //Sets item name
    ArrayList<String> lore = new ArrayList<String>();
    lore.add(ChatColor.WHITE + "I dont know what you expected this to be."); //Set what you would like the lore meta to be
    meta.setLore(lore); //Actually set the lore
    meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
    item.setItemMeta(meta); //Actually set the name.

    ShapelessRecipe scAxe = new ShapelessRecipe(item); //Starts Shapeless
    scAxe.addIngredient(2, Material.DIAMOND); //Adds materials and amount
    scAxe.addIngredient(2, Material.IRON_INGOT);
    scAxe.addIngredient(2, Material.STICK);
    plugin.getServer().addRecipe(scAxe); //Adds the recipe
  }
}
