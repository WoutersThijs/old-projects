package be.thijswouters.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import be.thijswouters.Inventories.InvSelectorMain;
import be.thijswouters.Utils.Chat;

public class EventPlayerInteract implements Listener{
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		Player p = e.getPlayer();
		
	    if(e.getAction().equals(Action.PHYSICAL))
	    	return;
	    
	    if(p.getItemInHand().equals(EventPlayerJoin.vote()))
	    	p.chat("/vote");
	    
	    if(p.getItemInHand().equals(EventPlayerJoin.store()))
	    	Chat.viaOther(p, "Store", "http://store.bucket-craft.net/");
	    
	    if(p.getItemInHand().equals(EventPlayerJoin.selector()))
	    	InvSelectorMain.open(p);
	}
}
