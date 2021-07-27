package be.thijswouters.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import be.thijswouters.Files.Files;
import be.thijswouters.Utils.Chat;

public class CommandSpawn implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if (!(sender instanceof Player))
			return false;

		Player p = (Player) sender;
		String spawnWorldName = Files.locations.getString("Spawn.WORLD");
		int spawnX = Files.locations.getInt("Spawn.X");
		int spawnY = Files.locations.getInt("Spawn.Y");
		int spawnZ = Files.locations.getInt("Spawn.Z");
		World spawnWORLD = Bukkit.getServer().getWorld(spawnWorldName);
		Location spawn = new Location(spawnWORLD, spawnX + .547, spawnY, spawnZ + .523);
		p.teleport(spawn);
		return false;
	}
}