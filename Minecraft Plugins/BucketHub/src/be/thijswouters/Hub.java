package be.thijswouters;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import be.thijswouters.Commands.CommandSpawn;
import be.thijswouters.Commands.CommandTeleport;
import be.thijswouters.Listeners.EventDoubleJumpMove;
import be.thijswouters.Listeners.EventDoubleJumpToggleFlight;
import be.thijswouters.Listeners.EventEntityDamage;
import be.thijswouters.Listeners.EventEntityTarget;
import be.thijswouters.Listeners.EventInventoryClick;
import be.thijswouters.Listeners.EventPerformCommand;
import be.thijswouters.Listeners.EventPickupItem;
import be.thijswouters.Listeners.EventPlayerDropItem;
import be.thijswouters.Listeners.EventPlayerInteract;
import be.thijswouters.Listeners.EventPlayerJoin;
import be.thijswouters.Listeners.EventPlayerQuit;
import be.thijswouters.Listeners.EventSnowman;
import be.thijswouters.SQL.Kits;
import be.thijswouters.SQL.MySQL;

public class Hub extends JavaPlugin{
	public static Hub instance;
	public MySQL mysql;
	
	/*          
	 * Particles //
	 * Pets //
	 * Morphs //
	 * Wardrobe // 
	 * Gadgets //
	 * Heads //
	 * Music //
	 */
	public void onEnable(){
		instance = this;
		ConnectMySQL();
		setupEvents();
		setupCommands();
	    getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
	}
	
	public static Hub getInstance(){
		return instance;
	}
	
	public void onDisable(){
		mysql.close();
	}
	
	public void ConnectMySQL() {
		mysql = new MySQL("127.0.0.1", "mcuser_66", "mcuser_66", "ea808a49b0");
	    mysql.update("CREATE TABLE IF NOT EXISTS Reply (NAME varchar(17),LAST varchar(17))");
	    mysql.update("CREATE TABLE IF NOT EXISTS Kits (Player varchar(17),dDefault varchar(17),dZombie varchar(17),dSkeleton varchar(17),"
	    		+ "oDefault varchar(17),oMiner varchar(17),oArcher varchar(17))");
	}
	
	public void setupCommands(){
    	getCommand("spawn").setExecutor(new CommandSpawn());
    	getCommand("teleport").setExecutor(new CommandTeleport());
    	getCommand("tp").setExecutor(new CommandTeleport());
	}
	
	public void setupEvents(){
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new EventInventoryClick(), this);
        pm.registerEvents(new EventDoubleJumpMove(), this);
        pm.registerEvents(new EventDoubleJumpToggleFlight(), this);
        pm.registerEvents(new EventPlayerJoin(), this);
        pm.registerEvents(new EventEntityTarget(), this);
        pm.registerEvents(new EventEntityDamage(), this);
        pm.registerEvents(new EventPerformCommand(), this);
        pm.registerEvents(new EventPickupItem(), this);
        pm.registerEvents(new EventSnowman(), this);
        pm.registerEvents(new EventPlayerDropItem(), this);
        pm.registerEvents(new EventPlayerInteract(), this);
        pm.registerEvents(new EventPlayerQuit(), this);
	}
}
