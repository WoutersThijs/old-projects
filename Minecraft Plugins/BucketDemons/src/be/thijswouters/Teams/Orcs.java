package be.thijswouters.Teams;

import org.bukkit.entity.Player;

import be.thijswouters.Utils.ArrayLists;
import be.thijswouters.Utils.Chat;

public class Orcs {
	
	public static void addPlayer(Player p){
		ArrayLists.teamOrcs.add(p);
		Chat.viaTeam(p, "You have been added to team §aORCS§3.");
		if(ArrayLists.teamDemons.contains(p))
			Demons.removePlayer(p);
		p.setPlayerListName("§a" + p.getName());
	}
	
	public static void removePlayer(Player p){
		ArrayLists.teamOrcs.remove(p);
	}
	
	public static void clear(){
		for(Player p : ArrayLists.teamOrcs){
			p.setPlayerListName("§7" + p.getName());
		}
		ArrayLists.teamOrcs.clear();
	}
}
