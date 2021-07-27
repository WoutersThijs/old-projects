package be.thijswouters.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import be.thijswouters.SQL.Buckets;

import com.earth2me.essentials.api.Economy;
import com.earth2me.essentials.api.NoLoanPermittedException;
import com.earth2me.essentials.api.UserDoesNotExistException;

public class EventPlayerDeath implements Listener{
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onDeath(PlayerDeathEvent e) throws NoLoanPermittedException, UserDoesNotExistException{
		if(e.getEntity().getKiller().hasPermission("kitpvp.bucket")){
			Economy.add(e.getEntity().getKiller().getName(), 40);
			e.getEntity().getKiller().sendMessage("§6+40 §eMoney");
			Buckets.addBuckets(e.getEntity().getKiller().getName(), 1);
			e.getEntity().getKiller().sendMessage("§6+1 §eMoney");
			
		} else if(e.getEntity().getKiller().hasPermission("kitpvp.milk")){
			Economy.add(e.getEntity().getKiller().getName(), 50);
			e.getEntity().getKiller().sendMessage("§6+50 §eMoney");
			Buckets.addBuckets(e.getEntity().getKiller().getName(), 1);
			e.getEntity().getKiller().sendMessage("§6+1 §eMoney");
			
		} else if(e.getEntity().getKiller().hasPermission("kitpvp.water")){
			Economy.add(e.getEntity().getKiller().getName(), 60);
			e.getEntity().getKiller().sendMessage("§6+60 §eMoney");
			Buckets.addBuckets(e.getEntity().getKiller().getName(), 1);
			e.getEntity().getKiller().sendMessage("§6+1 §eMoney");
			
		} else if(e.getEntity().getKiller().hasPermission("kitpvp.lava")){
			Economy.add(e.getEntity().getKiller().getName(), 70);
			e.getEntity().getKiller().sendMessage("§6+70 §eMoney");
			Buckets.addBuckets(e.getEntity().getKiller().getName(), 1);
			e.getEntity().getKiller().sendMessage("§6+1 §eMoney");
			
		} else if(e.getEntity().getKiller().hasPermission("kitpvp.titan")){
			Economy.add(e.getEntity().getKiller().getName(), 80);
			e.getEntity().getKiller().sendMessage("§6+80 §eMoney");
			Buckets.addBuckets(e.getEntity().getKiller().getName(), 1);
			e.getEntity().getKiller().sendMessage("§6+1 §eMoney");
			
		} else {
			Economy.add(e.getEntity().getKiller().getName(), 30);
			e.getEntity().getKiller().sendMessage("§6+30 §eMoney");
			Buckets.addBuckets(e.getEntity().getKiller().getName(), 1);
			e.getEntity().getKiller().sendMessage("§6+1 §eMoney");
		}
	}
}
