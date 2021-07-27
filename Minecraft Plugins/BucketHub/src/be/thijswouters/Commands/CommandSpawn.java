package be.thijswouters.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import be.thijswouters.SQL.Kits;
import be.thijswouters.Utils.Chat;
import be.thijswouters.Utils.Locations;

public class CommandSpawn implements CommandExecutor{
	
	@SuppressWarnings("unused")
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if (!(sender instanceof Player))
			return false;

		Player p = (Player) sender;
		Player t = Bukkit.getPlayer("ThreshBandicoot");
		
		if(args.length == 0){
			p.teleport(Locations.spawn);
		    return true;
		}
		
		if(!p.hasPermission("bucketcraft.command.teleport.other")){
			Chat.noPermissions(p);
			return false;
		}
		
		if (args.length == 1 && !(args.length >= 2)) {
			Player targetPlayer = Bukkit.getPlayer(args[0]);
			if (targetPlayer == null) {
				Chat.viaSystem(p, "Couldn't find the player §a" + args[0]
						+ "§7!");
				return false;
			}
			targetPlayer.teleport(Locations.spawn);
			return true;
		}else{
			Chat.toMuchArgs(p);
		}
		return false;
	}
}