package be.thijswouters.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import be.thijswouters.Files.Files;
import be.thijswouters.Utils.Chat;

public class CommandSetSpectator implements CommandExecutor{
	
	@SuppressWarnings("unused")
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if (!(sender instanceof Player))
			return false;

		Player p = (Player) sender;
		if(!p.hasPermission("demons.setspectator")){
			Chat.noPermissions(p);
			return false;
		}
		
		Files.locations.set("Spectator.WORLD", p.getWorld().getName());
		Files.locations.set("Spectator.X", (double) p.getLocation().getX());
		Files.locations.set("Spectator.Y", (double) p.getLocation().getY());
		Files.locations.set("Spectator.Z", (double) p.getLocation().getZ());
		Files.locations.save();
		
		Chat.viaOther(p, "Locations", "Spawn for §7SPECTATOR §3has been set.");
		Chat.viaOther(p, "World", "" + p.getWorld().getName());
		Chat.viaOther(p, "X", "" + p.getLocation().getX());
		Chat.viaOther(p, "Y", "" + p.getLocation().getY());
		Chat.viaOther(p, "Z", "" + p.getLocation().getZ());
		return false;
	}
}