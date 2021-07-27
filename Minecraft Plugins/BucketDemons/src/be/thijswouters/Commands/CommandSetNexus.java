package be.thijswouters.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import be.thijswouters.Files.Files;
import be.thijswouters.Utils.Chat;

public class CommandSetNexus implements CommandExecutor{
	
	@SuppressWarnings("unused")
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if (!(sender instanceof Player))
			return false;

		Player p = (Player) sender;
		if(!p.hasPermission("demons.setnexus")){
			Chat.noPermissions(p);
			return false;
		}
		
		Files.locations.set("Nexus.WORLD", p.getWorld().getName());
		Files.locations.set("Nexus.X", (double) p.getEyeLocation().getX());
		Files.locations.set("Nexus.Y", (double) p.getEyeLocation().getY());
		Files.locations.set("Nexus.Z", (double) p.getEyeLocation().getZ());
		Files.locations.save();
		
		Chat.viaOther(p, "Locations", "The §eNEXUS §3has been set.");
		Chat.viaOther(p, "World", "" + p.getWorld().getName());
		Chat.viaOther(p, "X", "" + p.getLocation().getX());
		Chat.viaOther(p, "Y", "" + p.getLocation().getY());
		Chat.viaOther(p, "Z", "" + p.getLocation().getZ());
		return false;
	}
}