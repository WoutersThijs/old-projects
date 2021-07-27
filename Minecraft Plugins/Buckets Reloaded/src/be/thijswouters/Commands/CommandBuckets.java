package be.thijswouters.Commands;

import be.thijswouters.SQL.Buckets;
import be.thijswouters.Utils.Chat;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class CommandBuckets extends Command {
	
	public CommandBuckets(){
		super("buckets");
	}
	
	@SuppressWarnings("deprecation")
	public void execute(CommandSender sender, String[] args){
		if(!(sender instanceof ProxiedPlayer))
			return;
		
		ProxiedPlayer p = (ProxiedPlayer) sender;
		
		if(args.length == 0){
			Chat.viaBuckets(p, "You currently have §e" + Buckets.getBuckets(p.getName()) + " §3buckets!");
			return;
		}
		
		if(!p.hasPermission("buckets.admin")){
			p.sendMessage("§b» §6Error §8// §3You don't have enough permissions to execute this command!");
			return;
		}
		
		if(args.length >= 4){
			Chat.viaBuckets(p, "You've specified to much arguments.");
			Chat.viaBuckets(p, "Try §e/buckets help§3.");
			return;
		}
		
		if(args[0].equalsIgnoreCase("add")){
			if(args.length == 1){
				Chat.viaOther(p, "Usage", "/buckets add §6[§ePlayer§6] [§eAmount§6]§3.");
				return;
			}
			
			if(args.length == 2){
				if(isInt(args[1])){
					if(Integer.valueOf(args[1]).intValue() <= 0){
						Chat.viaOther(p, "Error", "You need to specify a number above §e0§3.");
						return;
					}
					
					Buckets.addBuckets(p.getName(), Integer.valueOf(Integer.parseInt(args[1])));
					Chat.viaBuckets(p, "You've added §e" + Integer.parseInt(args[1]) + " §3to your account!");
					return;
				}
				Chat.viaOther(p, "Error", "You need to specify a number!");
				
			} else if(args.length == 3){
				
				ProxiedPlayer target = ProxyServer.getInstance().getPlayer(args[1]);
				
				if(target == null){
					Chat.viaOther(p, "Error", "Couldn't find the player §e'" + args[1] + "'§3.");
					return;
				}
				
				if(isInt(args[2])){
					if(Integer.valueOf(args[2]).intValue() <= 0){
						Chat.viaOther(p, "Error", "You need to specify a number above §e0§3.");
					    return;
					}
				    Buckets.addBuckets(target.getName(), Integer.valueOf(Integer.parseInt(args[2])));
				    Chat.viaBuckets(p, "You've added §e" + Integer.parseInt(args[2]) + " §3to §e" + target.getName() + "'s §3account!");
			    	Chat.viaBuckets(target, "§e" + p.getName() + " §3has added §e" + Integer.parseInt(args[2]) + " to your account!");
				    return;
			    }
				
				Chat.viaOther(p, "Error", "You need to specify a number!");
			}
		}
		
		if(args[0].equalsIgnoreCase("remove")){
			if(args.length == 1){
				Chat.viaOther(p, "Usage", "/buckets remove §6[§ePlayer§6] [§eAmount§6]§3");
				return;
			}
			
			if(args.length == 2){
				if(isInt(args[2])){
					if(Integer.valueOf(args[1]).intValue() <= 0){
						Chat.viaOther(p, "Error", "You need to specify a number above §e0§3.");
						return;
					}
					
					Buckets.removeBuckets(p.getName(),Integer.valueOf(Integer.parseInt(args[1])));
					Chat.viaBuckets(p, "You've removed §e" + Integer.parseInt(args[1]) + " §3from your account!");
					return;
				}
				Chat.viaOther(p, "Error", "You need to specify a number!");
				
			} else if(args.length == 3){
				ProxiedPlayer target = ProxyServer.getInstance().getPlayer(args[1]);
				if(target == null){
					Chat.viaOther(p, "Error", "Couldn't find the player §e'" + args[1] + "'§3.");
					return;
				}
				
				if(isInt(args[2])){
					if(Integer.valueOf(args[2]).intValue() <= 0){
						Chat.viaOther(p, "Error", "You need to specify a number above §e0§3.");
					    return;
					}
				    Buckets.removeBuckets(target.getName(), Integer.valueOf(Integer.parseInt(args[2])));
				    Chat.viaBuckets(p, "You've removed §e" + Integer.parseInt(args[2]) + " §3from §e" + target.getName() + "'s §3account!");
			    	Chat.viaBuckets(target, "§e" + p.getName() + " §3has removed §e" + Integer.parseInt(args[2]) + " from your account!");
				    return;
			    }
				
				Chat.viaOther(p, "Error", "You need to specify a number!");
			}
		}
		
		if(args[0].equalsIgnoreCase("set")){
			if(args.length == 1){
				Chat.viaOther(p, "Usage", "/buckets set §6[§ePlayer§6] [§eAmount§6]§3.");
				return;
			}
			
			if(args.length == 2){
				if(isInt(args[2])){
					if(Integer.valueOf(args[1]).intValue() < 0){
						Chat.viaOther(p, "Error", "You need to specify a number above §e-1§3.");
						return;
					}
					
					Buckets.setBuckets(p.getName(),Integer.valueOf(Integer.parseInt(args[1])));
					Chat.viaBuckets(p, "You've set your buckets to §e" + Integer.parseInt(args[1]) + "§3!");
					return;
				}
				Chat.viaOther(p, "Error", "You need to specify a number!");
				
			} else if(args.length == 3){
				ProxiedPlayer target = ProxyServer.getInstance().getPlayer(args[1]);
				if(target == null){
					Chat.viaOther(p, "Error", "Couldn't find the player §e'" + args[1] + "'§3.");
					return;
				}
				
				if(isInt(args[2])){
					if(Integer.valueOf(args[2]).intValue() <= 0){
						Chat.viaOther(p, "Error", "You need to specify a number above §e0§3.");
					    return;
					}
				    Buckets.setBuckets(target.getName(), Integer.valueOf(Integer.parseInt(args[2])));
				    Chat.viaBuckets(p, "You've set §e" + target.getName() + "'s §3buckets to §e"+ Integer.parseInt(args[2]) + "§3!");
			    	Chat.viaBuckets(target, "§e" + p.getName() + " §3has set your buckets to §e" + Integer.parseInt(args[2]) + "§3!");
				    return;
			    }
				
				Chat.viaOther(p, "Error", "You need to specify a number!");
			} 
		} else {
			Chat.viaOther(p, "Error", "§e'" + args[0] + "' §3is not a valid argument!");
		}
	}
	
	public boolean isInt(String s){
		try{
			Integer.parseInt(s);
		} catch (NumberFormatException e){
			return false;
		}
		return true;
	}
}
