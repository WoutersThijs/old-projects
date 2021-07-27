package be.thijswouters.Utils;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import be.thijswouters.Hub;

public class Effects {
	
	public static void joinEffect(final Player p){
		new BukkitRunnable(){
			double t = Math.PI/4;
			Location loc = p.getLocation();
			public void run(){
				t = t + 0.1*Math.PI;
				for (double theta = 0; theta <= 2*Math.PI; theta = theta + Math.PI/32){
					double x = t*Math.cos(theta);
					double y = 2*Math.exp(-0.1*t) * Math.sin(t) + 1.5;
					double z = t*Math.sin(theta);
					loc.add(x,y,z);
					ParticleEffect.SMOKE_NORMAL.display(0, 0, 0, 0, 1, loc, 200);
					loc.subtract(x,y,z);
					
					theta = theta + Math.PI/64;
					
					x = t*Math.cos(theta);
					y = 2*Math.exp(-0.1*t) * Math.sin(t) + 1.5;
					z = t*Math.sin(theta);
					loc.add(x,y,z);
					ParticleEffect.VILLAGER_HAPPY.display(0, 0, 0, 0, 1, loc, 200);
					loc.subtract(x,y,z);
				}
				if (t > 20){
					this.cancel();
				}
			}
						
		}.runTaskTimer(Hub.getInstance(), 0, 1);
	}
}
