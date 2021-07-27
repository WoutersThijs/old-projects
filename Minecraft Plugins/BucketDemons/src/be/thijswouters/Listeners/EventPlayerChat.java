package be.thijswouters.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import be.thijswouters.Utils.ArrayLists;

public class EventPlayerChat implements Listener{
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e){
		Player p = e.getPlayer();
		if(e.getMessage().startsWith("!")){
			if(ArrayLists.teamDemons.contains(p)){
				e.setFormat("§b» §6Global §8// §c" + p.getName() + " §7> §3" + e.getMessage().replace("!", ""));
			}
			
			if(ArrayLists.teamOrcs.contains(p)){
				e.setFormat("§b» §6Global §8// §a" + p.getName() + " §7> §3" + e.getMessage().replace("!", ""));
			}
			
		}else if(ArrayLists.teamDemons.contains(p)){
			e.setCancelled(true);
			for(Player pd : ArrayLists.teamDemons){
				pd.sendMessage("§b» §6Team §8// §c" + e.getPlayer().getName() + " §7> §3" + e.getMessage());
			}
			
		} else if(ArrayLists.teamOrcs.contains(p)){
			e.setCancelled(true);
			for(Player pd : ArrayLists.teamOrcs){
				pd.sendMessage("§b» §6Team §8// §a" + e.getPlayer().getName() + " §7> §3" + e.getMessage());
			}
			
		} else {
			e.setFormat("§b» §6Spectator §8// §7" + p.getName() + " §7> §3" + e.getMessage());
		}
	}
}
