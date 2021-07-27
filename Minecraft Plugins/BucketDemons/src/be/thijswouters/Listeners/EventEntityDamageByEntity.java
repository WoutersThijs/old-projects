package be.thijswouters.Listeners;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import be.thijswouters.Utils.ArrayLists;

public class EventEntityDamageByEntity implements Listener{
	
	@EventHandler
	public void onDamageBy(EntityDamageByEntityEvent e){
		if(e.getDamager() instanceof Arrow){
			Arrow arrow = (Arrow) e.getDamager();
	         if(arrow.getShooter() instanceof Player){  
	        	 Player shooter = (Player) arrow.getShooter();
	        	 if(e.getEntity() instanceof Player){
	        		 Player player = (Player) e.getEntity();
	        		 if(ArrayLists.teamDemons.contains(shooter) && ArrayLists.teamDemons.contains(player)){
	        			 e.setCancelled(true);
	        		 }
	        		 if(ArrayLists.teamOrcs.contains(shooter) && ArrayLists.teamOrcs.contains(player)){
	        			 e.setCancelled(true);
	        		 }
	        	 }
	         }
		}
		
		if(e.getDamager() instanceof Player && e.getEntity() instanceof Player){
			if(ArrayLists.teamDemons.contains(e.getDamager()) && ArrayLists.teamDemons.contains(e.getEntity())){
				e.setCancelled(true);
			}
			if(ArrayLists.teamOrcs.contains(e.getDamager()) && ArrayLists.teamOrcs.contains(e.getEntity())){
				e.setCancelled(true);
			}
		}
	}
}
