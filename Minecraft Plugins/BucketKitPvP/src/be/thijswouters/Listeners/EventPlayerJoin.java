package be.thijswouters.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import be.thijswouters.Files.Files;

public class EventPlayerJoin implements Listener{
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		String spawnWorldName = Files.locations.getString("Spawn.WORLD");
		int spawnX = Files.locations.getInt("Spawn.X");
		int spawnY = Files.locations.getInt("Spawn.Y");
		int spawnZ = Files.locations.getInt("Spawn.Z");
		World spawnWORLD = Bukkit.getServer().getWorld(spawnWorldName);
		Location spawn = new Location(spawnWORLD, spawnX + .547, spawnY, spawnZ + .523);
		p.teleport(spawn);
	}
}
