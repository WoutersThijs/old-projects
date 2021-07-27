package be.thijswouters.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import be.thijswouters.Utils.GameState;

public class EventEntityDamage implements Listener{
	
	@EventHandler
	public void onDamage(EntityDamageEvent e){
		if(GameState.isState(GameState.AFTER_GAME) || GameState.isState(GameState.IN_LOBBY)){
			e.setCancelled(true);
		}
	}
}
