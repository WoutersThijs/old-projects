package be.thijswouters.Commands;

import java.text.DecimalFormat;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import be.thijswouters.Files.Files;
import be.thijswouters.Utils.Chat;

public class CommandSetLobby implements CommandExecutor{
	
	@SuppressWarnings("unused")
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if (!(sender instanceof Player))
			return false;

		Player p = (Player) sender;
		if(!p.hasPermission("demons.setlobby")){
			Chat.noPermissions(p);
			return false;
		}
		/*Files.locations;
		Files.locations.set("Lobby.WORLD", p.getWorld().getName());
		Files.locations.set("Lobby.X", (double) p.getLocation().getX());
		Files.locations.set("Lobby.Y", (double) p.getLocation().getY());
		Files.locations.set("Lobby.Z", (double) p.getLocation().getZ());
		FileLocations.saveLocations();
		*/
		
		Files.locations.set("Lobby.WORLD", p.getWorld().getName());
		Files.locations.set("Lobby.X", (double) p.getLocation().getX());
		Files.locations.set("Lobby.Y", (double) p.getLocation().getY());
		Files.locations.set("Lobby.Z", (double) p.getLocation().getZ());
		Files.locations.save();
		
		Chat.viaOther(p, "Locations", "Spawn for §aLOBBY §3has been set.");
		Chat.viaOther(p, "World", "" + p.getWorld().getName());
		Chat.viaOther(p, "X", "" + p.getLocation().getX());
		Chat.viaOther(p, "Y", "" + p.getLocation().getY());
		Chat.viaOther(p, "Z", "" + p.getLocation().getZ());
		return false;
	}
}