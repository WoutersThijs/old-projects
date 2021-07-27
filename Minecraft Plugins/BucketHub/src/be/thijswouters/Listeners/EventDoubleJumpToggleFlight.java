package be.thijswouters.Listeners;

import net.minecraft.server.v1_8_R2.Material;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleFlightEvent;

public class EventDoubleJumpToggleFlight implements Listener{
	
	@EventHandler
	public void onDoubleToggleFlight(PlayerToggleFlightEvent e){
		Player p = e.getPlayer();
		if(p.getGameMode() == GameMode.CREATIVE) return;
		if(p.getLocation().subtract(0, 1, 0).getBlock() == Material.AIR) return;
		e.setCancelled(true);
		p.setAllowFlight(false);
		p.setFlying(false);
		p.setVelocity(p.getLocation().getDirection().multiply(1.5).setY(1));
	}
}
