package be.thijswouters.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class EventEntityDamage implements Listener{
	
	@EventHandler
	public void onEntityDamage(EntityDamageEvent e){
		e.setCancelled(true);
	}
}
