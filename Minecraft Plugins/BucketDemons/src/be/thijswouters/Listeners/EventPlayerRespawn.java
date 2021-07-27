package be.thijswouters.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

import be.thijswouters.Files.Files;
import be.thijswouters.Kits.DemonsDefault;
import be.thijswouters.Kits.DemonsSkeleton;
import be.thijswouters.Kits.DemonsZombie;
import be.thijswouters.Kits.OrcsArcher;
import be.thijswouters.Kits.OrcsDefault;
import be.thijswouters.Kits.OrcsMiner;
import be.thijswouters.Utils.ArrayLists;
import be.thijswouters.Utils.GameState;

public class EventPlayerRespawn implements Listener{
	
	@EventHandler
	public void onRespawn(PlayerRespawnEvent e){
		Player p = e.getPlayer();
		if(!GameState.isState(GameState.IN_GAME)){
			String lobbyWorldName = Files.locations.getString("Lobby.WORLD");
			int lobbyX = Files.locations.getInt("Lobby.X");
			int lobbyY = Files.locations.getInt("Lobby.Y");
			int lobbyZ = Files.locations.getInt("Lobby.Z");
			World lobbyWORLD = Bukkit.getServer().getWorld(lobbyWorldName);
			Location lobby = new Location(lobbyWORLD, lobbyX, lobbyY, lobbyZ);
			p.teleport(lobby);
		}
		if(ArrayLists.teamDemons.contains(p)){	
	        if(Files.kits.getString("Kits.Demons.Default." + p.getName()).equalsIgnoreCase("true"))
	        	DemonsDefault.give(p);
	    
	        if(Files.kits.getString("Kits.Demons.Skeleton." + p.getName()).equalsIgnoreCase("true"))
	        	DemonsSkeleton.give(p);
	        
	        if(Files.kits.getString("Kits.Demons.Zombie." + p.getName()).equalsIgnoreCase("true"))
	        	DemonsZombie.give(p);
			String demonWorldName = Files.locations.getString("Demons.WORLD");
			int demonX = Files.locations.getInt("Demons.X");
			int demonY = Files.locations.getInt("Demons.Y");
			int demonZ = Files.locations.getInt("Demons.Z");
			World demonWORLD = Bukkit.getServer().getWorld(demonWorldName);
			Location demon = new Location(demonWORLD, demonX,demonY, demonZ);
			e.setRespawnLocation(demon);
		}
		
		if(ArrayLists.teamOrcs.contains(p)){
	        if(Files.kits.getString("Kits.Orcs.Default." + p.getName()).equalsIgnoreCase("true"))
	        	OrcsDefault.give(p);
	    
	        if(Files.kits.getString("Kits.Orcs.Miner." + p.getName()).equalsIgnoreCase("true"))
	        	OrcsMiner.give(p);
	    
	        if(Files.kits.getString("Kits.Orcs.Archer." + p.getName()).equalsIgnoreCase("true"))
	        	OrcsArcher.give(p);
			String orcsWorldName = Files.locations.getString("Orcs.WORLD");
			int orcsX = Files.locations.getInt("Orcs.X");
			int orcsY = Files.locations.getInt("Orcs.Y");
			int orcsZ = Files.locations.getInt("Orcs.Z");
			World orcsWORLD = Bukkit.getServer().getWorld(orcsWorldName);
			Location orcs = new Location(orcsWORLD, orcsX, orcsY, orcsZ);
			e.setRespawnLocation(orcs);
		}
	}
}
