package be.thijswouters.Utils;

import net.md_5.bungee.api.connection.ProxiedPlayer;

public class Chat {
	
	@SuppressWarnings("deprecation")
	public static void viaBuckets(ProxiedPlayer p, String msg){
		p.sendMessage("§b» §6Buckets §8// §3" + msg);
	}
	
	@SuppressWarnings("deprecation")
	public static void viaUsage(ProxiedPlayer p, String msg){
		p.sendMessage("§» §6Usage §8// §3" + msg);
	}
	
	@SuppressWarnings("deprecation")
	public static void viaOther(ProxiedPlayer p, String prefix, String msg){
		p.sendMessage("§b» §6" + prefix + " §8// §3" + msg);
	}
}
