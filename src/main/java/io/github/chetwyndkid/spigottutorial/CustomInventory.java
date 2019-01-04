package io.github.chetwyndkid.spigottutorial;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

public class CustomInventory implements Listener {

  private Plugin plugin = SpigotTutorial.getPlugin(SpigotTutorial.class);
  public void newInventory(Player player){
    Inventory i = plugin.getServer().createInventory(null, 9, ChatColor.DARK_GREEN + "Tutorial Inventory");

    int pHealth = (int) player.getHealth();
    int pFood = (int) player.getFoodLevel();

    ItemStack empty = new ItemStack(Material.BARRIER);  //creates Itemstack of Barrier
    ItemMeta emptyMeta = empty.getItemMeta(); //Gets the ItemMeta
    emptyMeta.setDisplayName(" ");
    empty.setItemMeta(emptyMeta);

    ItemStack health = new ItemStack(Material.ENCHANTED_GOLDEN_APPLE, pHealth);
    ItemMeta healthMeta = health.getItemMeta();
    healthMeta.setDisplayName(ChatColor.RED + "HEALTH");
    health.setItemMeta(healthMeta);

    ItemStack food = new ItemStack(Material.COOKED_PORKCHOP, pFood);
    ItemMeta foodMeta = food.getItemMeta();
    foodMeta.setDisplayName(ChatColor.DARK_PURPLE + "FOOD");
    food.setItemMeta(foodMeta);

    i.setItem(0, empty);
    i.setItem(1, empty);
    i.setItem(2, empty);
    i.setItem(3, health);
    i.setItem(4, empty);
    i.setItem(5, food);
    i.setItem(6, empty);
    i.setItem(7, empty);
    i.setItem(8, empty);


    player.openInventory(i);
  }
}
