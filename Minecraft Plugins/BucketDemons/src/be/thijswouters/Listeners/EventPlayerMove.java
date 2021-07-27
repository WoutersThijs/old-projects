package be.thijswouters.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import be.thijswouters.Kits.DemonsSkeleton;

public class EventPlayerMove implements Listener{
	
	@EventHandler
	public void onMove(PlayerMoveEvent e){
		Player p  = e.getPlayer();
	}
}
