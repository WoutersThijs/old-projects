package be.thijswouters.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import be.thijswouters.Files.Files;
import be.thijswouters.Utils.Chat;

public class CommandSetSpawn implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if (!(sender instanceof Player))
			return false;

		Player p = (Player) sender;
		if(!p.hasPermission("kitpvp.setspawn")){
			Chat.noPermissions(p);
			return false;
		}
		
		Files.locations.set("Spawn.WORLD", p.getWorld().getName());
		Files.locations.set("Spawn.X", (double) p.getLocation().getX());
		Files.locations.set("Spawn.Y", (double) p.getLocation().getY());
		Files.locations.set("Spawn.Z", (double) p.getLocation().getZ());
		Files.locations.save();
		
		Chat.viaOther(p, "Locations", "Spawn for §a§lKITPVP §7has been set.");
		Chat.viaOther(p, "World", "" + p.getWorld().getName());
		Chat.viaOther(p, "X", "" + p.getLocation().getX());
		Chat.viaOther(p, "Y", "" + p.getLocation().getY());
		Chat.viaOther(p, "Z", "" + p.getLocation().getZ());
		return false;
	}
}