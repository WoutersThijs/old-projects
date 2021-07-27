package be.thijswouters.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetEvent;

public class EventEntityTarget implements Listener{
	
	@EventHandler
	public void onEntityTarget(EntityTargetEvent e){
		e.setCancelled(true);
	}
}
