package be.thijswouters.Utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Chat {
	
	public static void noPermissions(Player p){
		p.sendMessage("§b» §eBucket§6Craft §8// §3You don't have enough permissions to execute this command!");
	}
	
	public static void viaSystem(Player p, String msg){
		p.sendMessage("§b» §6System §8// §3" + msg);
	}
	
	public static void viaServer(Player p, String msg){
		p.sendMessage("§b» §e6Server §8// §3" + msg);
	}
	
	public static void viaVanity(Player p, String msg){
		p.sendMessage("§b» §6Vanity §8// §3" + msg);
	}
	
	public static void viaTeam(Player p, String msg){
		p.sendMessage("§b» §6Team §8// §3" + msg);
	}
	
	public static void notEnoughArgs(Player p){
		p.sendMessage("§b» §eBucket§6Craft §8// §3You didn't specify enough arguments!");
	}
	
	public static void viaOther(Player p, String prefix, String msg){
		p.sendMessage("§b» §6" + prefix + " §8// §3" + msg);
	}
	
	public static void toMuchArgs(Player p){
		p.sendMessage("§b» §6System §8// §3You've specified to much arguments!");
	}
	
	public static void broadcast(String prefix, String msg){
		for(Player p : Bukkit.getOnlinePlayers()){
			p.sendMessage("§b» §6" + prefix + " §8// §3" + msg);
		}
	}
}
