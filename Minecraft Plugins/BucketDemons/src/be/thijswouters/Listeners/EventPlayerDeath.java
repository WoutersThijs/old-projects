package be.thijswouters.Listeners;

import net.minecraft.server.v1_8_R2.PacketPlayInClientCommand;
import net.minecraft.server.v1_8_R2.PacketPlayInClientCommand.EnumClientCommand;

import org.bukkit.craftbukkit.v1_8_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.PlayerDeathEvent;

import be.thijswouters.SQL.Buckets;
import be.thijswouters.SQL.MySQL;
import be.thijswouters.Utils.ArrayLists;

public class EventPlayerDeath implements Listener{
	
	@EventHandler
    public void RespawnScreen(PlayerDeathEvent e){
		if(!(e.getEntity() instanceof Player))
			return;
		
		Player p = (Player) e.getEntity();
		Player killer = p.getKiller();
        e.getDrops().clear();
        
		if(p.getLastDamageCause().getCause() == DamageCause.PROJECTILE){
	        p.getKiller().sendMessage("§6+3 §eBuckets");
	        Buckets.addBuckets(p.getKiller().getName(), 3);
			if(ArrayLists.teamDemons.contains(p)){
				e.setDeathMessage("§c" + p.getName() + " §ewas shot by §a" + killer.getName() + "§e.");
			}
			
			if(ArrayLists.teamOrcs.contains(p)){
				e.setDeathMessage("§a" + p.getName() + " §ewas shot by §c" + killer.getName() + "§e.");
			}
		}
		
		if(p.getLastDamageCause().getCause() == DamageCause.ENTITY_ATTACK){
	        p.getKiller().sendMessage("§6+3 §eBuckets");
	        Buckets.addBuckets(p.getKiller().getName(), 3);
			if(ArrayLists.teamDemons.contains(p)){
				e.setDeathMessage("§c" + p.getName() + " §ewas killed by §a" + killer.getName() + "§e.");
			}
			
			if(ArrayLists.teamOrcs.contains(p)){
				e.setDeathMessage("§a" + p.getName() + " §ewas killed by §c" + killer.getName() + "§e.");
			}
		}
		
		if(p.getLastDamageCause().getCause() == DamageCause.DROWNING){
			if(ArrayLists.teamDemons.contains(p)){
				e.setDeathMessage("§c" + p.getName() + " §edrowned.");
			}
			
			if(ArrayLists.teamOrcs.contains(p)){
				e.setDeathMessage("§a" + p.getName() + " §edrowned.");
			}
		}
		
		if(p.getLastDamageCause().getCause() == DamageCause.VOID){
			if(ArrayLists.teamDemons.contains(p)){
				e.setDeathMessage("§c" + p.getName() + " §efell out of the world.");
			}
			
			if(ArrayLists.teamOrcs.contains(p)){
				e.setDeathMessage("§a" + p.getName() + " §efell out of the world.");
			}
		}
    }
}
