package be.thijswouters.Listeners;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class EventDoubleJumpMove implements Listener{
	
	@EventHandler
	public void onDoubleMove(PlayerMoveEvent e){
		Player p = e.getPlayer();
		if(p.getGameMode() == GameMode.CREATIVE) return;
		if(p.getLocation().subtract(0, 1, 0).getBlock().getType() != Material.AIR
		   && !p.isFlying()){
			p.setAllowFlight(true);
		}
	}
}
