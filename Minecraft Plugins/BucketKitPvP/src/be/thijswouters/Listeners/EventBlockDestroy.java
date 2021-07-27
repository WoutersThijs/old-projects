package be.thijswouters.Listeners;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class EventBlockDestroy implements Listener{
	
	@EventHandler
	public void onDestroy(BlockBreakEvent e){
		Player p = e.getPlayer();
		if(p.getGameMode() != GameMode.CREATIVE)
			e.setCancelled(true);
	}
}
