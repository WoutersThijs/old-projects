package be.thijswouters.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFormEvent;

public class EventSnowman implements Listener{
	
	@EventHandler
	public void onSnowman(BlockFormEvent e){
		e.setCancelled(true);
	}
}
