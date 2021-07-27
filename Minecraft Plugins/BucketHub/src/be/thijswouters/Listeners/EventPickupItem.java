package be.thijswouters.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class EventPickupItem implements Listener {

	@EventHandler
	public void enPickup(final PlayerPickupItemEvent e) {
		e.setCancelled(true);
	}
}
