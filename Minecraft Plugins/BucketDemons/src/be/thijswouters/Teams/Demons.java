package be.thijswouters.Teams;

import org.bukkit.entity.Player;

import be.thijswouters.Utils.ArrayLists;
import be.thijswouters.Utils.Chat;

public class Demons {
	
	public static void addPlayer(Player p){
		ArrayLists.teamDemons.add(p);
		Chat.viaTeam(p, "You have been added to team §cDEMONS§3.");
		if(ArrayLists.teamOrcs.contains(p))
			Orcs.removePlayer(p);
		p.setPlayerListName("§c" + p.getName());
	}
	
	public static void removePlayer(Player p){
		ArrayLists.teamDemons.remove(p);
	}
	
	public static void clear(){
		for(Player p : ArrayLists.teamDemons){
			p.setPlayerListName("§7" + p.getName());
		}
		ArrayLists.teamDemons.clear();
	}
}
