package be.thijswouters;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.sun.xml.internal.stream.Entity;

import be.thijswouters.Commands.CommandPing;
import be.thijswouters.Commands.CommandSetLobby;
import be.thijswouters.Commands.CommandSetNexus;
import be.thijswouters.Commands.CommandSetRespawn;
import be.thijswouters.Commands.CommandSetSpectator;
import be.thijswouters.Commands.CommandSkipTimer;
import be.thijswouters.Commands.CommandStart;
import be.thijswouters.Commands.CommandSwapTeam;
import be.thijswouters.Files.Files;
import be.thijswouters.Listeners.EventBlockDestroy;
import be.thijswouters.Listeners.EventCommand;
import be.thijswouters.Listeners.EventEntityDamage;
import be.thijswouters.Listeners.EventEntityDamageByEntity;
import be.thijswouters.Listeners.EventFoodLevelChange;
import be.thijswouters.Listeners.EventInventoryClick;
import be.thijswouters.Listeners.EventLogin;
import be.thijswouters.Listeners.EventPlayerChat;
import be.thijswouters.Listeners.EventPlayerDeath;
import be.thijswouters.Listeners.EventPlayerDropItem;
import be.thijswouters.Listeners.EventPlayerInteract;
import be.thijswouters.Listeners.EventPlayerJoin;
import be.thijswouters.Listeners.EventPlayerMove;
import be.thijswouters.Listeners.EventPlayerQuit;
import be.thijswouters.Listeners.EventPlayerRespawn;
import be.thijswouters.SQL.MySQL;
import be.thijswouters.SQL.State;
import be.thijswouters.Scoreboards.GameScoreboard;
import be.thijswouters.Scoreboards.LobbyScoreboard;
import be.thijswouters.Utils.GameState;

public class DemonsCore extends JavaPlugin{
	
	public static DemonsCore instance;
	public MySQL mysql;
	
	public void onDisable(){
		GameState.setState(GameState.IN_LOBBY);
		mysql.close();
	}
	
	public void onEnable(){
	    getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
		for(Player p : Bukkit.getOnlinePlayers())
			p.kickPlayer("§9§lDemons ►> §7The game has been forced to stop.");
		instance = this;
		ConnectMySQL();
		registerEvents();
		registerCommands();
		LobbyScoreboard.setupScoreboard();
		GameScoreboard.setupScoreboard();
		registerLocations(); 
		registerKits();
		GameState.setState(GameState.IN_LOBBY);
		setNexus();
	}
	
	public void registerEvents(){
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new EventPlayerJoin(), this);
		pm.registerEvents(new EventFoodLevelChange(), this);
		pm.registerEvents(new EventInventoryClick(), this);
		pm.registerEvents(new EventPlayerDropItem(), this);
		pm.registerEvents(new EventPlayerDeath(), this);
		pm.registerEvents(new EventPlayerQuit(), this);
		pm.registerEvents(new EventEntityDamage(), this);
		pm.registerEvents(new EventPlayerRespawn(), this);
		pm.registerEvents(new EventBlockDestroy(), this);
		pm.registerEvents(new EventLogin(), this);
		pm.registerEvents(new EventEntityDamageByEntity(), this);
		pm.registerEvents(new EventPlayerChat(), this);
		pm.registerEvents(new EventCommand(), this);
		pm.registerEvents(new EventPlayerInteract(), this);
		pm.registerEvents(new EventPlayerMove(), this);
	}
	
	public void ConnectMySQL() {
		mysql = new MySQL("127.0.0.1", "mcuser_66", "mcuser_66", "ea808a49b0");
	    mysql.update("CREATE TABLE IF NOT EXISTS Reply (NAME varchar(17),LAST varchar(17))");
	    mysql.update("CREATE TABLE IF NOT EXISTS State (STATE varchar(17),SERVER varchar(3))");
	}
	
	public void registerKits(){
		if(!Files.kits.contains("Kits.Orcs.Default")){
			Files.kits.set("Kits.Orcs.Default.Loaded", "YES SIR");
		}
		
		if(!Files.kits.contains("Kits.Orcs.Miner")){
			Files.kits.set("Kits.Orcs.Miner.Loaded", "YES SIR");
		}
		
		if(!Files.kits.contains("Kits.Orcs.Archer")){
			Files.kits.set("Kits.Orcs.Archer.Loaded", "YES SIR");
		}
		
		if(!Files.kits.contains("Kits.Demons.Default")){
			Files.kits.set("Kits.Demons.Default.Loaded", "YES SIR");
		}
		
		if(!Files.kits.contains("Kits.Demons.Skeleton")){
			Files.kits.set("Kits.Demons.Skeleton.Loaded", "YES SIR");
		}
		
		if(!Files.kits.contains("Kits.Demons.Zombie")){
			Files.kits.set("Kits.Demons.Zombie.Loaded", "YES SIR");
		}
		
		Files.kits.save();
	}
	
	public void registerLocations(){
			if(!Files.locations.contains("Lobby.WORLD"))
				Files.locations.set("Lobby.WORLD", "world");
			
			if(!Files.locations.contains("Lobby.X"))
				Files.locations.set("Lobby.X", 0);
			
			if(!Files.locations.contains("Lobby.Y"))
				Files.locations.set("Lobby.Y", 64);
			
			if(!Files.locations.contains("Lobby.Z"))
				Files.locations.set("Lobby.Z", 0);
			
			if(!Files.locations.contains("Nexus.WORLD"))
				Files.locations.set("Nexus.WORLD", "world");
			
			if(!Files.locations.contains("Nexus.X"))
				Files.locations.set("Nexus.X", 0);
			
			if(!Files.locations.contains("Nexus.Y"))
				Files.locations.set("Nexus.Y", 64);
			
			if(!Files.locations.contains("Nexus.Z"))
				Files.locations.set("Nexus.Z", 0);
			
			if(!Files.locations.contains("Demons.WORLD"))
				Files.locations.set("Demons.WORLD", "world");
			
			if(!Files.locations.contains("Demons.X"))
				Files.locations.set("Demons.X", 0);
			
			if(!Files.locations.contains("Demons.Y"))
				Files.locations.set("Demons.Y", 64);
			
			if(!Files.locations.contains("Demons.Z"))
				Files.locations.set("Demons.Z", 0);
			
			if(!Files.locations.contains("Orcs.WORLD"))
				Files.locations.set("Orcs.WORLD", "world");
			
			if(!Files.locations.contains("Orcs.X"))
				Files.locations.set("Orcs.X", 0);
			
			if(!Files.locations.contains("Orcs.Y"))
				Files.locations.set("Orcs.Y", 64);
			
			if(!Files.locations.contains("Orcs.Z"))
				Files.locations.set("Orcs.Z", 0);
			
			if(!Files.locations.contains("Spectator.X"))
				Files.locations.set("Spectator.X", 0);
			
			if(!Files.locations.contains("Spectator.Y"))
				Files.locations.set("Spectator.Y", 0);
			
			if(!Files.locations.contains("Spectator.Z"))
				Files.locations.set("Spectator.Z", 0);
			
			if(!Files.locations.contains("Spectator.WORLD"))
				Files.locations.set("Spectator.X", "world");
			
			Files.locations.save();
	}
	
	public void registerCommands(){
		getCommand("swapteam").setExecutor(new CommandSwapTeam());
		getCommand("swap").setExecutor(new CommandSwapTeam());
		getCommand("setlobby").setExecutor(new CommandSetLobby());
		getCommand("setrespawn").setExecutor(new CommandSetRespawn());
		getCommand("setnexus").setExecutor(new CommandSetNexus());
		getCommand("skiptimer").setExecutor(new CommandSkipTimer());
		getCommand("ping").setExecutor(new CommandPing());
		getCommand("start").setExecutor(new CommandStart());
		getCommand("setspectator").setExecutor(new CommandSetSpectator());
		getCommand("setspec").setExecutor(new CommandSetSpectator());
	}
	
	public static DemonsCore getInstance(){
		return instance;
		
	}
	
	@SuppressWarnings("deprecation")
	public static void setNexus(){
		String nexusWorldName = Files.locations.getString("Nexus.WORLD");
		int nexusX = Files.locations.getInt("Nexus.X");
		int nexusY = Files.locations.getInt("Nexus.Y");
		int nexusZ = Files.locations.getInt("Nexus.Z");
		World lobbyWORLD = Bukkit.getServer().getWorld(nexusWorldName);
		Location nexus = new Location(lobbyWORLD, nexusX, nexusY, nexusZ);
		
		Bukkit.getServer().getWorld(nexusWorldName).getBlockAt(nexus).setType(Material.ENDER_STONE);
	}
}
