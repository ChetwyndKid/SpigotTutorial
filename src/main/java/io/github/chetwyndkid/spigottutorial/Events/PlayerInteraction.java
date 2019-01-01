package io.github.chetwyndkid.spigottutorial.Events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteraction implements Listener {
  @EventHandler
  public void onInteract(PlayerInteractEvent event) {
    Action actionDetect = event.getAction(); //Detect what player is doing
    Player playerDetect = event.getPlayer(); //Detect the player itself
    Block blockDetect = event.getClickedBlock(); //Detect the block that is clicked

    if(actionDetect.equals(Action.LEFT_CLICK_BLOCK)){ //If its a left click
      if (blockDetect.getType().equals(Material.EMERALD_BLOCK)) { //If its a emerald
        if (playerDetect.getHealth() != 20){ //Detects player health  ! inverts to if is not = too.
          playerDetect.sendMessage(ChatColor.GREEN + "You have been healed for:" + ChatColor.RED + "+1 health"); //Tell the player its a healing block
          playerDetect.setHealth(playerDetect.getHealth() + 1); //Checks player health and sets health to +1 from that.
        }
        else {
          playerDetect.sendMessage(ChatColor.DARK_RED + "You already have full health?|");
        }
      }
      else { //Obvious shit
        playerDetect.sendMessage(ChatColor.RED + "You punched " + blockDetect.getType().toString()); //Tells the player what they are punching if its not a emerald block.
      }
    }
  }
}
