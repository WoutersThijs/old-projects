package be.thijswouters.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.LeavesDecayEvent;

public class EventLeafDecay implements Listener{
	
	@EventHandler
	public void onLeafDecay(LeavesDecayEvent e){
		e.setCancelled(true);
	}
}
