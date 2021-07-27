package be.thijswouters;

import be.thijswouters.Commands.CommandBuckets;
import be.thijswouters.SQL.MySQL;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;

public class BucketsCore extends Plugin{
	
	public MySQL mysql;
	public static BucketsCore instance;
	
	public void onEnable(){
		instance = this;
		ConnectMySQL();
		registerCommands();
	}
	
	public void registerCommands(){
	    ProxyServer.getInstance().getPluginManager().registerCommand(this, new CommandBuckets());
	}
	
	public void onDisable(){
		mysql.close();
	}
	
	public void ConnectMySQL() {
		mysql = new MySQL("127.0.0.1", "mcuser_66", "mcuser_66", "ea808a49b0");
	    mysql.update("CREATE TABLE IF NOT EXISTS Buckets (NAME varchar(17),BUCKETS int)");
	}
	
	public static BucketsCore getInstance(){
		return instance;
	}
}
