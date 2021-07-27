package be.thijswouters.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import be.thijswouters.Files.Files;
import be.thijswouters.Schedulers.LobbyTimer;
import be.thijswouters.Utils.Chat;

public class CommandSetRespawn implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if (!(sender instanceof Player))
			return false;

		Player p = (Player) sender;
		if(!p.hasPermission("demons.setrespawn")){
			Chat.noPermissions(p);
			return false;
		}
		
		if(args.length == 0){
			Chat.viaOther(p, "Usage", "/setrespawn §a§l[§7Team§a§l]");
			return true;
		}
		
		if(args.length > 1){
			Chat.toMuchArgs(p);
			return false;
		}
		
		if(args[0].equalsIgnoreCase("Demons")){
			Files.locations.set("Demons.WORLD", p.getWorld().getName());
			Files.locations.set("Demons.X", (double) p.getLocation().getX());
			Files.locations.set("Demons.Y", (double) p.getLocation().getY());
			Files.locations.set("Demons.Z", (double) p.getLocation().getZ());
			Files.locations.save();
			
			Chat.viaOther(p, "Locations", "Spawn for §cDEMONS §3has been set.");
			Chat.viaOther(p, "World", "" + p.getWorld().getName());
			Chat.viaOther(p, "X", "" + p.getLocation().getX());
			Chat.viaOther(p, "Y", "" + p.getLocation().getY());
			Chat.viaOther(p, "Z", "" + p.getLocation().getZ());
			return true;
		}
		
		if(args[0].equalsIgnoreCase("Orcs")){
			Files.locations.set("Orcs.WORLD", p.getWorld().getName());
			Files.locations.set("Orcs.X", (double) p.getLocation().getX());
			Files.locations.set("Orcs.Y", (double) p.getLocation().getY());
			Files.locations.set("Orcs.Z", (double) p.getLocation().getZ());
			Files.locations.save();
			
			Chat.viaOther(p, "Locations", "Spawn for §aORCS §3has been set.");
			Chat.viaOther(p, "World", "" + p.getWorld().getName());
			Chat.viaOther(p, "X", "" + p.getLocation().getX());
			Chat.viaOther(p, "Y", "" + p.getLocation().getY());
			Chat.viaOther(p, "Z", "" + p.getLocation().getZ());
			return true;
		}
		
		Chat.viaServer(p, "Couldn't find the team §e" + args[0] + "§3.");
		
		return false;
	}
}