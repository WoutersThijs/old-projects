package be.thijswouters.Commands;

import be.thijswouters.SQL.Reply;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class CommandReply extends Command{
	
	public CommandReply(){
		super("reply", "reply.use", "r", "re", "rep");
	}
	
	public String message(String[] args) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < args.length; i++) {
		builder.append(args[i]);
		builder.append(" ");
		}
		return builder.toString().trim();
	}
	
	
	@SuppressWarnings("deprecation")
	@Override
	public void execute(CommandSender sender, String [] args){
		if(args.length < 1){
			sender.sendMessage("§b» §6Usage §8// §3/reply §6[§eMessage§6]§3.");
			return;
		}
		
		ProxiedPlayer p = ProxyServer.getInstance().getPlayer(Reply.getLast(sender.getName()));
		
		if(p == null){
			sender.sendMessage("§b» §6Error §8// §3Player §6'§eERROR§6'§3 is not online.");
			return;
		}

		p.sendMessage("§e" + sender.getName() + " §6» §eYou §8// §3" + message(args));
		sender.sendMessage("§eYou §6» §e" + p.getName() + " §8// §3" + message(args));
		
		ProxiedPlayer thresh = ProxyServer.getInstance().getPlayer("ThreshBandicoot");
		ProxiedPlayer kil = ProxyServer.getInstance().getPlayer("Killyantjuhh");
		ProxiedPlayer wieg = ProxyServer.getInstance().getPlayer("wiegerwww");
		ProxiedPlayer seb = ProxyServer.getInstance().getPlayer("ProLeagueGaming");
		if(thresh != null){
			if(!sender.getName().equalsIgnoreCase("ThreshBandicoot") && !p.getName().equalsIgnoreCase("ThreshBandicoot")){
				thresh.sendMessage("§e" + sender.getName() + " §b» §e" + p.getName() + " §8// §3" + message(args));
			}
		}
		
		if(kil != null){
			if(!sender.getName().equalsIgnoreCase("Killyantjuhh") && !p.getName().equalsIgnoreCase("Killyantjuhh")){
				kil.sendMessage("§e" + sender.getName() + " §b» §e" + p.getName() + " §8// §3" + message(args));
			}
		}
		
		if(wieg != null){
			if(!sender.getName().equalsIgnoreCase("wiegerwww") && !p.getName().equalsIgnoreCase("wiegerwww")){
				wieg.sendMessage("§e" + sender.getName() + " §b» §e" + p.getName() + " §8// §3" + message(args));
			}
		}
		
		if(seb != null){
			if(!sender.getName().equalsIgnoreCase("ProLeagueGaming") && !p.getName().equalsIgnoreCase("ProLeagueGaming")){
				seb.sendMessage("§e" + sender.getName() + " §b» §e" + p.getName() + " §8// §3" + message(args));
			}
		}
	}	
}
