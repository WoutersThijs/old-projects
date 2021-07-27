package be.thijswouters;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import be.thijswouters.Commands.CommandSetSpawn;
import be.thijswouters.Commands.CommandSpawn;
import be.thijswouters.Files.Files;
import be.thijswouters.Listeners.EventBlockDestroy;
import be.thijswouters.Listeners.EventCommand;
import be.thijswouters.Listeners.EventPlayerDeath;
import be.thijswouters.Listeners.EventPlayerJoin;
import be.thijswouters.SQL.MySQL;

public class KitPvP extends JavaPlugin{
	
	public static KitPvP instance;
	public MySQL mysql;
	
	public void onEnable(){
		instance = this;
		registerLocations();
		registerEvents();
		registerCommands();
	}
	
	public static KitPvP getInstance(){
		return instance;
	}
	
	public void onDisable(){
		mysql.close();
	}
	
	public void ConnectMySQL() {
		mysql = new MySQL("127.0.0.1", "mcuser_66", "mcuser_66", "ea808a49b0");
	    mysql.update("CREATE TABLE IF NOT EXISTS Reply (NAME varchar(17),LAST varchar(17))");
	}
	
	public void registerCommands(){
		getCommand("setspawn").setExecutor(new CommandSetSpawn());
		getCommand("spawn").setExecutor(new CommandSpawn());
	}
	
	public void registerEvents(){
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new EventBlockDestroy(), this);
		pm.registerEvents(new EventPlayerDeath(), this);
		pm.registerEvents(new EventPlayerJoin(), this);
		pm.registerEvents(new EventCommand(), this);
	}
	
	public void registerLocations(){
		if(!Files.locations.contains("Spawn.WORLD"))
			Files.locations.set("Spawn.WORLD", "world");
		
		if(!Files.locations.contains("Spawn.X"))
			Files.locations.set("Spawn.X", 0);
		
		if(!Files.locations.contains("Spawn.Y"))
			Files.locations.set("Spawn.Y", 64);
		
		if(!Files.locations.contains("Spawn.Z"))
			Files.locations.set("Spawn.Z", 0);
		Files.locations.save();
	}
}
