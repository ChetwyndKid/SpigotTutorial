package io.github.chetwyndkid.spigottutorial;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Commands implements Listener, CommandExecutor {
  public String gcmd = "giveitem";
  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if(sender instanceof Player){
      if(cmd.getName().equalsIgnoreCase(gcmd));{ //Checks if the command is the command we are looking for
        if (args.length != 0) {
          Material item = Material.getMaterial(args[0]); //Checks if the argument after the command is actually an item
          if (item != null) { //If the result is not null, Proceed to add item.
            Inventory inv = ((Player) sender).getInventory(); //Detects player inventory
            inv.addItem(new ItemStack(item, 1)); //Puts item in inventory and declares how many.
            return true;
          } else {
            sender.sendMessage(ChatColor.RED + args[0] + ChatColor.GOLD + "This is not a valid item"); //Otherwise tell the user its not a vaild item.
          }
        }
        else {
          sender.sendMessage(ChatColor.RED + "Please specify item");
        }
      }
    }
      else{
        sender.sendMessage(ChatColor.RED + "This is a player only command"); //Tells console that it needs to be ran via a player.
        return true;
      }
    return false;
  }
}
