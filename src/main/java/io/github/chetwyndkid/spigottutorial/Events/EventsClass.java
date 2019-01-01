package io.github.chetwyndkid.spigottutorial.Events;

import io.github.chetwyndkid.spigottutorial.Items.CustomItems;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class EventsClass implements Listener {
  private CustomItems ci = new CustomItems();
  @EventHandler
  public void onPunch(PlayerInteractEvent event){
    Player player = event.getPlayer();
    ci.giveItems(player);
  }
}
